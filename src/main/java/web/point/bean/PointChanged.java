package web.point.bean;

import java.io.Serializable;

import java.sql.Timestamp;

public class PointChanged implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pointChangedId;
	private Integer memberNo;
	private Integer commentId;
	private Integer orderId;
	private Integer studentCourseId;
	private Integer loginRecordId;
	private Integer valueOfChanged;
	private Integer rewardPoints;
	private Timestamp creatAt;
	
	public PointChanged() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "PointChanged [pointChangedId=" + pointChangedId + ", memberNo=" + memberNo + ", commentId=" + commentId
				+ ", orderId=" + orderId + ", studentCourseId=" + studentCourseId + ", loginRecordId=" + loginRecordId
				+ ", valueOfChanged=" + valueOfChanged + ", creatAt=" + creatAt + "]";
	}
	
	
	
	public PointChanged(Integer pointChangedId, Integer memberNo, Integer commentId, Integer orderId,
			Integer studentCourseId, Integer loginRecordId, Integer valueOfChanged, Timestamp creatAt) {
		super();
		this.pointChangedId = pointChangedId;
		this.memberNo = memberNo;
		this.commentId = commentId;
		this.orderId = orderId;
		this.studentCourseId = studentCourseId;
		this.loginRecordId = loginRecordId;
		this.valueOfChanged = valueOfChanged;
		this.creatAt = creatAt;
	}



	public Integer getPointChangedId() {
		return pointChangedId;
	}



	public void setPointChangedId(Integer pointChangedId) {
		this.pointChangedId = pointChangedId;
	}



	public Integer getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}



	public Integer getCommentId() {
		return commentId;
	}



	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}



	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	public Integer getStudentCourseId() {
		return studentCourseId;
	}



	public void setStudentCourseId(Integer studentCourseId) {
		this.studentCourseId = studentCourseId;
	}



	public Integer getLoginRecordId() {
		return loginRecordId;
	}



	public void setLoginRecordId(Integer loginRecordId) {
		this.loginRecordId = loginRecordId;
	}



	public Integer getValueOfChanged() {
		return valueOfChanged;
	}



	public void setValueOfChanged(Integer valueOfChanged) {
		this.valueOfChanged = valueOfChanged;
	}



	public Timestamp getCreatAt() {
		return creatAt;
	}



	public void setCreatAt(Timestamp creatAt) {
		this.creatAt = creatAt;
	}



	public Integer getRewardPoints() {
		return rewardPoints;
	}



	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	

}
