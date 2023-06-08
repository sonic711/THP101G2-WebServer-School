package web.manage.teaapply.bean;

import java.sql.Timestamp;

public class Teaapply {
	private Integer teaId;
	private Integer memberNo;
	private Integer manageId;
	private Timestamp teaApplyTime;
	private Timestamp managePtime;
	private String teaCheck;
	private Boolean teaResult;
	private String nickName;
	private Integer phoneNumber;
	private String memberEmail;
	private Boolean memberStatus;
	public Integer getTeaId() {
		return teaId;
	}
	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public Integer getManageId() {
		return manageId;
	}
	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}
	public Timestamp getTeaApplyTime() {
		return teaApplyTime;
	}
	public void setTeaApplyTime(Timestamp teaApplyTime) {
		this.teaApplyTime = teaApplyTime;
	}
	public Timestamp getManagePtime() {
		return managePtime;
	}
	public void setManagePtime(Timestamp managePtime) {
		this.managePtime = managePtime;
	}
	public String getTeaCheck() {
		return teaCheck;
	}
	public void setTeaCheck(String teaCheck) {
		this.teaCheck = teaCheck;
	}
	public Boolean getTeaResult() {
		return teaResult;
	}
	public void setTeaResult(Boolean teaResult) {
		this.teaResult = teaResult;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Boolean getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(Boolean memberStatus) {
		this.memberStatus = memberStatus;
	}
	@Override
	public String toString() {
		return "Teaapply [teaId=" + teaId + ", memberNo=" + memberNo + ", manageId=" + manageId + ", teaApplyTime="
				+ teaApplyTime + ", managePtime=" + managePtime + ", teaCheck=" + teaCheck + ", teaResult=" + teaResult
				+ ", nickName=" + nickName + ", phoneNumber=" + phoneNumber + ", memberEmail=" + memberEmail
				+ ", memberStatus=" + memberStatus + "]";
	}
	
//	private String notificationContent;
	
	
	
	
}


