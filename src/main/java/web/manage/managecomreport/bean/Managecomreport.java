package web.manage.managecomreport.bean;

import java.sql.Timestamp;


public class Managecomreport {
    private Integer manageComReportId;
    private Integer manageId;
    private Integer comPostId;
    private Integer memberNo;
    private String manageReason;
    private Timestamp manageRtime;
    private Timestamp managePtime;
    private Boolean manageResult;
    private Integer comReplyId;
    private Integer comReplyTo;
    private String  comReplyContent;
    private Timestamp comReplyTime;
    private Boolean comReplyAccessSetting;
    private String comPostTitle;
    private String comPostContent;
    private Timestamp comPostTime;
    private Boolean comPostStates;
    private Boolean comPostAccessSetting;
	public Integer getManageComReportId() {
		return manageComReportId;
	}
	public void setManageComReportId(Integer manageComReportId) {
		this.manageComReportId = manageComReportId;
	}
	public Integer getManageId() {
		return manageId;
	}
	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}
	public Integer getComPostId() {
		return comPostId;
	}
	public void setComPostId(Integer comPostId) {
		this.comPostId = comPostId;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getManageReason() {
		return manageReason;
	}
	public void setManageReason(String manageReason) {
		this.manageReason = manageReason;
	}
	public Timestamp getManageRtime() {
		return manageRtime;
	}
	public void setManageRtime(Timestamp manageRtime) {
		this.manageRtime = manageRtime;
	}
	public Timestamp getManagePtime() {
		return managePtime;
	}
	public void setManagePtime(Timestamp managePtime) {
		this.managePtime = managePtime;
	}
	public Boolean getManageResult() {
		return manageResult;
	}
	public void setManageResult(Boolean manageResult) {
		this.manageResult = manageResult;
	}
	public Integer getComReplyId() {
		return comReplyId;
	}
	public void setComReplyId(Integer comReplyId) {
		this.comReplyId = comReplyId;
	}
	public Integer getComReplyTo() {
		return comReplyTo;
	}
	public void setComReplyTo(Integer comReplyTo) {
		this.comReplyTo = comReplyTo;
	}
	public String getComReplyContent() {
		return comReplyContent;
	}
	public void setComReplyContent(String comReplyContent) {
		this.comReplyContent = comReplyContent;
	}
	public Timestamp getComReplyTime() {
		return comReplyTime;
	}
	public void setComReplyTime(Timestamp comReplyTime) {
		this.comReplyTime = comReplyTime;
	}
	public Boolean getComReplyAccessSetting() {
		return comReplyAccessSetting;
	}
	public void setComReplyAccessSetting(Boolean comReplyAccessSetting) {
		this.comReplyAccessSetting = comReplyAccessSetting;
	}
	public String getComPostTitle() {
		return comPostTitle;
	}
	public void setComPostTitle(String comPostTitle) {
		this.comPostTitle = comPostTitle;
	}
	public String getComPostContent() {
		return comPostContent;
	}
	public void setComPostContent(String comPostContent) {
		this.comPostContent = comPostContent;
	}
	public Timestamp getComPostTime() {
		return comPostTime;
	}
	public void setComPostTime(Timestamp comPostTime) {
		this.comPostTime = comPostTime;
	}
	public Boolean getComPostStates() {
		return comPostStates;
	}
	public void setComPostStates(Boolean comPostStates) {
		this.comPostStates = comPostStates;
	}
	public Boolean getComPostAccessSetting() {
		return comPostAccessSetting;
	}
	public void setComPostAccessSetting(Boolean comPostAccessSetting) {
		this.comPostAccessSetting = comPostAccessSetting;
	}
	@Override
	public String toString() {
		return "Managecomreport [manageComReportId=" + manageComReportId + ", manageId=" + manageId + ", comPostId="
				+ comPostId + ", memberNo=" + memberNo + ", manageReason=" + manageReason + ", manageRtime="
				+ manageRtime + ", managePtime=" + managePtime + ", manageResult=" + manageResult + ", comReplyId="
				+ comReplyId + ", comReplyTo=" + comReplyTo + ", comReplyContent=" + comReplyContent + ", comReplyTime="
				+ comReplyTime + ", comReplyAccessSetting=" + comReplyAccessSetting + ", comPostTitle=" + comPostTitle
				+ ", comPostContent=" + comPostContent + ", comPostTime=" + comPostTime + ", comPostStates="
				+ comPostStates + ", comPostAccessSetting=" + comPostAccessSetting + "]";
	}
}