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
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

import com.astra.anblicks.pdca.constants.PDCAPortletKeys;
import com.astra.anblicks.pdca.model.tradingProfit;
import com.astra.anblicks.pdca.service.cla_kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.companyLocalServiceUtil;
import com.astra.anblicks.pdca.service.periodLocalServiceUtil;
import com.astra.anblicks.pdca.service.tradingProfitLocalServiceUtil;
import com.astra.anblicks.pdca.services.PdcaMySqlConnection;
import com.astra.anblicks.pdca.services.PdcaSqlQueries;
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
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		Connection conn = PdcaMySqlConnection.getConnection();
		PdcaSqlQueries.getkpis(conn);
		super.doView(renderRequest, renderResponse);
	}
	
	
	
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
			// TODO Auto-generated catch block
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
				reportForFullYear(themeDisplay, resourceRequest, rootfolder, fileEntry, file, year);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;

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
		
		//TODO Add Headers to Excel File
		long timeNow = System.currentTimeMillis();
		int rowIndex = 1;
		int starIndex = 4;
		final long latest = timeNow;
		String PeriodName = periodLocalServiceUtil.getperiod(periodId).getPeriodName();
		String title = "Report_TP_BreakDown_"+PeriodName+"_"+year+"_"+latest;
		String description = PDCAPortletKeys.TPBreakDown_Desc;
		String url = null;
		
		
		
		DynamicQuery dynamicQueryForTradeProfit = tradingProfitLocalServiceUtil.dynamicQuery();
		dynamicQueryForTradeProfit.add(PropertyFactoryUtil.forName("periodId").eq(periodId));
		Criterion reqcriterion = null;
		reqcriterion = RestrictionsFactoryUtil.eq("year", year);
		dynamicQueryForTradeProfit.add(reqcriterion);
		List<tradingProfit> TradeProfitList = cla_kpiLocalServiceUtil.dynamicQuery(dynamicQueryForTradeProfit);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TP_Breakdown Report");
		
		//TODO implement the Lambda Expression forEach loop
		
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
	 * @param themeDisplay,resourceRequest,rootfolder,fileEntry,file,year
	 * @throws PortalException
	 * @return Json String of Download Url and Relevent Report Json Data 
	 * 
	 */
	private void reportForFullYear(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file, long year) {
		
		//TODO Add Headers to Excel File
				long timeNow = System.currentTimeMillis();
				int rowIndex = 1;
				int starIndex = 4;
				final long latest = timeNow;
				String title = "Report_FullYear_"+"_"+year+"_"+latest;
				String description = PDCAPortletKeys.FullYear_Desc;
				String url = null;
				
			
		
		
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