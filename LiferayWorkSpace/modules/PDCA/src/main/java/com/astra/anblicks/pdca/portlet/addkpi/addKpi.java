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
package com.astra.anblicks.pdca.portlet.addkpi;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.astra.anblicks.pdca.constants.PDCAPortletKeys;
import com.astra.anblicks.pdca.model.achivementFormula;
import com.astra.anblicks.pdca.model.cla_kpi;
import com.astra.anblicks.pdca.model.kpi;
import com.astra.anblicks.pdca.model.period;
import com.astra.anblicks.pdca.model.tradingProfit;
import com.astra.anblicks.pdca.service.achivementFormulaLocalServiceUtil;
import com.astra.anblicks.pdca.service.cla_kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.periodLocalServiceUtil;
import com.astra.anblicks.pdca.service.tradingProfitLocalServiceUtil;
import com.astra.anblicks.pdca.utils.CLACalculations;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=AstraPDCA",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=AddPKI",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/addkpi/addkpi.jsp",
        "javax.portlet.name=" + PDCAPortletKeys.AddKPI,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class addKpi extends MVCPortlet {
	

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	    
	   super.doView(renderRequest, renderResponse);
	}

	
	 public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
  {
				    String cmd = ParamUtil.getString(resourceRequest, "cmd");
				    if (cmd.equalsIgnoreCase("add")) {
					 try {
						 logger.info(resourceRequest.getParameter("company")+"resourceRequest.getParameter");
						 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
						 kpi _kpi = kpiLocalServiceUtil.createkpi(CounterLocalServiceUtil.increment());
						  _kpi.setCompanyId(Long.parseLong(resourceRequest.getParameter("company")));
						 _kpi.setTypeId(Long.parseLong(resourceRequest.getParameter("type")));
						 _kpi.setWeight( Long.parseLong(resourceRequest.getParameter("weight")));
						 _kpi.setTarget(Long.parseLong(resourceRequest.getParameter("target")));
						 _kpi.setYear(Long.parseLong(resourceRequest.getParameter("year")));
						 _kpi.setItemDescriptionName(resourceRequest.getParameter("item"));
						 _kpi.setUnit(resourceRequest.getParameter("unit"));
						 _kpi.setAchivementFormulaId(Long.parseLong(resourceRequest.getParameter("achivementformula"))); 
						 //_kpi.setCompanyId(themeDisplay.getCompanyId());  Here should insert site
						 _kpi.setUserId(themeDisplay.getUserId());
						 _kpi.setUserName(themeDisplay.getUser().getFullName());
						 _kpi.setCreateDate(new Date());
						 _kpi.setModifiedDate(new Date());
						 kpi addkpi = kpiLocalServiceUtil.addkpi(_kpi);
						 if(resourceRequest.getParameter("item").equals("1")){
							 createTradeProfitObjectsBasedOnPeriods(addkpi);
						 }
						 createcla_kpiObjectsBasedOnPeriod(addkpi);
						  JSONObject json = JSONFactoryUtil.createJSONObject();
						  json.put("sucess", "added");
		        		 writeJSON(resourceRequest, resourceResponse,json);
					} catch (Exception e) {
						e.printStackTrace();
						logger.error(e);
						    JSONObject json = JSONFactoryUtil.createJSONObject();
					        json.put("error", "error");
					        writeJSON(resourceRequest, resourceResponse, json);			
					}
				    }
				    else if(cmd.equalsIgnoreCase("update")){
				    	try {
							kpi kpi_=kpiLocalServiceUtil.getkpi(Long.parseLong(resourceRequest.getParameter("kpiid")));
							period period_ = periodLocalServiceUtil.getperiod(Long.parseLong(resourceRequest.getParameter("peridId")));
							cla_kpi cla_kpi = getCla_Kpi(kpi_,period_);
							cla_kpi.setYtd(Long.parseLong(resourceRequest.getParameter("ytd")));
							cla_kpi.setClaPoint(Double.parseDouble(resourceRequest.getParameter("clapoint")));
							cla_kpi.setOl(Double.parseDouble(resourceRequest.getParameter("ol")));
							cla_kpi.setAchivement(Double.parseDouble(resourceRequest.getParameter("achivement")));
							cla_kpiLocalServiceUtil.updatecla_kpi(cla_kpi);					
							
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	
				    }
		else if(cmd.equalsIgnoreCase("getachievementformula")){
						try {
							DynamicQuery formualsDQ = achivementFormulaLocalServiceUtil.dynamicQuery();
					    	formualsDQ.add(PropertyFactoryUtil.forName("itemDescriptionId").eq(Long.parseLong(resourceRequest.getParameter("item")) ));
							List<achivementFormula> achivementFormulaList=achivementFormulaLocalServiceUtil.dynamicQuery(formualsDQ);
							if(achivementFormulaList.size()>0){
								JSONObject json = JSONFactoryUtil.createJSONObject();
							    JSONArray jsonData = JSONFactoryUtil.createJSONArray();
							    for (achivementFormula afmodel_ : achivementFormulaList)
							    {
									try {
										jsonData.put(achievementTOJSON(afmodel_));
										
									} catch (Exception e) {
										 JSONObject jsonerror = JSONFactoryUtil.createJSONObject();
										 jsonerror.put("error", "error");
									        writeJSON(resourceRequest, resourceResponse, jsonerror);		
										e.printStackTrace();
									}
							    }
							    json.put("kpi_Data", jsonData);
							
							writeJSON(resourceRequest, resourceResponse,json);
							
							}	
							
						} catch (Exception e) {
							 JSONObject json = JSONFactoryUtil.createJSONObject();
						     json.put("error", "error");
						     writeJSON(resourceRequest, resourceResponse, json);	
						}
				
							 }
				    
		else if(cmd.equalsIgnoreCase("loadData")){
			
			logger.info(resourceRequest.getParameter("kpiid"));
			try {
				kpi kpiMode_=kpiLocalServiceUtil.getkpi(Long.parseLong(resourceRequest.getParameter("kpiid"))); 
				JSONObject json   = JSONFactoryUtil.createJSONObject();          
		    	   json.put("kpiId", kpiMode_.getKpiId());
				    json.put("company", kpiMode_.getCompanyId());
				    json.put("type",kpiMode_.getTypeId());
				    json.put("weight", kpiMode_.getWeight());
				    json.put("target", kpiMode_.getTarget());
				    json.put("year",  kpiMode_.getYear());
				    json.put("itemDec",  kpiMode_.getItemDescriptionName());
				    json.put("unit",  kpiMode_.getUnit());
				    json.put("achivementformula", kpiMode_.getAchivementFormulaId());
				    
				    json.put("Onloadachivementformula", onloadDropdownAF( kpiMode_.getItemDescriptionName()));
				   
				  /*  json.put("period",  period);
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
				    	
				    }*/
				    
				       writeJSON(resourceRequest, resourceResponse, json);
		       		  //  return json;	
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(cmd.equalsIgnoreCase("amount")){
			
			logger.info(resourceRequest.getParameter("newvalue"));
			
			try {
				tradingProfit tradingProfit_=tradingProfitLocalServiceUtil.gettradingProfit(Long.parseLong(resourceRequest.getParameter("tradingProfitId")));
				switch (Integer.parseInt(resourceRequest.getParameter("titleId"))) {
				case 1:
					tradingProfit_.setNpat(Long.parseLong(resourceRequest.getParameter("newvalue")));
					break;
					
					case 2:
					tradingProfit_.setNetForex(Long.parseLong(resourceRequest.getParameter("newvalue")));
					break;
					
					case 3:
						tradingProfit_.setPpeDispos(Long.parseLong(resourceRequest.getParameter("newvalue")));

						break;
					case 4:
						tradingProfit_.setRevalutionOnPropertyInvestment(Long.parseLong(resourceRequest.getParameter("newvalue")));
						
						break;
					case 5:
						tradingProfit_.setInvestment(Long.parseLong(resourceRequest.getParameter("newvalue")));
						break;
					case 6:
						tradingProfit_.setTaxExpense(Long.parseLong(resourceRequest.getParameter("newvalue")));
						
						break;
					case 7:
						tradingProfit_.setImpairmentOnAsset(Long.parseLong(resourceRequest.getParameter("newvalue")));
						break;
					case 8:
						tradingProfit_.setOthers(Long.parseLong(resourceRequest.getParameter("newvalue")));
						break;
				default:
					break;
				}
				tradingProfitLocalServiceUtil.updatetradingProfit(tradingProfit_);
				 JSONObject json = JSONFactoryUtil.createJSONObject();
			     json.put("sucess", "sucess");
			     writeJSON(resourceRequest, resourceResponse, json);	
			} catch (NumberFormatException | PortalException e) {
				 JSONObject json = JSONFactoryUtil.createJSONObject();
			     json.put("error", "error");
			     writeJSON(resourceRequest, resourceResponse, json);				
			     logger.error(e);
			}
			
		}
		else if(cmd.equalsIgnoreCase("notes")){
			logger.info(resourceRequest.getParameter("newvalue"));

		}
		else if(cmd.equalsIgnoreCase("cal")) {

			try {
				String calculationData = CLACalculations.getClaCalculations(Long.parseLong(resourceRequest.getParameter("kpiid")), Long.parseLong(resourceRequest.getParameter("peridId")));
				 writeJSON(resourceRequest, resourceResponse, JSONFactoryUtil.createJSONObject(calculationData));
			} catch (NumberFormatException | PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 }
	
	
	 
	 private cla_kpi getCla_Kpi(kpi kpi_, period period_) {
		 
		 DynamicQuery dynamicQueryForCla_kpi = cla_kpiLocalServiceUtil.dynamicQuery();
		 dynamicQueryForCla_kpi.add(PropertyFactoryUtil.forName("kpiId").eq(kpi_.getKpiId()) );
			Criterion reqcriterion = RestrictionsFactoryUtil.eq("periodId",period_.getPeriodId());
			dynamicQueryForCla_kpi.add(reqcriterion);
			List <cla_kpi> cla_kpi = cla_kpiLocalServiceUtil.dynamicQuery(dynamicQueryForCla_kpi);
			return cla_kpi.get(0);
		
		
	}


	


	private void createcla_kpiObjectsBasedOnPeriod(kpi addkpi) {
		List<period> getperiods = periodLocalServiceUtil.getperiods(0, periodLocalServiceUtil.getperiodsCount());
		for(period p : getperiods) {
			cla_kpi cla_kpi = cla_kpiLocalServiceUtil.createcla_kpi(CounterLocalServiceUtil.increment());
			cla_kpi.setKpiId(addkpi.getKpiId());
			cla_kpi.setPeriodId(p.getPeriodId());
			cla_kpi.setYtd(0);
			cla_kpi.setOl(0.00);
			cla_kpi.setClaPoint(0.00);
			cla_kpi.setAchivement(0.00);
			cla_kpiLocalServiceUtil.addcla_kpi(cla_kpi);
		}
		
	}


	private void createTradeProfitObjectsBasedOnPeriods(kpi addkpi) {
		List<period> getperiods = periodLocalServiceUtil.getperiods(0, periodLocalServiceUtil.getperiodsCount());
		for(period p : getperiods) {
			tradingProfit tradingProfit = tradingProfitLocalServiceUtil.createtradingProfit(CounterLocalServiceUtil.increment());
			tradingProfit.setPeriodId(p.getPeriodId());
			tradingProfit.setCompanyId(addkpi.getCompanyId());
			tradingProfit.setYear(addkpi.getYear());
			tradingProfit.setNpat(0.00);
			tradingProfit.setNetForex(0.00);
			tradingProfit.setPpeDispos(0.00);
			tradingProfit.setRevalutionOnPropertyInvestment(0.00);
			tradingProfit.setInvestment(0.00);
			tradingProfit.setTaxExpense(0.00);
			tradingProfit.setImpairmentOnAsset(0.00);
			tradingProfit.setOthers(0.00);
			tradingProfitLocalServiceUtil.addtradingProfit(tradingProfit);
		}
		
	}


	public static JSONObject achievementTOJSON(achivementFormula achivementFormula_) throws PortalException 
	  {
	           JSONObject json   = JSONFactoryUtil.createJSONObject();          
	    	   json.put("achievemedId", achivementFormula_.getAchivementFormulaId());
			   json.put("achievementFormulaName", achivementFormula_.getAchivementFormula());	     
	       		    return json;	
	  }
	 
	 
	 public  static JSONArray onloadDropdownAF( String val){
		 
		 DynamicQuery formualsDQ = achivementFormulaLocalServiceUtil.dynamicQuery();
	    	formualsDQ.add(PropertyFactoryUtil.forName("itemDescriptionId").eq(Long.parseLong(val)));
			List<achivementFormula> achivementFormulaList=achivementFormulaLocalServiceUtil.dynamicQuery(formualsDQ);
			JSONArray jsonData = JSONFactoryUtil.createJSONArray();
			JSONObject json  =null;
			if(achivementFormulaList.size()>0){
				   
			    for (achivementFormula afmodel_ : achivementFormulaList)
			    {	 json   = JSONFactoryUtil.createJSONObject();          
					    	   json.put("achievemedId", afmodel_.getAchivementFormulaId());
							   json.put("achievementFormulaName", afmodel_.getAchivementFormula());	   
								jsonData.put(json);

					}
			    
			}
			return jsonData;
			}

	
		private static Log logger = LogFactoryUtil.getLog(addKpi.class.getName());

}
