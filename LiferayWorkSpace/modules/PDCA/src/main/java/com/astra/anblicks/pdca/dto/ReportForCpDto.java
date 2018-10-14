package com.astra.anblicks.pdca.dto;

public class ReportForCpDto {
	
	private String company;
	private double FY_Audited_LastYear;
	private double TP_TargetCLA_CurrentYear;
	private double TP_CPOl3_CurrentYear;
	private double OneOff_Ol3_CurrentYear;
	private double TP_CLAOl3_CurrentYear;
	private double Achivement_Ol3_CurrentYear;
	private String Notes_Target;
	
	public ReportForCpDto(String company, double fY_Audited_LastYear, double tP_TargetCLA_CurrentYear,
			double tP_CPOl3_CurrentYear, double oneOff_Ol3_CurrentYear, double tP_CLAOl3_CurrentYear,
			double achivement_Ol3_CurrentYear, String notes_Target) {
		super();
		this.company = company;
		FY_Audited_LastYear = fY_Audited_LastYear;
		TP_TargetCLA_CurrentYear = tP_TargetCLA_CurrentYear;
		TP_CPOl3_CurrentYear = tP_CPOl3_CurrentYear;
		OneOff_Ol3_CurrentYear = oneOff_Ol3_CurrentYear;
		TP_CLAOl3_CurrentYear = tP_CLAOl3_CurrentYear;
		Achivement_Ol3_CurrentYear = achivement_Ol3_CurrentYear;
		Notes_Target = notes_Target;
	}

	public ReportForCpDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public double getTP_TargetCLA_CurrentYear() {
		return TP_TargetCLA_CurrentYear;
	}

	public void setTP_TargetCLA_CurrentYear(double tP_TargetCLA_CurrentYear) {
		TP_TargetCLA_CurrentYear = tP_TargetCLA_CurrentYear;
	}

	public double getTP_CPOl3_CurrentYear() {
		return TP_CPOl3_CurrentYear;
	}

	public void setTP_CPOl3_CurrentYear(double tP_CPOl3_CurrentYear) {
		TP_CPOl3_CurrentYear = tP_CPOl3_CurrentYear;
	}

	public double getOneOff_Ol3_CurrentYear() {
		return OneOff_Ol3_CurrentYear;
	}

	public void setOneOff_Ol3_CurrentYear(double oneOff_Ol3_CurrentYear) {
		OneOff_Ol3_CurrentYear = oneOff_Ol3_CurrentYear;
	}

	public double getTP_CLAOl3_CurrentYear() {
		return TP_CLAOl3_CurrentYear;
	}

	public void setTP_CLAOl3_CurrentYear(double tP_CLAOl3_CurrentYear) {
		TP_CLAOl3_CurrentYear = tP_CLAOl3_CurrentYear;
	}

	public double getAchivement_Ol3_CurrentYear() {
		return Achivement_Ol3_CurrentYear;
	}

	public void setAchivement_Ol3_CurrentYear(double achivement_Ol3_CurrentYear) {
		Achivement_Ol3_CurrentYear = achivement_Ol3_CurrentYear;
	}

	public String getNotes_Target() {
		return Notes_Target;
	}

	public void setNotes_Target(String notes_Target) {
		Notes_Target = notes_Target;
	}

	@Override
	public String toString() {
		return "ReportForCpDto [company=" + company + ", FY_Audited_LastYear=" + FY_Audited_LastYear
				+ ", TP_TargetCLA_CurrentYear=" + TP_TargetCLA_CurrentYear + ", TP_CPOl3_CurrentYear="
				+ TP_CPOl3_CurrentYear + ", OneOff_Ol3_CurrentYear=" + OneOff_Ol3_CurrentYear
				+ ", TP_CLAOl3_CurrentYear=" + TP_CLAOl3_CurrentYear + ", Achivement_Ol3_CurrentYear="
				+ Achivement_Ol3_CurrentYear + ", Notes_Target=" + Notes_Target + "]";
	}
	
	

}
