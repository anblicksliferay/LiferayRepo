/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.astra.anblicks.pdca.portlet.cla;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

import com.astra.anblicks.pdca.constants.PDCAPortletKeys;
import com.astra.anblicks.pdca.dto.NamedObject;
import com.astra.anblicks.pdca.dto.ReportForCpDto;
import com.astra.anblicks.pdca.dto.ReportForEM_Ol3;
import com.astra.anblicks.pdca.dto.ReportForEM_OlAdj;
import com.astra.anblicks.pdca.dto.ReportForFYDto;
import com.astra.anblicks.pdca.dto.ReportForPRM_Ol3;
import com.astra.anblicks.pdca.dto.ReportForPRM_OlAdj;
import com.astra.anblicks.pdca.dto.Reportdto;
import com.astra.anblicks.pdca.model.cla_kpi;
import com.astra.anblicks.pdca.model.kpi;
import com.astra.anblicks.pdca.model.tradingProfit;
import com.astra.anblicks.pdca.service.cla_kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.companyLocalServiceUtil;
import com.astra.anblicks.pdca.service.kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.periodLocalServiceUtil;
import com.astra.anblicks.pdca.service.tradingProfitLocalServiceUtil;
import com.astra.anblicks.pdca.services.sql.PdcaMySqlConnection;
import com.astra.anblicks.pdca.services.sql.PdcaSqlQueries;
import com.astra.anblicks.pdca.utils.ExcelUtils;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=AstraPDCA",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.display-name=Reports",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.name=" + PDCAPortletKeys.Cla_Reports,
        "javax.portlet.init-param.view-template=/reports/view.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

/**
 * 
 * @author N.Kranthi Kumar
 *
 */
public class Reports extends MVCPortlet {

	private static Log logger = LogFactoryUtil.getLog(Reports.class.getName());
	public static Connection conn = PdcaMySqlConnection.getConnection();
	
	
	
	/** 
	 * Ajax Method From Jsp
	 * To Return Back the JsonString of Downloaded Url and Relevant Report Data to Jsp
	 * 
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String reportId = ParamUtil.getString(resourceRequest, "reportId");
		String periodId = ParamUtil.getString(resourceRequest, "periodId");
		String year = ParamUtil.getString(resourceRequest, "year");
		
		String reportData = getFile(Integer.parseInt(reportId),Long.parseLong(periodId),Long.parseLong(year),resourceRequest,resourceResponse);
        
		 try {
			writeJSON(resourceRequest, resourceResponse,JSONFactoryUtil.createJSONObject(reportData) );
		} catch (JSONException e) {
			e.printStackTrace();
		} 
        
		
		
		logger.info("Report : "+reportId+" Period :"+periodId+" Year : "+year);
        
        logger.info("reportDownloadUrl :"+reportData);
	}
	
	
	
	
	
	/**
	 * Method is to get the relevant file from Document & Media Library to generate relevant Report
	 * @param year 
	 * @param reportId,periodId,resourceRequest,resourceResponse
	 * @return Json String of Download Url and Report Data Object
	 * @throws FileNotFoundException,IOException
	 *
	 */
	private String getFile(int reportId,long periodId,long year, ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws FileNotFoundException, IOException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long repositoryId = themeDisplay.getScopeGroupId();
			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
					PDCAPortletKeys.AstraParentFolderName);
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(),
					PDCAPortletKeys.AstraSampleExcel);
			File file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), "", true);
			boolean isFolderExist = isFolderExist(themeDisplay, PDCAPortletKeys.CLAFolderName);
			if (!isFolderExist) {
				createFolder(resourceRequest, themeDisplay, PDCAPortletKeys.CLAFolderName);
			}
			Folder rootfolder = getFolder(themeDisplay, PDCAPortletKeys.CLAFolderName);
			switch (reportId) {
			case 1:
				return reportForTPBreakdown(themeDisplay, resourceRequest, rootfolder, fileEntry, file, periodId, year);
			case 2:
				return reportForFullYear(themeDisplay, resourceRequest, rootfolder, fileEntry, file, reportId, year);
			case 3:
				return reportForCp(themeDisplay, resourceRequest, rootfolder, fileEntry, file, reportId, year);
			case 4:
				if(periodId == 3) {
					return reportForEM_OlAdj(themeDisplay, resourceRequest, rootfolder, fileEntry, file, reportId, year);
				}
				else if(periodId == 4) {
					return reportForEM_Ol3(themeDisplay, resourceRequest, rootfolder, fileEntry, file, reportId, year);
				}
			case 5:
				if(periodId == 3) {
					return reportForPRM_OlAdj(themeDisplay, resourceRequest, rootfolder, fileEntry, file, reportId, year);
				}
				else if(periodId == 4) {
					return reportForPRM_Ol3(themeDisplay, resourceRequest, rootfolder, fileEntry, file, reportId, year);
				}
				

			default:
				break;
			}
		} catch (Exception e) {
		}
		
		return "";

	}


	





	/**
	 * Method for Implementation of Report For TP_BreakDown
	 * @param themeDisplay,resourceRequest,rootfolder,fileEntry,file,periodId,year
	 * @throws PortalException
	 * @return Json String of Download Url and Relevent Report Json Data 
	 * 
	 */
	private String reportForTPBreakdown(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file, long periodId, long year) throws PortalException {
		
		
		long timeNow = System.currentTimeMillis();
		int rowIndex = 1;
		int starIndex = 0;
		final long latest = timeNow;
		String PeriodName = periodLocalServiceUtil.getperiod(periodId).getPeriodName();
		String title = "Report_TP_BreakDown_"+PeriodName+"_"+year+"_"+latest;
		String description = PDCAPortletKeys.TPBreakDown_Desc;
		String url = null;
		
		
		List<tradingProfit> TradeProfitList = getTradingProfitByPeriod_Year(periodId, year);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TP_Breakdown Report");

		int columnCount = 0;
		Row headerRow = sheet.createRow(starIndex++);
		for (String headerName : PDCAPortletKeys.TP_BreakDown_HeaderNames) {
			Cell cell = headerRow.createCell(columnCount++);
			cell.setCellValue(headerName);
		}
		
		for( tradingProfit tpb : TradeProfitList) {
			String TradingProfitjsonDataArray = getTradingProfitValueAndTotalOneOff(tpb);
			JSONObject Tdp_Converted_Json = JSONFactoryUtil.createJSONObject(TradingProfitjsonDataArray);
			Row row = sheet.createRow(starIndex++);
			row.createCell(0).setCellValue(rowIndex);
			row.createCell(1).setCellValue(companyLocalServiceUtil.getcompany(tpb.getCompanyId()).getCompanyName());
			row.createCell(2).setCellValue(tpb.getNpat());
			row.createCell(3).setCellValue(tpb.getNetForex());
			row.createCell(4).setCellValue(tpb.getPpeDispos());
			row.createCell(5).setCellValue(tpb.getRevalutionOnPropertyInvestment());
			row.createCell(6).setCellValue(tpb.getInvestment());
			row.createCell(7).setCellValue(tpb.getTaxExpense());
			row.createCell(8).setCellValue(tpb.getImpairmentOnAsset());
			row.createCell(9).setCellValue(tpb.getOthers());
			row.createCell(10).setCellValue(Tdp_Converted_Json.getDouble("Total"));
			row.createCell(11).setCellValue(Tdp_Converted_Json.getDouble("TradingProfit"));	
			rowIndex++;
		}  
		
		  FileOutputStream outputStream;
		  try {
			outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (IOException e1 ) {
			e1.printStackTrace();
		}
		  ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),resourceRequest);
		  FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),rootfolder.getFolderId(), fileEntry.getFileName(),fileEntry.getMimeType(), title, description, "", file, serviceContext);
		  url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() +"/documents/" + themeDisplay.getScopeGroupId() + "/" +addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		  System.out.println(url);
		  JSONObject reportdata = JSONFactoryUtil.createJSONObject();
		  reportdata.put("URL", url);
		  //TODO pass the list to json 
		  return reportdata.toString();
	}
	
	
	/**
	 * Method for Implementation of Report For FullYear
	 * @param year2 
	 * @param themeDisplay,resourceRequest,rootfolder,fileEntry,file,year
	 * @return 
	 * @throws PortalException
	 * @return Json String of Download Url and Relevent Report Json Data 
	 * 
	 */
	private String reportForFullYear(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file, int reportId, long year) throws PortalException {
		
				long timeNow = System.currentTimeMillis();
				final long latest = timeNow;
				String title = "Report_FullYear_"+"_"+year+"_"+latest;
				String description = PDCAPortletKeys.FullYear_Desc;
				String url = null; 
				
				List<NamedObject<Map<Long, List<Reportdto>>>> reportForFullYearData = PdcaSqlQueries.getReportForFullYearData(conn, reportId, year);
				List<ReportForFYDto> FullYearData = setvaluesForFullYearData(reportForFullYearData);
				
				
				ExcelUtils.writeToExcel(file, FullYearData,PDCAPortletKeys.FullYear_HeaderNames);
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),resourceRequest);
				FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),rootfolder.getFolderId(), fileEntry.getFileName(),fileEntry.getMimeType(), title, description, "", file, serviceContext);
				url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() +"/documents/" + themeDisplay.getScopeGroupId() + "/" +addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
				System.out.println(url);
				JSONObject reportdata = JSONFactoryUtil.createJSONObject();
				reportdata.put("URL", url);
				  //TODO pass the list to json 
				return reportdata.toString();
	}	
	
	
	private String reportForCp(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file, int reportId, long year) throws PortalException {
		
		long timeNow = System.currentTimeMillis();
		final long latest = timeNow;
		String title = "Report_CP_Ol3_"+"_"+year+"_"+latest;
		String description = PDCAPortletKeys.CP_Desc;
		String url = null; 
		
		Map<Long, List<Reportdto>> reportForCPData = PdcaSqlQueries.getReportForCP(conn, reportId, year);
		
		List<ReportForCpDto> CPData = setvaluesForCPData(reportForCPData,year);
		
		ExcelUtils.writeToExcel(file, CPData,PDCAPortletKeys.CP_HeaderNames);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),resourceRequest);
		FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),rootfolder.getFolderId(), fileEntry.getFileName(),fileEntry.getMimeType(), title, description, "", file, serviceContext);
		url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() +"/documents/" + themeDisplay.getScopeGroupId() + "/" +addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		System.out.println(url);
		JSONObject reportdata = JSONFactoryUtil.createJSONObject();
		reportdata.put("URL", url);
		  //TODO pass the list to json 
		return reportdata.toString();
	}
	
	private String reportForEM_Ol3(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file, int reportId, long year) throws PortalException {
		long timeNow = System.currentTimeMillis();
		final long latest = timeNow;
		String title = "Report_EM_OL3"+"_"+year+"_"+latest;
		String description = PDCAPortletKeys.EM_OL3_Desc;
		String url = null;
		
		List<NamedObject<Map<Long, List<Reportdto>>>> reportForEM_OL3 = PdcaSqlQueries.getReportForFullYearData(conn, reportId, year);
		List<ReportForEM_Ol3> EM_Ol3Data = setvaluesForEM_Ol3(reportForEM_OL3);
		
        ExcelUtils.writeToExcel(file, EM_Ol3Data, PDCAPortletKeys.EM_OL3_HeaderNames);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),resourceRequest);
		FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),rootfolder.getFolderId(), fileEntry.getFileName(),fileEntry.getMimeType(), title, description, "", file, serviceContext);
		url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() +"/documents/" + themeDisplay.getScopeGroupId() + "/" +addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		System.out.println(url);
		JSONObject reportdata = JSONFactoryUtil.createJSONObject();
		reportdata.put("URL", url);
		  //TODO pass the list to json 
		return reportdata.toString();
		
	}

	 private String reportForEM_OlAdj(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file, int reportId, long year) throws PortalException {	
		long timeNow = System.currentTimeMillis();
		final long latest = timeNow;
		String title = "Report_EM_OLAdj"+"_"+year+"_"+latest;
		String description = PDCAPortletKeys.EM_OLAdj_Desc;
		String url = null;
		
		List<NamedObject<Map<Long, List<Reportdto>>>> reportforEM_OlAdjData = PdcaSqlQueries.getReportForEM_OlAdj(conn, reportId, year);
		List<ReportForEM_OlAdj> EM_OlAdjdata = setvaluesForEM_OlAdj(reportforEM_OlAdjData);
		
        ExcelUtils.writeToExcel(file, EM_OlAdjdata, PDCAPortletKeys.EM_OLAdj_HeaderNames);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),resourceRequest);
		FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),rootfolder.getFolderId(), fileEntry.getFileName(),fileEntry.getMimeType(), title, description, "", file, serviceContext);
		url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() +"/documents/" + themeDisplay.getScopeGroupId() + "/" +addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		System.out.println(url);
		JSONObject reportdata = JSONFactoryUtil.createJSONObject();
		reportdata.put("URL", url);
		  //TODO pass the list to json 
		return reportdata.toString();
		
	}


	private String reportForPRM_Ol3(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file, int reportId, long year) throws PortalException {
		long timeNow = System.currentTimeMillis();
		final long latest = timeNow;
		String title = "Report_PRM_OL3"+"_"+year+"_"+latest;
		String description = PDCAPortletKeys.PRM_OL3_Desc;
		String url = null;
		
		Map<Long, List<Reportdto>> reportForOl3Data = PdcaSqlQueries.getReportForCP(conn, reportId, year);
		List<ReportForPRM_Ol3> PRM_OL3data = setvaluesForPRM_OL3(year,reportForOl3Data);
		
        ExcelUtils.writeToExcel(file, PRM_OL3data, PDCAPortletKeys.PR_OL3_HeaderNames);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),resourceRequest);
		FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),rootfolder.getFolderId(), fileEntry.getFileName(),fileEntry.getMimeType(), title, description, "", file, serviceContext);
		url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() +"/documents/" + themeDisplay.getScopeGroupId() + "/" +addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		System.out.println(url);
		JSONObject reportdata = JSONFactoryUtil.createJSONObject();
		reportdata.put("URL", url);
		  //TODO pass the list to json 
		return reportdata.toString();
	}
	
	
	
	private String reportForPRM_OlAdj(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file, int reportId, long year) throws PortalException {
		long timeNow = System.currentTimeMillis();
		final long latest = timeNow;
		String title = "Report_PRM_OLAdj"+"_"+year+"_"+latest;
		String description = PDCAPortletKeys.PRM_OLAdj_Desc;
		String url = null;
		
		Map<Long, List<Reportdto>> reportForOlAdjData = PdcaSqlQueries.getReportForCP(conn, reportId, year);
		List<ReportForPRM_OlAdj> PRM_OLAdjData = setvaluesForPRM_OLAdj(reportForOlAdjData,year);
		
        ExcelUtils.writeToExcel(file, PRM_OLAdjData, PDCAPortletKeys.PR_OLAdj_HeaderNames);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),resourceRequest);
		FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),rootfolder.getFolderId(), fileEntry.getFileName(),fileEntry.getMimeType(), title, description, "", file, serviceContext);
		url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() +"/documents/" + themeDisplay.getScopeGroupId() + "/" +addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		System.out.println(url);
		JSONObject reportdata = JSONFactoryUtil.createJSONObject();
		reportdata.put("URL", url);
		  //TODO pass the list to json 
		return reportdata.toString();
	}
	

	private List<ReportForPRM_OlAdj> setvaluesForPRM_OLAdj(Map<Long, List<Reportdto>> reportForOlAdjData, long year) {
		
		List<ReportForPRM_OlAdj> reportForPRM_OlAdjObjects = new ArrayList<ReportForPRM_OlAdj>();
		
		try {
			List<tradingProfit> tradingProfitlList = getTradingProfitByPeriod_Year(3,year);
			
			 for(tradingProfit tpd : tradingProfitlList ) {
				 List<kpi> kpi = getTargetByCompanyId_Year(tpd.getCompanyId(),year);
				 double OL_OlAdj_CY = getOLBy_KpiId_Year(kpi.get(0).getKpiId(),3);
				 
				 ReportForPRM_OlAdj reportForPRM_OlAdj = new ReportForPRM_OlAdj();
				 
				 reportForPRM_OlAdj.setCompany(companyLocalServiceUtil.getcompany(tpd.getCompanyId()).getCompanyName());
				 
				 if(reportForOlAdjData.get(tpd.getCompanyId())!= null) {
					 reportForPRM_OlAdj.setFY_Audited_LastYear(reportForOlAdjData.get(tpd.getCompanyId()).get(0).getValue());
				  }
				  else {
					  reportForPRM_OlAdj.setFY_Audited_LastYear(0.00);
				  }
				 
				 reportForPRM_OlAdj.setTarget_CurrentYear(kpi.get(0).getTarget());
				 reportForPRM_OlAdj.setOlAdj_CurrentYear(OL_OlAdj_CY);
				 
				 
				 reportForPRM_OlAdj.setAchivement_Ol(OL_OlAdj_CY/kpi.get(0).getTarget());
				 
				 
				 reportForPRM_OlAdjObjects.add(reportForPRM_OlAdj);

			 }
			
			
			
		} catch (Exception e) {
		}
		
		return reportForPRM_OlAdjObjects;
		
	}





	private List<ReportForPRM_Ol3> setvaluesForPRM_OL3(long year, Map<Long, List<Reportdto>> reportForOl3Data) {
		

		List<ReportForPRM_Ol3> reportForPRM_Ol3Objects = new ArrayList<ReportForPRM_Ol3>();
		
		try {
			List<tradingProfit> tradingProfitlList = getTradingProfitByPeriod_Year(4,year);
			
			 for(tradingProfit tpd : tradingProfitlList ) {
				  String totalOneOff = getTradingProfitValueAndTotalOneOff(tpd);
				  List<kpi> kpi = getTargetByCompanyId_Year(tpd.getCompanyId(),year);
				 
				  double claAchivement_OLAdj = getClaAchivement_KpiId_Period(kpi.get(0).getKpiId(),3);
				  
				  ReportForPRM_Ol3 reportForPRM_Ol3 = new ReportForPRM_Ol3();
				  
				  reportForPRM_Ol3.setCompany(companyLocalServiceUtil.getcompany(tpd.getCompanyId()).getCompanyName());
				  
				  if(reportForOl3Data.get(tpd.getCompanyId())!= null) {
					  reportForPRM_Ol3.setFY_Audited_LastYear(reportForOl3Data.get(tpd.getCompanyId()).get(0).getValue());
				  }
				  else {
					  reportForPRM_Ol3.setFY_Audited_LastYear(0.00);
				  }
				  
				  reportForPRM_Ol3.setTP_TargetCLA_CurrentYear(kpi.get(0).getTarget());
				  reportForPRM_Ol3.setTP_CPOl3_CurrentYear(tpd.getNpat() - tpd.getNetForex());
				  reportForPRM_Ol3.setOneOff_Ol3_CurrentYear(JSONFactoryUtil.createJSONObject(totalOneOff).getDouble("Total"));
				  
				  reportForPRM_Ol3.setTP_CLAOlAdj_CurrentYear(claAchivement_OLAdj);
				  reportForPRM_Ol3.setAchivement_OlAdj_CurrentYear(claAchivement_OLAdj / JSONFactoryUtil.createJSONObject(totalOneOff).getDouble("Total"));
				  
				  reportForPRM_Ol3.setTP_CLAOl3_CurrentYear(JSONFactoryUtil.createJSONObject(totalOneOff).getDouble("TradingProfit"));
				  reportForPRM_Ol3.setAchivement_Ol3_CurrentYear(JSONFactoryUtil.createJSONObject(totalOneOff).getDouble("TradingProfit")/kpi.get(0).getTarget());
				  reportForPRM_Ol3.setNotes_Target("Notes");
				  
				  
				  reportForPRM_Ol3Objects.add(reportForPRM_Ol3);
				  
			 }
			
			
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			  
		return reportForPRM_Ol3Objects;
		
		
	}




	





	private List<ReportForCpDto> setvaluesForCPData(Map<Long, List<Reportdto>> reportForCPData, long year) {
		
		List<ReportForCpDto> reportForCPDtoObjects = new ArrayList<ReportForCpDto>();
		
		try {
			
			  List<tradingProfit> tradingProfitlList = getTradingProfitByPeriod_Year(4,year);
			  
			  for(tradingProfit tpd : tradingProfitlList ) {
				  String totalOneOff = getTradingProfitValueAndTotalOneOff(tpd);
				  List<kpi> kpi = getTargetByCompanyId_Year(tpd.getCompanyId(),year);
				  
				  
				  ReportForCpDto reportForCpDto = new ReportForCpDto();
				  
				  reportForCpDto.setCompany(companyLocalServiceUtil.getcompany(tpd.getCompanyId()).getCompanyName());
				  
				  if(reportForCPData.get(tpd.getCompanyId())!= null) {
					  reportForCpDto.setFY_Audited_LastYear(reportForCPData.get(tpd.getCompanyId()).get(0).getValue());
				  }
				  else {
					  reportForCpDto.setFY_Audited_LastYear(0.00);
				  }
				  
				  reportForCpDto.setTP_TargetCLA_CurrentYear(kpi.get(0).getTarget());
				  reportForCpDto.setTP_CPOl3_CurrentYear(tpd.getNpat() - tpd.getNetForex());
				  reportForCpDto.setOneOff_Ol3_CurrentYear(JSONFactoryUtil.createJSONObject(totalOneOff).getDouble("Total"));
				  reportForCpDto.setTP_CLAOl3_CurrentYear(JSONFactoryUtil.createJSONObject(totalOneOff).getDouble("TradingProfit"));
				  reportForCpDto.setAchivement_Ol3_CurrentYear(JSONFactoryUtil.createJSONObject(totalOneOff).getDouble("TradingProfit")/kpi.get(0).getTarget());
				  reportForCpDto.setNotes_Target("Notes");
				  
				  reportForCPDtoObjects.add(reportForCpDto);
				  
			  }
			
		} catch (Exception e) {
			
		}
		
		return reportForCPDtoObjects;

		
	}

	
	private List<ReportForFYDto> setvaluesForFullYearData(List<NamedObject<Map<Long, List<Reportdto>>>> reportForFullYearData) {
		
		List<ReportForFYDto> reportForFYDtoObjects = new ArrayList<ReportForFYDto>();
		
		 try {
			 Map<Long, List<Reportdto>> list1 = reportForFullYearData.get(0).getObject();
				Map<Long, List<Reportdto>> list2 = reportForFullYearData.get(1).getObject();
				
				
			    for(Map.Entry<Long, List<Reportdto>> entry: list1.entrySet()){
			    	ReportForFYDto reportForFYDto = new ReportForFYDto();
			    	
			    	reportForFYDto.setCompany(companyLocalServiceUtil.getcompany(entry.getKey()).getCompanyName());
			    	
			    	double getOl3Ach_CY = 0.00;
			    	double getOl3Ach_PY = 0.00;
			    	double getFYAch = 0.00;
			    	List<Reportdto> reportdtolist = new ArrayList<>(entry.getValue());
			    	for(Reportdto rd : reportdtolist){
			    		if(rd.getPid() == 4 && rd.getType().equals("Sum_ClaPoint_PreviousYear")) {
			    			reportForFYDto.setOl3_Achivement_LastYear(rd.getValue());
			    			getOl3Ach_PY = rd.getValue();
			    		}
			    		else if(rd.getPid() == 3 && rd.getType().equals("Sum_ClaPoint_CurrentYear")) {
			    			reportForFYDto.setOlAdj_Achivement_CurrentYear(rd.getValue());
			    		}
			    		else if(rd.getPid() == 4 && rd.getType().equals("Sum_ClaPoint_CurrentYear")) {
			    			reportForFYDto.setOl3_Achivement_CurrentYear(rd.getValue());
			    			getOl3Ach_CY = rd.getValue();
			    		}
			    		else if(rd.getPid() == 5 && rd.getType().equals("Sum_ClaPoint_CurrentYear")) {
			    			reportForFYDto.setFy_Achivement_CurrentYear(rd.getValue());
			    			getFYAch = rd.getValue();
			    		}
			    		
			    	}
			    	
			    	reportForFYDto.setFy__And_ol3_Achivement_CurrentYear(getFYAch - getOl3Ach_CY);
			    	reportForFYDto.setOl3_Achivement_LastYear_And_CurrentYear(getOl3Ach_CY - getOl3Ach_PY);
			    	
			    	
			    	List<Reportdto> TradeProfitList = list2.get(entry.getKey());
			    	for(Reportdto Tpl : TradeProfitList) {
			    		if(Tpl.getPid() == 3) {
			    			reportForFYDto.setOlAdj_TP_Achivement_CurrentYear(Tpl.getValue());    			
			    		}
			    		if(Tpl.getPid() == 4) {
			    			reportForFYDto.setOl3_TP_Achivement_CurrentYear(Tpl.getValue());	    			
			    		}
			    		if(Tpl.getPid() == 5) {
			    			reportForFYDto.setFy_TP_Achivement_CurrentYear(Tpl.getValue());	
			    		}
			    	}
			    	
			    	reportForFYDto.setNotes_cla("Notes");
			    	
			    	
			    	reportForFYDtoObjects.add(reportForFYDto);	
			    	
			    }
			
		} catch (Exception e) {
		
		}
		
		return reportForFYDtoObjects;
		
	}
	
	
	private List<ReportForEM_Ol3> setvaluesForEM_Ol3(List<NamedObject<Map<Long, List<Reportdto>>>> EM_OL3Data) {
		

		
		List<ReportForEM_Ol3> reportForFYDtoObjects = new ArrayList<ReportForEM_Ol3>();
		
		 try {
			 Map<Long, List<Reportdto>> list1 = EM_OL3Data.get(0).getObject();
				Map<Long, List<Reportdto>> list2 = EM_OL3Data.get(1).getObject();
				
				
			    for(Map.Entry<Long, List<Reportdto>> entry: list1.entrySet()){
			    	ReportForEM_Ol3 reportForEM_Ol3 = new ReportForEM_Ol3();
			    	
			    	reportForEM_Ol3.setCompany(companyLocalServiceUtil.getcompany(entry.getKey()).getCompanyName());
			    	
			    	double getOl3Ach_CY = 0.00;
			    	double getOl3Ach_PY = 0.00;
			    	double getOlAdj_CY = 0.00;
			    	List<Reportdto> reportdtolist = new ArrayList<>(entry.getValue());
			    	for(Reportdto rd : reportdtolist){
			    		if(rd.getPid() == 4 && rd.getType().equals("Sum_ClaPoint_PreviousYear")) {
			    			reportForEM_Ol3.setOl3_Achivement_LastYear(rd.getValue());
			    			getOl3Ach_PY = rd.getValue();
			    		}
			    		else if(rd.getPid() == 3 && rd.getType().equals("Sum_ClaPoint_CurrentYear")) {
			    			reportForEM_Ol3.setOlAdj_Achivement_CurrentYear(rd.getValue());
			    			getOlAdj_CY = rd.getValue();
			    		}
			    		else if(rd.getPid() == 4 && rd.getType().equals("Sum_ClaPoint_CurrentYear")) {
			    			reportForEM_Ol3.setOl3_Achivement_CurrentYear(rd.getValue());
			    			getOl3Ach_CY = rd.getValue();
			    		}
			    		
			    	}
			    	
			    	reportForEM_Ol3.setOl3__And_olAdj_Achivement_CurrentYear(getOl3Ach_CY - getOlAdj_CY);
			    	reportForEM_Ol3.setOl3_Achivement_LastYear_And_CurrentYear(getOl3Ach_CY - getOl3Ach_PY);
			    	
			    	
			    	List<Reportdto> TradeProfitList = list2.get(entry.getKey());
			    	for(Reportdto Tpl : TradeProfitList) {
			    		if(Tpl.getPid() == 3) {
			    			reportForEM_Ol3.setOlAdj_TP_Achivement_CurrentYear(Tpl.getValue());    			
			    		}
			    		else if(Tpl.getPid() == 4) {
			    			reportForEM_Ol3.setOl3_TP_Achivement_CurrentYear(Tpl.getValue());	    			
			    		}
			    	}
			    	
			    	reportForEM_Ol3.setNotes_cla("Notes");
			    	reportForEM_Ol3.setNotes_TP("Notes TP");
			    	
			    	
			    	reportForFYDtoObjects.add(reportForEM_Ol3);	
			    	
			    }
			
		} catch (Exception e) {
		
		}
		
		return reportForFYDtoObjects;
		
	}
	
	
	private List<ReportForEM_OlAdj> setvaluesForEM_OlAdj(List<NamedObject<Map<Long, List<Reportdto>>>> EM_OlAdjData) {
		
		List<ReportForEM_OlAdj> reportForEM_OLAdjObjects = new ArrayList<ReportForEM_OlAdj>();
		
		 try {
			 Map<Long, List<Reportdto>> list1 = EM_OlAdjData.get(0).getObject();
				Map<Long, List<Reportdto>> list2 = EM_OlAdjData.get(1).getObject();
				
				
			    for(Map.Entry<Long, List<Reportdto>> entry: list1.entrySet()){
			    	ReportForEM_OlAdj reportForEM_OlAdj = new ReportForEM_OlAdj();
			    	
			    	reportForEM_OlAdj.setCompany(companyLocalServiceUtil.getcompany(entry.getKey()).getCompanyName());
			    	
			    	double getOlAdj_PY = 0.00;
			    	double getOlAdj_CY = 0.00;
			    	List<Reportdto> reportdtolist = new ArrayList<>(entry.getValue());
			    	for(Reportdto rd : reportdtolist){
			    		if(rd.getPid() == 3 && rd.getType().equals("Sum_ClaPoint_PreviousYear")) {
			    			reportForEM_OlAdj.setOlAdj_LastYear(rd.getValue());
			    			getOlAdj_PY = rd.getValue();
			    		}
			    		else if(rd.getPid() == 4 && rd.getType().equals("Sum_ClaPoint_CurrentYear")) {
			    			reportForEM_OlAdj.setOlAdj_CurrentYear(rd.getValue());
			    			getOlAdj_CY = rd.getValue();
			    		}
			    		
			    	}
			    	
			    	reportForEM_OlAdj.setOlAdj_LY_And_CY(getOlAdj_CY - getOlAdj_PY);
			    	
			    	
			    	List<Reportdto> TradeProfitList = list2.get(entry.getKey());
			    	for(Reportdto Tpl : TradeProfitList) {
			    		if(Tpl.getPid() == 3) {
			    			reportForEM_OlAdj.setTP_olAdj_CurrentYear(Tpl.getValue());   			
			    		}
			    	}
			    	
			    	reportForEM_OlAdj.setNotes_CLA("Notes For CLA");
			    	reportForEM_OlAdj.setNotes_TP("Notes For TP");
			    	
			    	
			    	reportForEM_OLAdjObjects.add(reportForEM_OlAdj);	
			    	
			    }
			
		} catch (Exception e) {
		
		}
		
		return reportForEM_OLAdjObjects;
	}
	
	
	private List<tradingProfit> getTradingProfitByPeriod_Year(long periodId,long year) {
		
		DynamicQuery dynamicQueryForTradingProfit = tradingProfitLocalServiceUtil.dynamicQuery();
		dynamicQueryForTradingProfit.add(PropertyFactoryUtil.forName("periodId").eq(periodId) );
		Criterion reqcriterion = RestrictionsFactoryUtil.eq("year",year);
		dynamicQueryForTradingProfit.add(reqcriterion);
		return tradingProfitLocalServiceUtil.dynamicQuery(dynamicQueryForTradingProfit);
		
	}
	
	private List<kpi> getTargetByCompanyId_Year(long companyId,long year) {
		
		DynamicQuery dynamicQueryForTarget = kpiLocalServiceUtil.dynamicQuery();
		dynamicQueryForTarget.add(PropertyFactoryUtil.forName("companyId").eq(companyId) );
		Criterion reqcriterion = RestrictionsFactoryUtil.eq("year",year);
		dynamicQueryForTarget.add(reqcriterion);
		return tradingProfitLocalServiceUtil.dynamicQuery(dynamicQueryForTarget);
	}
	
	
    private double getClaAchivement_KpiId_Period(long kpiId,long periodId) {
    	
    	DynamicQuery dynamicQueryForClaAchivement = cla_kpiLocalServiceUtil.dynamicQuery();
    	dynamicQueryForClaAchivement.add(PropertyFactoryUtil.forName("kpiId").eq(kpiId) );
		Criterion reqcriterion = RestrictionsFactoryUtil.eq("periodId",periodId);
		dynamicQueryForClaAchivement.add(reqcriterion);
		List<cla_kpi> dynamicQuery = cla_kpiLocalServiceUtil.dynamicQuery(dynamicQueryForClaAchivement);
		return dynamicQuery.get(0).getAchivement();
	}
    
    
    private double getOLBy_KpiId_Year(long kpiId, long year) {

    	DynamicQuery dynamicQueryForClaAchivement = cla_kpiLocalServiceUtil.dynamicQuery();
    	dynamicQueryForClaAchivement.add(PropertyFactoryUtil.forName("kpiId").eq(kpiId) );
		Criterion reqcriterion = RestrictionsFactoryUtil.eq("year",year);
		dynamicQueryForClaAchivement.add(reqcriterion);
		List<cla_kpi> dynamicQuery = cla_kpiLocalServiceUtil.dynamicQuery(dynamicQueryForClaAchivement);
		return dynamicQuery.get(0).getOl();
		
	}

	
	
	





	/**
	 * Calculating TradingProfitValue and Total OneOff based on TradingProfit Object
	 * @param TradingProfit Object
	 * @return Json String of TP value and Total OneOff
	 */
	private String getTradingProfitValueAndTotalOneOff(tradingProfit tpb) {
		double total = tpb.getPpeDispos() + tpb.getRevalutionOnPropertyInvestment() + tpb.getInvestment() + 
				tpb.getTaxExpense() + tpb.getImpairmentOnAsset()+tpb.getOthers();		                                   
		double tradingProfit = tpb.getNpat() - tpb.getNetForex() - (total);
		JSONObject Tp_Breakdown_Json = JSONFactoryUtil.createJSONObject();
		Tp_Breakdown_Json.put("Total", total);
		Tp_Breakdown_Json.put("TradingProfit", tradingProfit);
		return Tp_Breakdown_Json.toString();
	}


	
	
	
	/**
	 * Method for Create a Folder in Document & Media Library...
	 * @param resourceRequest
	 * @param themeDisplay
	 * @param clafoldername
	 * @return Folder Object
	 */
	private Folder createFolder(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, String clafoldername) {
		Folder folder = null;
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest);
			folder = DLAppServiceUtil.addFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, clafoldername,
					PDCAPortletKeys.CLAFolderDesc, serviceContext);
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		return folder;
	}
	
	
	
	
	/**
	 * Method for whether the Folder Would Created or Not in Document & Media Library..
	 * @param themeDisplay
	 * @param ROOT_FOLDER_NAME
	 * @return True or False
	 */
	private boolean isFolderExist(ThemeDisplay themeDisplay, String ROOT_FOLDER_NAME) {
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					ROOT_FOLDER_NAME);
			folderExist = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folderExist;
	}
	
	
	
	/**
	 * Method for Get Folder Based on FolderName in Document & Media Library
	 * @param themeDisplay
	 * @param ROOT_FOLDER_NAME
	 * @return Folder Instance
	 */
	private Folder getFolder(ThemeDisplay themeDisplay, String ROOT_FOLDER_NAME) {
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folder;
	}
}