package web.member.member.bean;

import java.sql.Timestamp;

public class MemberStatus {
	private Integer memberStatusId;
	private String memberStatus;
	private Timestamp createAt;
	public Integer getMemberStatusId() {
		return memberStatusId;
	}
	public void setMemberStatusId(Integer memberStatusId) {
		this.memberStatusId = memberStatusId;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
}
