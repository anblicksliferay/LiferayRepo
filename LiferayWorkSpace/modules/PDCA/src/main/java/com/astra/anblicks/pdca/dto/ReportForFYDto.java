package com.astra.anblicks.pdca.dto;

public class ReportForFYDto {
	private String company;
	private double ol3_Achivement_LastYear;
	private double olAdj_Achivement_CurrentYear;
	private double ol3_Achivement_CurrentYear;
	private double fy_Achivement_CurrentYear;
	private double fy__And_ol3_Achivement_CurrentYear;
	private double ol3_Achivement_LastYear_And_CurrentYear;
	private String notes_cla;
	private double olAdj_TP_Achivement_CurrentYear;
	private double ol3_TP_Achivement_CurrentYear;
	private double fy_TP_Achivement_CurrentYear;
	
	
	public ReportForFYDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportForFYDto(String company, double ol3_Achivement_LastYear, double olAdj_Achivement_CurrentYear,
			double ol3_Achivement_CurrentYear, double fy_Achivement_CurrentYear,
			double fy__And_ol3_Achivement_CurrentYear, double ol3_Achivement_LastYear_And_CurrentYear, String notes_cla,
			double olAdj_TP_Achivement_CurrentYear, double ol3_TP_Achivement_CurrentYear,
			double fy_TP_Achivement_CurrentYear) {
		super();
		this.company = company;
		this.ol3_Achivement_LastYear = ol3_Achivement_LastYear;
		this.olAdj_Achivement_CurrentYear = olAdj_Achivement_CurrentYear;
		this.ol3_Achivement_CurrentYear = ol3_Achivement_CurrentYear;
		this.fy_Achivement_CurrentYear = fy_Achivement_CurrentYear;
		this.fy__And_ol3_Achivement_CurrentYear = fy__And_ol3_Achivement_CurrentYear;
		this.ol3_Achivement_LastYear_And_CurrentYear = ol3_Achivement_LastYear_And_CurrentYear;
		this.notes_cla = notes_cla;
		this.olAdj_TP_Achivement_CurrentYear = olAdj_TP_Achivement_CurrentYear;
		this.ol3_TP_Achivement_CurrentYear = ol3_TP_Achivement_CurrentYear;
		this.fy_TP_Achivement_CurrentYear = fy_TP_Achivement_CurrentYear;
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
	public double getFy_Achivement_CurrentYear() {
		return fy_Achivement_CurrentYear;
	}
	public void setFy_Achivement_CurrentYear(double fy_Achivement_CurrentYear) {
		this.fy_Achivement_CurrentYear = fy_Achivement_CurrentYear;
	}
	public double getFy__And_ol3_Achivement_CurrentYear() {
		return fy__And_ol3_Achivement_CurrentYear;
	}
	public void setFy__And_ol3_Achivement_CurrentYear(double fy__And_ol3_Achivement_CurrentYear) {
		this.fy__And_ol3_Achivement_CurrentYear = fy__And_ol3_Achivement_CurrentYear;
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
	public double getFy_TP_Achivement_CurrentYear() {
		return fy_TP_Achivement_CurrentYear;
	}
	public void setFy_TP_Achivement_CurrentYear(double fy_TP_Achivement_CurrentYear) {
		this.fy_TP_Achivement_CurrentYear = fy_TP_Achivement_CurrentYear;
	}

	@Override
	public String toString() {
		return "ReportForFYDto [company=" + company + ", ol3_Achivement_LastYear=" + ol3_Achivement_LastYear
				+ ", olAdj_Achivement_CurrentYear=" + olAdj_Achivement_CurrentYear + ", ol3_Achivement_CurrentYear="
				+ ol3_Achivement_CurrentYear + ", fy_Achivement_CurrentYear=" + fy_Achivement_CurrentYear
				+ ", fy__And_ol3_Achivement_CurrentYear=" + fy__And_ol3_Achivement_CurrentYear
				+ ", ol3_Achivement_LastYear_And_CurrentYear=" + ol3_Achivement_LastYear_And_CurrentYear
				+ ", notes_cla=" + notes_cla + ", olAdj_TP_Achivement_CurrentYear=" + olAdj_TP_Achivement_CurrentYear
				+ ", ol3_TP_Achivement_CurrentYear=" + ol3_TP_Achivement_CurrentYear + ", fy_TP_Achivement_CurrentYear="
				+ fy_TP_Achivement_CurrentYear + "]";
	}
	
	
	

}
