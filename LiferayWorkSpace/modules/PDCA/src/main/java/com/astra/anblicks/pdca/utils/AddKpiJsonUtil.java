package com.astra.anblicks.pdca.utils;

import java.util.List;

import com.astra.anblicks.pdca.service.tradingProfitLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

public class AddKpiJsonUtil {

	
	public String tradingProfit;

	public String getTradingProfit() {
		return tradingProfit;
	}

	public void setTradingProfit(String tradingProfit) {
		this.tradingProfit = tradingProfit;
	}
	
	 
	public static String tradingProfitJson(Long periodId,Long companyId,Long year){
		  String jsonstring=StringPool.BLANK;
	DynamicQuery dynamicQueryForTradingProfit = tradingProfitLocalServiceUtil.dynamicQuery();
	dynamicQueryForTradingProfit.add(PropertyFactoryUtil.forName("companyId").eq(companyId) );
	Criterion reqcriterion = RestrictionsFactoryUtil.eq("periodId",periodId);
	Criterion reqcriterion2 = RestrictionsFactoryUtil.eq("year",year);
	dynamicQueryForTradingProfit.add(reqcriterion);
	dynamicQueryForTradingProfit.add(reqcriterion2);
	List <com.astra.anblicks.pdca.model.tradingProfit> tradingProfitList = tradingProfitLocalServiceUtil.dynamicQuery(dynamicQueryForTradingProfit);
 jsonstring= 
 "[ {'titleId':'1','amount':"+tradingProfitList.get(0).getNpat()+", 'notes': 'notes notes1','period':"+periodId+", 'title':'NPAT' , "
	+ "'tradingProfitId':"+tradingProfitList.get(0).getTradingProfitId()+"},"
+ "{ 'titleId':'2', 'amount': "+tradingProfitList.get(0).getNetForex()+", 'notes': 'notes 2 dddd happy now becoz excuet edddddd','period':"+periodId+",'title':'Net Forex Gain' ,'tradingProfitId':"+tradingProfitList.get(0).getTradingProfitId()+"},"
+ "{ 'titleId':'3', 'amount': "+tradingProfitList.get(0).getPpeDispos()+", 'notes': 'notes 3notes','period':"+periodId+" ,'title':'Gain/Loss on <br>PPE Disposal','tradingProfitId':"+tradingProfitList.get(0).getTradingProfitId()+"}," 
 + "{ 'titleId':'4', 'amount': "+tradingProfitList.get(0).getRevalutionOnPropertyInvestment()+", 'notes': 'notes 3notes','period':"+periodId+" ,'title':'Revaluation on <br> Property Investment','tradingProfitId':"+tradingProfitList.get(0).getTradingProfitId()+"},"
 + "{'titleId':'5', 'amount': "+tradingProfitList.get(0).getInvestment()+", 'notes': 'notes 3notes','period':"+periodId+" ,'title':'Gain/Loss <br> on Investment','tradingProfitId':"+tradingProfitList.get(0).getTradingProfitId()+"},"	
 + "{'titleId':'6', 'amount': "+tradingProfitList.get(0).getTaxExpense()+", 'notes': 'notes 3notes','period':"+periodId+" ,'title':'Tax Expense <br>(non recurring)','tradingProfitId':"+tradingProfitList.get(0).getTradingProfitId()+"},"	
 + "{'titleId':'7', 'amount': "+tradingProfitList.get(0).getImpairmentOnAsset()+", 'notes': 'notes 3notes','period':"+periodId+" ,'title':'Impairment on Asset','tradingProfitId':"+tradingProfitList.get(0).getTradingProfitId()+"},"
 + "{'titleId':'8', 'amount': "+tradingProfitList.get(0).getOthers()+", 'notes': 'notes 3notes','period':"+periodId+" ,'title':'Others','tradingProfitId':"+tradingProfitList.get(0).getTradingProfitId()+"}]";	
		
		return jsonstring ;
	}
	
}
