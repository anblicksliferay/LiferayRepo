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

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
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
import com.astra.anblicks.pdca.service.itemDescriptionLocalServiceUtil;
import com.astra.anblicks.pdca.service.kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.typeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=AstraPDCA",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Cla",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/cla/updatekpi.jsp",
        "javax.portlet.name=" + PDCAPortletKeys.Cla,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class Cla extends MVCPortlet {
	public void addKpi(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("mvcPath", "/cla/addkpi.jsp");
	}

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		//System.out.println(get_update_kpi_json_Json("dev"));
	    try {
			renderRequest.setAttribute("update_kpi_json", get_update_kpi_json_Json(0l));
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
		    	
		    	 try {
	        		 writeJSON(resourceRequest, resourceResponse,get_update_kpi_json_Json(Long.parseLong(ParamUtil.getString(resourceRequest, "cmdType"))) );
				} catch (Exception e) {
					logger.error("list"+e);
					  JSONObject json = JSONFactoryUtil.createJSONObject();
				        json.put("error", "storeDefault Unsuccessful");
				        writeJSON(resourceRequest, resourceResponse, json);										}
	     
		    }
		    
		    else if(cmd.equalsIgnoreCase("getTableDataOnchage")){
		    	
		    	 try {
		    		    	logger.info(ParamUtil.getLong(resourceRequest, "company"));
		    		    	logger.info(ParamUtil.getLong(resourceRequest, "year"));
		    		    DynamicQuery dynamicQuery_kpi = kpiLocalServiceUtil.dynamicQuery();
						Criterion criterion = null;
						criterion = RestrictionsFactoryUtil.eq("companyId", ParamUtil.getLong(resourceRequest, "company"));
						criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.eq("year", ParamUtil.getLong(resourceRequest, "year")));
						dynamicQuery_kpi.add(criterion);
						
					
		    	        List <kpi> list_kpi = kpiLocalServiceUtil.dynamicQuery(dynamicQuery_kpi);
		    	
		    		logger.info(">>>>>>>>>>"+list_kpi);
		    		    	
				} catch (Exception e) {
					logger.error(e);
					   JSONObject json = JSONFactoryUtil.createJSONObject();
				        json.put("error", "storeDefault Unsuccessful");
				        writeJSON(resourceRequest, resourceResponse, json);										}
	     
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
	  
public static String get_update_kpi_json_Json(Long period) throws PortalException{
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
public static JSONObject TOJson(kpi kpiMode_, Long period) throws PortalException 
  {
		DynamicQuery dynamicQueryForCla_Kpi = cla_kpiLocalServiceUtil.dynamicQuery();
		dynamicQueryForCla_Kpi.add(PropertyFactoryUtil.forName("kpiId").eq(kpiMode_.getKpiId()) );
        Criterion reqcriterion = null;
        reqcriterion = RestrictionsFactoryUtil.eq("periodId",period);
        dynamicQueryForCla_Kpi.add(reqcriterion);
        List <cla_kpi> claKpiList = cla_kpiLocalServiceUtil.dynamicQuery(dynamicQueryForCla_Kpi);
	  
       JSONObject json   = JSONFactoryUtil.createJSONObject();          
    	   json.put("kpiId", kpiMode_.getKpiId());
		    json.put("company", companyLocalServiceUtil.getcompany(kpiMode_.getCompanyId()).getCompanyName());
		    json.put("type", typeLocalServiceUtil.gettype(kpiMode_.getTypeId()).getTypeName());
		    json.put("weight", kpiMode_.getWeight());
		    json.put("target", kpiMode_.getTarget());
		    json.put("year",  kpiMode_.getYear());
		    json.put("itemDec",  itemDescriptionLocalServiceUtil.getitemDescription(Long.parseLong(kpiMode_.getItemDescriptionName())).getItemDescriptionName());
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
		            json.put("CLAPoint",  " ");
				    json.put("Achivement", " " );
				    json.put("YTD",  " ");
				    json.put("OL1FY", " ");
				    json.put("OL2FY", " ");
				    json.put("OLAdj", " ");
				    json.put("OL3FY", " ");
				    json.put("OLFY",  " ");
		    	
		    }
		    
       		    return json;	
  }
	
	private static Log logger = LogFactoryUtil.getLog(Cla.class.getName());
}