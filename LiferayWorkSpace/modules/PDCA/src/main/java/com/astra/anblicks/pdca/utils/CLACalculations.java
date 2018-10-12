package com.astra.anblicks.pdca.utils;

import java.util.List;

import com.astra.anblicks.pdca.model.kpi;
import com.astra.anblicks.pdca.model.tradingProfit;
import com.astra.anblicks.pdca.service.kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.tradingProfitLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author N.Kranthi Kumar
 *
 */
public class CLACalculations {
	
	private static Log logger = LogFactoryUtil.getLog(CLACalculations.class.getName());
	
	public static String getClaCalculations(long kpiId,long periodId) throws PortalException{
		
		kpi kpiObject = kpiLocalServiceUtil.getkpi(kpiId);
		
		double OL_FY = getTradingProfit(periodId,kpiObject.getCompanyId(),kpiObject.getYear());
		double OL_Achivement = 0.00;
		double Cla_Point = 0.00;
		
		switch ((int) kpiObject.getAchivementFormulaId()) {
		case 1:
			OL_Achivement = (OL_FY/kpiObject.getTarget()) * 100;
			break;
		case 2:
			OL_Achivement = (1+ (OL_FY - kpiObject.getTarget())/(-kpiObject.getTarget())) * 100;		
			break;
		case 3:
			OL_Achivement = getMax((1 - (OL_FY - kpiObject.getTarget())/(kpiObject.getTarget())) * 100, 0.00);
			break;
		case 4:
			OL_Achivement = getMin((OL_FY/kpiObject.getTarget()) * 100 , 125);
			break;
		case 5:
			OL_Achivement = getMin((1 + (kpiObject.getTarget() - OL_FY)/(kpiObject.getTarget())) * 100, 125);
			break;
		case 6:
			OL_Achivement = getMin(100 + ((OL_FY - kpiObject.getTarget()) * 10), 125);
			break;
		case 7:
			OL_Achivement = getMin(100 + ((kpiObject.getTarget() -  OL_FY) * 5), 125);
			break;
		case 8:
			OL_Achivement = getMin(100 + ((OL_FY - kpiObject.getTarget()) * 5), 125);
			break;
		case 9:
			OL_Achivement = getMin(100 + ((kpiObject.getTarget() - OL_FY) * 50), 125);
			break;
		default:
			throw new IllegalArgumentException("Invaild AchivementFormulaId : "+kpiObject.getAchivementFormulaId());
		}
		
		
		Cla_Point = getCla_Point(OL_Achivement, kpiObject.getWeight());
		
		logger.info("OLFY : "+OL_FY + "  OL_Achivement :"+OL_Achivement + " Cla_Point : "+ Cla_Point);
		
		JSONObject Cla_CalculationObject = JSONFactoryUtil.createJSONObject();
		Cla_CalculationObject.put("OLFY", OL_FY);
		Cla_CalculationObject.put("OL_Achivement",OL_Achivement);
		Cla_CalculationObject.put("Cla_Point", Cla_Point);
		Cla_CalculationObject.put("sucess", "updated");
		
		return Cla_CalculationObject.toString();
		
		
	}
	
	
	
	/**
	 * Calculating the Cla_Point Based on Formulae 
	 * Cla_Point = (olAchivement * weight)/100;
	 * @param olAchivement
	 * @param weight
	 * @return Cla_Point
	 */
	public static double getCla_Point(double olAchivement,double weight){
		return (olAchivement * weight)/100;
	}
	
	
	
	
	/**
	 * Max Function Between Two Values
	 * @param val1
	 * @param val2
	 * @return Maximum Value
	 */
	public static double getMax(double val1,double val2){
		return (val1 > val2) ? val1 : val2;
	}
	
	
	
	/**
	 * Min Function Between Two Values
	 * @param val1
	 * @param val2
	 * @return Minimum Value
	 */
	public static double getMin(double val1,double val2){
		return (val1 > val2) ? val2 : val1;
	}
	
	
	
	/**
	 * Calculating the TradingProfit from trade values based on period ,Company and year
	 * Aka TradingProfit = OLFY
	 * @param periodId
	 * @param year 
	 * @return TradingProfit
	 * @throws PortalException
	 */
	public static double getTradingProfit(long periodId,long companyId, long year) throws PortalException {
		DynamicQuery dynamicQueryForTradingProfit = tradingProfitLocalServiceUtil.dynamicQuery();
		dynamicQueryForTradingProfit.add(PropertyFactoryUtil.forName("companyId").eq(companyId) );
		Criterion reqcriterion = RestrictionsFactoryUtil.eq("periodId",periodId);
		Criterion reqcriterion2 = RestrictionsFactoryUtil.eq("year",year);
		dynamicQueryForTradingProfit.add(reqcriterion);
		dynamicQueryForTradingProfit.add(reqcriterion2);
		List <com.astra.anblicks.pdca.model.tradingProfit> tradingProfitList = tradingProfitLocalServiceUtil.dynamicQuery(dynamicQueryForTradingProfit);
		tradingProfit getTradingProfitObject = tradingProfitList.get(0);
		
		double tradingProfit = getTradingProfitObject.getNpat() - getTradingProfitObject.getNetForex()
				- (getTradingProfitObject.getPpeDispos() + getTradingProfitObject.getRevalutionOnPropertyInvestment()
						+ getTradingProfitObject.getInvestment() + getTradingProfitObject.getTaxExpense()
						+ getTradingProfitObject.getImpairmentOnAsset());
		
		return tradingProfit;
	}

}
