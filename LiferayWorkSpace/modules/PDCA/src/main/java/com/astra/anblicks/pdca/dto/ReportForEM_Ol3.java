package com.astra.anblicks.pdca.dto;

public class ReportForEM_Ol3 {
	
	private String company;
	private double ol3_Achivement_LastYear;
	private double olAdj_Achivement_CurrentYear;
	private double ol3_Achivement_CurrentYear;
	private double ol3__And_olAdj_Achivement_CurrentYear;
	private double ol3_Achivement_LastYear_And_CurrentYear;
	private String notes_cla;
	private double olAdj_TP_Achivement_CurrentYear;
	private double ol3_TP_Achivement_CurrentYear;
	private String notes_TP;
	
	public ReportForEM_Ol3() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReportForEM_Ol3(String company, double ol3_Achivement_LastYear, double olAdj_Achivement_CurrentYear,
			double ol3_Achivement_CurrentYear, double ol3__And_olAdj_Achivement_CurrentYear,
			double ol3_Achivement_LastYear_And_CurrentYear, String notes_cla, double olAdj_TP_Achivement_CurrentYear,
			double ol3_TP_Achivement_CurrentYear, String notes_TP) {
		super();
		this.company = company;
		this.ol3_Achivement_LastYear = ol3_Achivement_LastYear;
		this.olAdj_Achivement_CurrentYear = olAdj_Achivement_CurrentYear;
		this.ol3_Achivement_CurrentYear = ol3_Achivement_CurrentYear;
		this.ol3__And_olAdj_Achivement_CurrentYear = ol3__And_olAdj_Achivement_CurrentYear;
		this.ol3_Achivement_LastYear_And_CurrentYear = ol3_Achivement_LastYear_And_CurrentYear;
		this.notes_cla = notes_cla;
		this.olAdj_TP_Achivement_CurrentYear = olAdj_TP_Achivement_CurrentYear;
		this.ol3_TP_Achivement_CurrentYear = ol3_TP_Achivement_CurrentYear;
		this.notes_TP = notes_TP;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getOl3_Achivement_LastYear() {
		return ol3_Achivement_LastYear;
	}
	public void setOl3_Achivement_LastYear(double ol3_Achivement_LastYear) {
		this.ol3_Achivement_LastYear = ol3_Achivement_LastYear;
	}
	public double getOlAdj_Achivement_CurrentYear() {
		return olAdj_Achivement_CurrentYear;
	}
	public void setOlAdj_Achivement_CurrentYear(double olAdj_Achivement_CurrentYear) {
		this.olAdj_Achivement_CurrentYear = olAdj_Achivement_CurrentYear;
	}
	public double getOl3_Achivement_CurrentYear() {
		return ol3_Achivement_CurrentYear;
	}
	public void setOl3_Achivement_CurrentYear(double ol3_Achivement_CurrentYear) {
		this.ol3_Achivement_CurrentYear = ol3_Achivement_CurrentYear;
	}
	public double getOl3__And_olAdj_Achivement_CurrentYear() {
		return ol3__And_olAdj_Achivement_CurrentYear;
	}
	public void setOl3__And_olAdj_Achivement_CurrentYear(double ol3__And_olAdj_Achivement_CurrentYear) {
		this.ol3__And_olAdj_Achivement_CurrentYear = ol3__And_olAdj_Achivement_CurrentYear;
	}
	public double getOl3_Achivement_LastYear_And_CurrentYear() {
		return ol3_Achivement_LastYear_And_CurrentYear;
	}
	public void setOl3_Achivement_LastYear_And_CurrentYear(double ol3_Achivement_LastYear_And_CurrentYear) {
		this.ol3_Achivement_LastYear_And_CurrentYear = ol3_Achivement_LastYear_And_CurrentYear;
	}
	public String getNotes_cla() {
		return notes_cla;
	}
	public void setNotes_cla(String notes_cla) {
		this.notes_cla = notes_cla;
	}
	public double getOlAdj_TP_Achivement_CurrentYear() {
		return olAdj_TP_Achivement_CurrentYear;
	}
	public void setOlAdj_TP_Achivement_CurrentYear(double olAdj_TP_Achivement_CurrentYear) {
		this.olAdj_TP_Achivement_CurrentYear = olAdj_TP_Achivement_CurrentYear;
	}
	public double getOl3_TP_Achivement_CurrentYear() {
		return ol3_TP_Achivement_CurrentYear;
	}
	public void setOl3_TP_Achivement_CurrentYear(double ol3_TP_Achivement_CurrentYear) {
		this.ol3_TP_Achivement_CurrentYear = ol3_TP_Achivement_CurrentYear;
	}
	public String getNotes_TP() {
		return notes_TP;
	}
	public void setNotes_TP(String notes_TP) {
		this.notes_TP = notes_TP;
	}
	
	@Override
	public String toString() {
		return "ReportForEM_Ol3 [company=" + company + ", ol3_Achivement_LastYear=" + ol3_Achivement_LastYear
				+ ", olAdj_Achivement_CurrentYear=" + olAdj_Achivement_CurrentYear + ", ol3_Achivement_CurrentYear="
				+ ol3_Achivement_CurrentYear + ", ol3__And_olAdj_Achivement_CurrentYear="
				+ ol3__And_olAdj_Achivement_CurrentYear + ", ol3_Achivement_LastYear_And_CurrentYear="
				+ ol3_Achivement_LastYear_And_CurrentYear + ", notes_cla=" + notes_cla
				+ ", olAdj_TP_Achivement_CurrentYear=" + olAdj_TP_Achivement_CurrentYear
				+ ", ol3_TP_Achivement_CurrentYear=" + ol3_TP_Achivement_CurrentYear + ", notes_TP=" + notes_TP + "]";
	}
	
	
	

}
