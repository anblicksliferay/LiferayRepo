package com.astra.anblicks.pdca.dto;

public class ReportForEM_OlAdj {
	
	private String company;
	private double olAdj_LastYear;
	private double olAdj_CurrentYear;
	private double olAdj_LY_And_CY;
	private String Notes_CLA;
	private double TP_olAdj_CurrentYear;
	private String Notes_TP;
	
	
	
	public ReportForEM_OlAdj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportForEM_OlAdj(String company, double olAdj_LastYear, double olAdj_CurrentYear, double olAdj_LY_And_CY,
			String notes_CLA, double tP_olAdj_CurrentYear, String notes_TP) {
		super();
		this.company = company;
		this.olAdj_LastYear = olAdj_LastYear;
		this.olAdj_CurrentYear = olAdj_CurrentYear;
		this.olAdj_LY_And_CY = olAdj_LY_And_CY;
		Notes_CLA = notes_CLA;
		TP_olAdj_CurrentYear = tP_olAdj_CurrentYear;
		Notes_TP = notes_TP;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getOlAdj_LastYear() {
		return olAdj_LastYear;
	}
	public void setOlAdj_LastYear(double olAdj_LastYear) {
		this.olAdj_LastYear = olAdj_LastYear;
	}
	public double getOlAdj_CurrentYear() {
		return olAdj_CurrentYear;
	}
	public void setOlAdj_CurrentYear(double olAdj_CurrentYear) {
		this.olAdj_CurrentYear = olAdj_CurrentYear;
	}
	public double getOlAdj_LY_And_CY() {
		return olAdj_LY_And_CY;
	}
	public void setOlAdj_LY_And_CY(double olAdj_LY_And_CY) {
		this.olAdj_LY_And_CY = olAdj_LY_And_CY;
	}
	public String getNotes_CLA() {
		return Notes_CLA;
	}
	public void setNotes_CLA(String notes_CLA) {
		Notes_CLA = notes_CLA;
	}
	public double getTP_olAdj_CurrentYear() {
		return TP_olAdj_CurrentYear;
	}
	public void setTP_olAdj_CurrentYear(double tP_olAdj_CurrentYear) {
		TP_olAdj_CurrentYear = tP_olAdj_CurrentYear;
	}
	public String getNotes_TP() {
		return Notes_TP;
	}
	public void setNotes_TP(String notes_TP) {
		Notes_TP = notes_TP;
	}
	
	@Override
	public String toString() {
		return "ReportForEM_OlAdj [company=" + company + ", olAdj_LastYear=" + olAdj_LastYear + ", olAdj_CurrentYear="
				+ olAdj_CurrentYear + ", olAdj_LY_And_CY=" + olAdj_LY_And_CY + ", Notes_CLA=" + Notes_CLA
				+ ", TP_olAdj_CurrentYear=" + TP_olAdj_CurrentYear + ", Notes_TP=" + Notes_TP + "]";
	}
	

}
