package web.manage.teaapply.bean;

public class Selectmember {
	private Integer memberNo;
	private String nickName;
	private Integer phoneNumber;
	private String memberEmail;
	private Boolean memberStatus;
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
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
		return "Selectmember [memberNo=" + memberNo + ", nickName=" + nickName + ", phoneNumber=" + phoneNumber
				+ ", memberEmail=" + memberEmail + ", memberStatus=" + memberStatus + "]";
	}
	
}
