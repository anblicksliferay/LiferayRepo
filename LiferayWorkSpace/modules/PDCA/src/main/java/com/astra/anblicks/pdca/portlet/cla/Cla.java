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
import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.astra.anblicks.pdca.constants.PDCAPortletKeys;
import com.astra.anblicks.pdca.model.cla_kpi;
import com.astra.anblicks.pdca.model.kpi;
import com.astra.anblicks.pdca.service.achivementFormulaLocalServiceUtil;
import com.astra.anblicks.pdca.service.cla_kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.companyLocalServiceUtil;
import com.astra.anblicks.pdca.service.kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.periodLocalServiceUtil;
import com.astra.anblicks.pdca.service.typeLocalServiceUtil;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=AstraPDCA",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=Cla",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/cla/updatekpi.jsp",
		"javax.portlet.name=" + PDCAPortletKeys.Cla, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class Cla extends MVCPortlet {

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public void addKpi(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("mvcPath", "/cla/addkpi.jsp");
	}

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		//System.out.println(get_update_kpi_json_Json("dev"));
	    try {
			renderRequest.setAttribute("update_kpi_json", get_update_kpi_json_Json("dev"));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}


	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		    throws IOException, PortletException
		  {
		    String cmd = ParamUtil.getString(resourceRequest, "cmd");
		    if (cmd.equalsIgnoreCase("list")) {
		    	
                       switch (ParamUtil.getString(resourceRequest, "cmdType")) {
						         case "dev":
						             try{
						            	 writeJSON(resourceRequest, resourceResponse, get_update_kpi_json_Json(ParamUtil.getString(resourceRequest, "cmdType")));
									} catch (Exception e) {
										  JSONObject json = JSONFactoryUtil.createJSONObject();
									        json.put("error", "storeDefault Unsuccessful");
									        writeJSON(resourceRequest, resourceResponse, json);
									}
						             break;
						         case PDCAPortletKeys.OL1:
						        	 
						        	 try {
						        		 writeJSON(resourceRequest, resourceResponse,get_update_kpi_json_Json(PDCAPortletKeys.OL1) );
									} catch (Exception e) {
										  JSONObject json = JSONFactoryUtil.createJSONObject();
									        json.put("error", "storeDefault Unsuccessful");
									        writeJSON(resourceRequest, resourceResponse, json);										}
						             break;
						         case PDCAPortletKeys.OL2:
						        	 try {
						        		 writeJSON(resourceRequest, resourceResponse,get_update_kpi_json_Json(PDCAPortletKeys.OL2) );
									} catch (Exception e) {
										  JSONObject json = JSONFactoryUtil.createJSONObject();
									        json.put("error", "storeDefault Unsuccessful");
									        writeJSON(resourceRequest, resourceResponse, json);			
									}
						             break;
						         case PDCAPortletKeys.OL2_Adj:
						        	 try {
						        		 writeJSON(resourceRequest, resourceResponse,get_update_kpi_json_Json(PDCAPortletKeys.OL2_Adj) );
									} catch (Exception e) {
										  JSONObject json = JSONFactoryUtil.createJSONObject();
									        json.put("error", "storeDefault Unsuccessful");
									        writeJSON(resourceRequest, resourceResponse, json);			
									}
						             break;
						         case PDCAPortletKeys.OL3:
						        	 try {
						        		 writeJSON(resourceRequest, resourceResponse,get_update_kpi_json_Json(PDCAPortletKeys.OL3) );
									} catch (Exception e) {
										  JSONObject json = JSONFactoryUtil.createJSONObject();
									        json.put("error", "storeDefault Unsuccessful");
									        writeJSON(resourceRequest, resourceResponse, json);			
									}
						             break;
						         case PDCAPortletKeys.FY:
						        	 try {
						        		 writeJSON(resourceRequest, resourceResponse,get_update_kpi_json_Json(PDCAPortletKeys.FY) );
									} catch (Exception e) {
										  JSONObject json = JSONFactoryUtil.createJSONObject();
									        json.put("error", "storeDefault Unsuccessful");
									        writeJSON(resourceRequest, resourceResponse, json);			
									}
						             break;
						         default:
						             throw new IllegalArgumentException("Invalid case option " + ParamUtil.getString(resourceRequest, "cmd"));
		     }
		    }
		    
		    else if(cmd.equalsIgnoreCase("cmd")){
		    	
		    }
		    
		    
		    }

@ProcessAction(name = "createKpi")
public void createKpi(ActionRequest actionRequest, ActionResponse actionResponse) {
	try {
/*		 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 kpi _kpi = kpiLocalServiceUtil.createkpi(CounterLocalServiceUtil.increment());
		 _kpi.setCompanyName(actionRequest.getParameter("company"));
		 _kpi.setTipe(actionRequest.getParameter("type"));
		 _kpi.setWeight(actionRequest.getParameter("weight"));
		 _kpi.setTarget(actionRequest.getParameter("target"));
		 _kpi.setYear(actionRequest.getParameter("year"));
		 _kpi.setItemDescription(actionRequest.getParameter("item"));
		 _kpi.setUnit(actionRequest.getParameter("unit"));
		 _kpi.setAchivementFormula(actionRequest.getParameter("achivementformula")); 
		 _kpi.setCompanyId(themeDisplay.getCompanyId());
		 _kpi.setUserId(themeDisplay.getUserId());
		 _kpi.setUserName(themeDisplay.getUser().getFullName());
		 _kpi.setCreateDate(new Date());
		 _kpi.setModifiedDate(new Date());
		 kpi Createdkpi = kpiLocalServiceUtil.addkpi(_kpi);
		 System.out.println(Createdkpi.toString()); */
		 
		
	} catch (Exception e) {
		
	}
}


  public void deleteProfile(ActionRequest actionRequest, ActionResponse actionResponse) {
	    long userId = Long.parseLong(actionRequest.getParameter("userid"));
	   // _log.info("deleteProfile Id passed is:" + userId);
	  //  _log.info("inside delete");
	    try {
	  //    TestimonialAshokLocalServiceUtil.deleteTestimonialAshok(userId);
	    	 actionRequest.setAttribute("deleteId", userId);
	    	 actionResponse.setRenderParameter("jspPage", "/cla/updatekpi.jsp");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	  
	  public void editProfile(ActionRequest actionRequest, ActionResponse actionResponse) { 
	  String userId = actionRequest.getParameter("editid");
	  //  _log.info("editProfile Id passed is:" + userId);
	  //  _log.info("inside editProfile");
	    try {
	      actionRequest.setAttribute("editid", userId);
	      actionResponse.setRenderParameter("jspPage", "/cla/updatekpi.jsp");
	    } catch (Exception e) {
	      e.printStackTrace();
	  //    _log.error(e);
	    }
	  }
	  
public static String get_update_kpi_json_Json(String period) throws PortalException{
	JSONObject json = JSONFactoryUtil.createJSONObject();
    JSONArray jsonData = JSONFactoryUtil.createJSONArray();
    List<kpi> kpi_ = kpiLocalServiceUtil.getkpis(0, kpiLocalServiceUtil.getkpisCount());
    for (kpi kpiMode_ : kpi_)
		try {
			{
			  jsonData.put(TOJson(kpiMode_ ,period));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    json.put("kpi_Data", jsonData);
    return json.toString();
}
 @SuppressWarnings("unused")
public static JSONObject TOJson(kpi kpiMode_, String period) throws PortalException 
  {
	 long periodId = 0l;
	 List<com.astra.anblicks.pdca.model.period> getperiods = periodLocalServiceUtil.getperiods(0, periodLocalServiceUtil.getperiodsCount());
	    for(com.astra.anblicks.pdca.model.period Achivementperiod : getperiods){
	    	if(Achivementperiod.getPeriodName().equals(period)){
	    		periodId = Achivementperiod.getPeriodId();
	    		System.out.println(periodId);
	    		break;
	    	}
	    }
	 
		DynamicQuery dynamicQueryForCla_Kpi = cla_kpiLocalServiceUtil.dynamicQuery();
		dynamicQueryForCla_Kpi.add(PropertyFactoryUtil.forName("kpiId").eq(kpiMode_.getKpiId()) );
        Criterion reqcriterion = null;
        reqcriterion = RestrictionsFactoryUtil.eq("periodId",periodId);
        dynamicQueryForCla_Kpi.add(reqcriterion);
        List <cla_kpi> claKpiList = cla_kpiLocalServiceUtil.dynamicQuery(dynamicQueryForCla_Kpi);
        
        System.out.println(claKpiList);
	  
       JSONObject json   = JSONFactoryUtil.createJSONObject();          
    	   json.put("kpiId", kpiMode_.getKpiId());
		    json.put("company", companyLocalServiceUtil.getcompany(kpiMode_.getCompanyId()).getCompanyName());
		    json.put("type", typeLocalServiceUtil.gettype(kpiMode_.getTypeId()).getTypeName());
		    json.put("weight", kpiMode_.getWeight());
		    json.put("target", kpiMode_.getTarget());
		    json.put("year",  kpiMode_.getYear());
		    json.put("itemDec",  kpiMode_.getItemDescriptionName());
		    json.put("unit",  kpiMode_.getUnit());
		    json.put("achivementformula",  achivementFormulaLocalServiceUtil.getachivementFormula(kpiMode_.getAchivementFormulaId()).getAchivementFormula());
		    json.put("period",  period);
		    if(!claKpiList.isEmpty()){
		    json.put("CLAPoint",  claKpiList.get(0).getClaPoint());
		    json.put("Achivement",  claKpiList.get(0).getAchivement());
		    json.put("YTD",  claKpiList.get(0).getYtd());
		    json.put("OL1FY", claKpiList.get(0).getOl());
		    json.put("OL2FY", claKpiList.get(0).getOl());
		    json.put("OLAdj", claKpiList.get(0).getOl());
		    json.put("OL3FY", claKpiList.get(0).getOl());
		    json.put("OLFY",  claKpiList.get(0).getOl());
		    }
		    else {
		    	 json.put("CLAPoint",  "CLAPoint");
				    json.put("Achivement", "Achivement" );
				    json.put("YTD",  "YTD");
				    json.put("OL1FY", "OL1FY");
				    json.put("OL2FY", "OL2FY");
				    json.put("OLAdj", "OLAdj");
				    json.put("OL3FY", "OL3FY");
				    json.put("OLFY",  "OLFY");
		    	
		    }
		    
       		    return json;	
  }

	@ProcessAction(name = "getfile")
	public void getfile(ActionRequest actionRequest, ActionResponse actionResponse)
			throws FileNotFoundException, IOException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long repositoryId = themeDisplay.getScopeGroupId();
			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
					PDCAPortletKeys.AstraParentFolderName);
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(),
					PDCAPortletKeys.AstraSampleExcel);
			File file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), "", true);
			boolean isFolderExist = isFolderExist(themeDisplay, PDCAPortletKeys.CLAFolderName);
			if (!isFolderExist) {
				createFolder(actionRequest, themeDisplay, PDCAPortletKeys.CLAFolderName);
			}
			Folder rootfolder = getFolder(themeDisplay, PDCAPortletKeys.CLAFolderName);
			// String url
			// =excelWriteUsingJexcelApi(themeDisplay,actionRequest,rootfolder,fileEntry,file);
		//	String url = excelWriteUsingApachePOIApi(themeDisplay, actionRequest, rootfolder, fileEntry, file);
		//	System.out.println(url);
		} catch (Exception e) {
		}

	}

	@ProcessAction(name = "getpdffile")
	public void getpdffile(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long repositoryId = themeDisplay.getScopeGroupId();
			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
					PDCAPortletKeys.AstraParentFolderName);
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(),
					PDCAPortletKeys.AstraSamplePdf);
			File file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), "", true);
			boolean isFolderExist = isFolderExist(themeDisplay, PDCAPortletKeys.CLAFolderName);
			if (!isFolderExist) {
				createFolder(actionRequest, themeDisplay, PDCAPortletKeys.CLAFolderName);
			}
			Folder rootfolder = getFolder(themeDisplay, PDCAPortletKeys.CLAFolderName);
		//	String url = pdfWrite(themeDisplay, actionRequest, rootfolder, fileEntry, file);
		//	System.out.println(url);
		} catch (Exception e) {
		}

	}

/*	private String pdfWrite(ThemeDisplay themeDisplay, ActionRequest actionRequest, Folder rootfolder,
			FileEntry fileEntry, File file) throws PortalException, DocumentException, IOException {
		System.out.println("came");
		long timeNow = System.currentTimeMillis();
		final long latest = timeNow;
		String title = themeDisplay.getUser().getScreenName() + themeDisplay.getUserId() + latest;
		String description = title;
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		addContent(document);
		document.close();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), rootfolder.getFolderId(),
				fileEntry.getFileName(), fileEntry.getMimeType(), title, description, "", file, serviceContext);
		String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
				+ themeDisplay.getScopeGroupId() + "/" + addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		System.out.println(url);
		return url;
	} */

	private String excelWriteUsingJexcelApi(ThemeDisplay themeDisplay, ActionRequest actionRequest, Folder rootfolder,
			FileEntry fileEntry, File file) throws IOException, RowsExceededException, WriteException, PortalException {
	//	List<kpi> getkpis = kpiLocalServiceUtil.getkpis(0, kpiLocalServiceUtil.getkpisCount());
		long timeNow = System.currentTimeMillis();
		int rowIndex = 1;
		final long latest = timeNow;
		String title = themeDisplay.getUser().getScreenName() + themeDisplay.getUserId() + latest;
		String description = PDCAPortletKeys.CLAExcelDesc;
		WritableWorkbook claWbook = null;
		String url = null;
		claWbook = Workbook.createWorkbook(file);

		WritableSheet claSheet = claWbook.createSheet("Cla", 0);

		/*	for (kpi _kpi : getkpis) {
			claSheet.addCell(new Number(0, rowIndex, _kpi.getKpiId()));
			claSheet.addCell(new Label(1, rowIndex, _kpi.getCompanyName()));
			claSheet.addCell(new Label(2, rowIndex, _kpi.getTipe()));
			claSheet.addCell(new Label(3, rowIndex, _kpi.getWeight()));
			claSheet.addCell(new Label(4, rowIndex, _kpi.getTarget())); 
			rowIndex++;
		}*/
		claWbook.write();
		claWbook.close();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), rootfolder.getFolderId(),
				fileEntry.getFileName(), fileEntry.getMimeType(), title, description, "", file, serviceContext);
		url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
				+ themeDisplay.getScopeGroupId() + "/" + addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		System.out.println(url);

		return url;
	}

/*	private String excelWriteUsingApachePOIApi(ThemeDisplay themeDisplay, ActionRequest actionRequest,
			Folder rootfolder, FileEntry fileEntry, File file) throws IOException, PortalException {
	//	List<kpi> getkpis = kpiLocalServiceUtil.getkpis(0, kpiLocalServiceUtil.getkpisCount());
		long timeNow = System.currentTimeMillis();
		int rowIndex = 1;
		final long latest = timeNow;
		String title = themeDisplay.getUser().getScreenName() + themeDisplay.getUserId() + latest;
		String description = PDCAPortletKeys.CLAExcelDesc;
		String url = null;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Cla_Astra");

		for (kpi _kpi : getkpis) {
			Row row = sheet.createRow(rowIndex++);
			row.createCell(0).setCellValue(_kpi.getKpiId());
			row.createCell(1).setCellValue(_kpi.getYear());
		} 
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), rootfolder.getFolderId(),
				fileEntry.getFileName(), fileEntry.getMimeType(), title, description, "", file, serviceContext);
		url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
				+ themeDisplay.getScopeGroupId() + "/" + addFileEntry.getFolderId() + "/" + addFileEntry.getTitle();
		System.out.println(url);

		return url;
	} */

	private Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay, String clafoldername) {
		Folder folder = null;
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
			folder = DLAppServiceUtil.addFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, clafoldername,
					PDCAPortletKeys.CLAFolderDesc, serviceContext);
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		return folder;
	}

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

/*	private static void addContent(Document document) throws DocumentException {
		Anchor anchor = new Anchor("First Chapter", catFont);
		anchor.setName("First Chapter");

		// Second parameter is the number of the chapter
		Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph("Subcategory 1", subFont);
		Section subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("Hello"));

		subPara = new Paragraph("Subcategory 2", subFont);
		subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("Paragraph 1"));
		subCatPart.add(new Paragraph("Paragraph 2"));
		subCatPart.add(new Paragraph("Paragraph 3"));

		// add a list
		// createList(subCatPart);
		Paragraph paragraph = new Paragraph();
		addEmptyLine(paragraph, 5);
		subCatPart.add(paragraph);

		// add a table
		createTable(subCatPart);

		// now add all this to the document
		document.add(catPart);

		// Next section
		anchor = new Anchor("Second Chapter", catFont);
		anchor.setName("Second Chapter");

		// Second parameter is the number of the chapter
		catPart = new Chapter(new Paragraph(anchor), 1);

		subPara = new Paragraph("Subcategory", subFont);
		subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("This is a very important message"));

		// now add all this to the document
		document.add(catPart);

	}

	private static void createTable(Section subCatPart) throws BadElementException {
		PdfPTable table = new PdfPTable(3);

		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);

		PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Table Header 2"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Table Header 3"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		table.addCell("1.0");
		table.addCell("1.1");
		table.addCell("1.2");
		table.addCell("2.1");
		table.addCell("2.2");
		table.addCell("2.3");

		subCatPart.add(table);

	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}*/
}