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
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
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
import com.astra.anblicks.pdca.service.tradingProfitLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
public class Reports extends MVCPortlet {

	private static Log logger = LogFactoryUtil.getLog(Reports.class.getName());
	
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String reportId = ParamUtil.getString(resourceRequest, "reportId");
		String periodId = ParamUtil.getString(resourceRequest, "periodId");
		String year = ParamUtil.getString(resourceRequest, "year");
		
		String reportDownloadUrl = getReportUrl(Integer.parseInt(reportId),Long.parseLong(periodId),Long.parseLong(year),resourceRequest,resourceResponse);
        
        logger.info("Report : "+reportId+" Period :"+periodId+" Year : "+year);
        
        logger.info("reportDownloadUrl :"+reportDownloadUrl);
	}


	private String getReportUrl(int reportId, long periodId, long year, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		switch (reportId) {
		case 1:
			try {
				getFile(reportId,periodId,resourceRequest,resourceResponse);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			throw new IllegalArgumentException("Invaild ReportId : "+ reportId);
		}
		
		return "";
		
	}
	
	
	/**
	 * Method is to get the relevant file from Document & Media Library to generate relevant Report
	 * @param reportId,periodId,resourceRequest,resourceResponse
	 * @throws FileNotFoundException,IOException
	 *
	 */
	private void getFile(int reportId,long periodId,ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws FileNotFoundException, IOException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long repositoryId = themeDisplay.getScopeGroupId();
			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
					PDCAPortletKeys.AstraParentFolderName);
			boolean isFolderExist = isFolderExist(themeDisplay, PDCAPortletKeys.CLAFolderName);
			if (!isFolderExist) {
				createFolder(resourceRequest, themeDisplay, PDCAPortletKeys.CLAFolderName);
			}
			Folder rootfolder = getFolder(themeDisplay, PDCAPortletKeys.CLAFolderName);
			switch (reportId) {
			case 1:
				FileEntry fileEntry = DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(),
						PDCAPortletKeys.AstraSampleExcelForTPBreakDown);
				File file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), "", true);
				reportForTPBreakdown(themeDisplay,resourceRequest, rootfolder, fileEntry, file,periodId);
				break;
			case 2:
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

	}
	
	
	
	
	private void reportForTPBreakdown(ThemeDisplay themeDisplay, ResourceRequest resourceRequest, Folder rootfolder,
			FileEntry fileEntry, File file, long periodId) throws PortalException {
		long timeNow = System.currentTimeMillis();
		int rowIndex = 1;
		int starIndex = 4;
		final long latest = timeNow;
		String title = "Report_TP_BreakDown_"+latest;
		String description = PDCAPortletKeys.TPBreakDown_Desc;
		String url = null;
		
		DynamicQuery dynamicQueryForTradeProfit = tradingProfitLocalServiceUtil.dynamicQuery();
		dynamicQueryForTradeProfit.add(PropertyFactoryUtil.forName("periodId").eq(periodId));
		List<tradingProfit> TradeProfitList = cla_kpiLocalServiceUtil.dynamicQuery(dynamicQueryForTradeProfit);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Tp_BreakDown");
		
	/*	for( tradingProfit tpb : TradeProfitList) {
			String TradingProfitjsonDataArray = getTradingProfitFormulaValue(tpb);
			JSONObject Tdp_Converted_Json = JSONFactoryUtil.createJSONObject(TradingProfitjsonDataArray);
			Row row = sheet.createRow(starIndex++);
			row.createCell(0).setCellValue(rowIndex);
			row.createCell(1).setCellValue(companyLocalServiceUtil.getcompany(tpb.getCompanyId()).getCompanyName());
			row.createCell(2).setCellValue(tpb.getNpat());
			row.createCell(3).setCellValue(tpb.getNetForex());
			row.createCell(4).setCellValue(tpb.getPpeDispos());
			row.createCell(5).setCellValue(tpb.getRevalutionOnPropertyInvestment());
			row.createCell(6).setCellValue(tpb.getInvestment());
			row.createCell(7).setCellValue(tpb.getImpairmentOnAsset());
			row.createCell(8).setCellValue(Tdp_Converted_Json.getDouble("Total"));
			row.createCell(9).setCellValue(Tdp_Converted_Json.getDouble("TradingProfit"));	
			rowIndex++;
		} */
		
		  FileOutputStream outputStream;
		  try {
			outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e1 ) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),resourceRequest);
		  FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),rootfolder.getFolderId(), fileEntry.getFileName(),fileEntry.getMimeType(), title, description, "", file, serviceContext);
		  url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() +"/documents/" + themeDisplay.getScopeGroupId() + "/" +addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		  System.out.println(url);
	}
		


	private String getTradingProfitFormulaValue(tradingProfit tpb) {
		double total = tpb.getPpeDispos() + tpb.getRevalutionOnPropertyInvestment() + tpb.getInvestment() + tpb.getTaxExpense() + tpb.getImpairmentOnAsset();		                                   
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
			System.out.println("Folder is already Exist");
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