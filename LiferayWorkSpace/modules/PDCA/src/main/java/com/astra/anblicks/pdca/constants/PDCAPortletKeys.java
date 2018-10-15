package com.astra.anblicks.pdca.constants;

/**
 * @author kranthi.kumar
 */
public class PDCAPortletKeys {

	public static final String PDCA = "PDCA";
	public static final String Administration = "AdministrationSettings";
	public static final String Cla = "Cla";
	public static final String Cla_Reports = "Reports";
	public static final String CompanyInitiatives = "CompanyInitiatives";
	public static final String MasterData = "MasterData";
	public static final String Mom = "MinutesOfMeeting";
	public static final String AddKPI = "AddKPI";
	public static final String AstraParentFolderName = "AstraPDCA";
	public static final String AstraSampleExcel = "AstraSampleExcel.xlsx";
	public static final String TPBreakDown_Desc = "Report for TP BreakDown";
	public static final String FullYear_Desc = "Report for Full Year";
	public static final String CP_Desc = "Report for CP";
	public static final String EM_OL3_Desc = "Report for EM OL3";
	public static final String EM_OLAdj_Desc = "Report for EM OLAdj";
	public static final String PRM_OL3_Desc = "Report for PRM OL3";
	public static final String PRM_OLAdj_Desc = "Report for PRM OLAdj";
	public static final String CLAFolderName = "Astra_CLA";
	public static final String CLAFolderDesc = "To store the excel files";
	public static final String CLAExcelDesc = "To do calculations on KPI Data";
	
	public static final String[] TP_BreakDown_HeaderNames = new String[] {"S.No","Company",
			"NPAT","Forex Gain/loss (net) from coy","Gain/Loss on PPE Disposal","Revaluation on Property Investment","Gain/Loss on Investment",
			"Tax Expense (non recurring)","Impairment on Asset","Lainnya/Others","Total One Off (Net to Tax)" };	
	
	public static final String[] FullYear_HeaderNames = new String[] {"Company","OL III Achievement Last Year","OL Adjusted Achievement Current Year",
			"OL III Achievement Current Year","FY Achievement Current Year","FY vs OL III Current Year","OL III Current Year vs Last Year","Notes",
			"OL Adjusted TP Achievement Current Year","OL III TP Achievement Current Year","FY TP Achievement Current Year"  };	
	
	public static final String[] CP_HeaderNames = new String[] {"Company","FY Audited Last Year","TP Target CLA Current Year",
			"TP CP OL III Current Year","One Off OL III Current Year","TP CLA OL III Current Year","Achievement OL III Current Year","Notes Target"  };
	
	public static final String[] EM_OL3_HeaderNames = new String[] {"Company","CLA Achievement OL III Last Year","CLA Achievement OL Adjusted Current Year",
			"CLA Achievement OL III Current Year","CLA Achievement OL III vs OL Adjusted Current Year",
			"OL III Current Year vs OL III Last Year","Notes CLA","OL Adjusted Current Year","OL III Current Year","Notes TP related" };	
	
	public static final String[] EM_OLAdj_HeaderNames = new String[] {"Company","CLA Achievement OL Adjusted Last Year",
			"CLA Achievement OL Adjusted Current Year","CLA Achievement OL Adjusted Current Year vs Last Year","Notes CLA","Trading Profit OL Adjusted Current Year","Notes TP related"  };	
	
	public static final String[] PR_OL3_HeaderNames = new String[] {"Company","FY Audited Last Year","TP Target CLA",
			"TP CP OL3","One Off OL 3","CLA OL Adjusted","Achievement OL Adjusted (%)","TP CLA OL3","Achievement OL3 (%)","Notes Target" };	
	
	public static final String[] PR_OLAdj_HeaderNames = new String[] {"Company","FY Audited Last Year","Target Current Year","Current Year OL Adj Sept",
			"Achievement OL Opr (%)","Notes Target","Notes Achievement"  };	
	
	
	
	

}