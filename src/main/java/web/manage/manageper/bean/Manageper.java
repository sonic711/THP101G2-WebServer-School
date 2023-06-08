package web.manage.manageper.bean;

public class Manageper {
	private Integer manageApplyId;
	private Boolean	manageCom;
	private Boolean	manageFirm;
	private Boolean manageCourse;
	private Boolean manageMember;
	private Boolean manageReport;
	public Integer getManageApplyId() {
		return manageApplyId;
	}
	public void setManageApplyId(Integer manageApplyId) {
		this.manageApplyId = manageApplyId;
	}
	public Boolean getManageCom() {
		return manageCom;
	}
	public void setManageCom(Boolean manageCom) {
		this.manageCom = manageCom;
	}
	public Boolean getManageFirm() {
		return manageFirm;
	}
	public void setManageFirm(Boolean manageFirm) {
		this.manageFirm = manageFirm;
	}
	public Boolean getManageCourse() {
		return manageCourse;
	}
	public void setManageCourse(Boolean manageCourse) {
		this.manageCourse = manageCourse;
	}
	public Boolean getManageMember() {
		return manageMember;
	}
	public void setManageMember(Boolean manageMember) {
		this.manageMember = manageMember;
	}
	public Boolean getManageReport() {
		return manageReport;
	}
	public void setManageReport(Boolean manageReport) {
		this.manageReport = manageReport;
	}
	@Override
	public String toString() {
		return "Manageper [manageApplyId=" + manageApplyId + ", manageCom=" + manageCom + ", manageFirm=" + manageFirm
				+ ", manageCourse=" + manageCourse + ", manageMember=" + manageMember + ", manageReport=" + manageReport
				+ "]";
	}
	
}
