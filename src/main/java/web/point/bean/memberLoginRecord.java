package web.point.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class memberLoginRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer loginRecordId;
	private Integer memberNo;
	private Timestamp loginTime;
	private Timestamp creatAt;


	public memberLoginRecord() {
	}

	public memberLoginRecord(Integer loginRecordId, Integer memberNo, Timestamp loginTime, Timestamp creatAt) {
		super();
		this.loginRecordId = loginRecordId;
		this.memberNo = memberNo;
		this.loginTime = loginTime;
		this.creatAt = creatAt;
	}

	public Integer getLoginRecordId() {
		return loginRecordId;
	}

	public void setLoginRecordId(Integer loginRecordId) {
		this.loginRecordId = loginRecordId;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(Timestamp creatAt) {
		this.creatAt = creatAt;
	}
	
	
	
	
	
	
	
	
}
