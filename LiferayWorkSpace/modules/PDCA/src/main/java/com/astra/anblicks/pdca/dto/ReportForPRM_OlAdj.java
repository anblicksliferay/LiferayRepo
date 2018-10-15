package com.astra.anblicks.pdca.dto;

public class ReportForPRM_OlAdj {
	
	private String company;
	private double FY_Audited_LastYear;
	private double Target_CurrentYear;
	private double OlAdj_CurrentYear;
	private double Achivement_Ol;
	private String notes_target;
	private String notes_Achivement;
	
	
	
	public ReportForPRM_OlAdj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportForPRM_OlAdj(String company, double fY_Audited_LastYear, double target_CurrentYear,
			double olAdj_CurrentYear, double achivement_Ol, String notes_target, String notes_Achivement) {
		super();
		this.company = company;
		FY_Audited_LastYear = fY_Audited_LastYear;
		Target_CurrentYear = target_CurrentYear;
		OlAdj_CurrentYear = olAdj_CurrentYear;
		Achivement_Ol = achivement_Ol;
		this.notes_target = notes_target;
		this.notes_Achivement = notes_Achivement;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getFY_Audited_LastYear() {
		return FY_Audited_LastYear;
	}
	public void setFY_Audited_LastYear(double fY_Audited_LastYear) {
		FY_Audited_LastYear = fY_Audited_LastYear;
	}
	public double getTarget_CurrentYear() {
		return Target_CurrentYear;
	}
	public void setTarget_CurrentYear(double target_CurrentYear) {
		Target_CurrentYear = target_CurrentYear;
	}
	public double getOlAdj_CurrentYear() {
		return OlAdj_CurrentYear;
	}
	public void setOlAdj_CurrentYear(double olAdj_CurrentYear) {
		OlAdj_CurrentYear = olAdj_CurrentYear;
	}
	public double getAchivement_Ol() {
		return Achivement_Ol;
	}
	public void setAchivement_Ol(double achivement_Ol) {
		Achivement_Ol = achivement_Ol;
	}
	public String getNotes_target() {
		return notes_target;
	}
	public void setNotes_target(String notes_target) {
		this.notes_target = notes_target;
	}
	public String getNotes_Achivement() {
		return notes_Achivement;
	}
	public void setNotes_Achivement(String notes_Achivement) {
		this.notes_Achivement = notes_Achivement;
	}

	@Override
	public String toString() {
		return "ReportForPRM_OlAdj [company=" + company + ", FY_Audited_LastYear=" + FY_Audited_LastYear
				+ ", Target_CurrentYear=" + Target_CurrentYear + ", OlAdj_CurrentYear=" + OlAdj_CurrentYear
				+ ", Achivement_Ol=" + Achivement_Ol + ", notes_target=" + notes_target + ", notes_Achivement="
				+ notes_Achivement + "]";
	}
}
