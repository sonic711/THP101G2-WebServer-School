package web.manage.manageaccount.bean;



public class Manageaccount {
	private Integer manageId;
	private Integer manageAc;
	private Integer managePass ;
	private String manageName;
	private Integer manageApplyId;
	private Boolean manageCom;
	private Boolean manageFirm;
	private Boolean manageCourse;
	private Boolean manageMember;
	private Boolean manageReport;
	public Integer getManageId() {
		return manageId;
	}
	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}
	public Integer getManageAc() {
		return manageAc;
	}
	public void setManageAc(Integer manageAc) {
		this.manageAc = manageAc;
	}
	public Integer getManagePass() {
		return managePass;
	}
	public void setManagePass(Integer managePass) {
		this.managePass = managePass;
	}
	public String getManageName() {
		return manageName;
	}
	public void setManageName(String manageName) {
		this.manageName = manageName;
	}
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
		return "Manageaccount [manageId=" + manageId + ", manageAc=" + manageAc + ", managePass=" + managePass
				+ ", manageName=" + manageName + ", manageApplyId=" + manageApplyId + ", manageCom=" + manageCom
				+ ", manageFirm=" + manageFirm + ", manageCourse=" + manageCourse + ", manageMember=" + manageMember
				+ ", manageReport=" + manageReport + "]";
	}


}