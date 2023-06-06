package web.point.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class PointChanged implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pointChangedId;
	private Integer memberNo;
	private Integer commentId;
	private Integer shopOrderId;
	private Integer studentCoursesId;
	private Integer loginRecordId;
	private Integer valueOfChanged;
	private Integer rewardPoints;
	private Timestamp creatAt;
	private String type;
	
	public PointChanged() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "PointChanged [pointChangedId=" + pointChangedId + ", memberNo=" + memberNo + ", commentId=" + commentId
				+ ", shopOrderId=" + shopOrderId + ", studentCoursesId=" + studentCoursesId + ", loginRecordId=" + loginRecordId
				+ ", valueOfChanged=" + valueOfChanged + ", creatAt=" + creatAt + "]";
	}



	public PointChanged(Integer pointChangedId, Integer memberNo, Integer commentId, Integer shopOrderId,
			Integer studentCoursesId, Integer loginRecordId, Integer valueOfChanged, Integer rewardPoints,
			Timestamp creatAt, String type) {
		super();
		this.pointChangedId = pointChangedId;
		this.memberNo = memberNo;
		this.commentId = commentId;
		this.shopOrderId = shopOrderId;
		this.studentCoursesId = studentCoursesId;
		this.loginRecordId = loginRecordId;
		this.valueOfChanged = valueOfChanged;
		this.rewardPoints = rewardPoints;
		this.creatAt = creatAt;
		this.type = type;
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



	public Integer getShopOrderId() {
		return shopOrderId;
	}



	public void setShopOrderId(Integer shopOrderId) {
		this.shopOrderId = shopOrderId;
	}



	public Integer getStudentCoursesId() {
		return studentCoursesId;
	}



	public void setStudentCoursesId(Integer studentCoursesId) {
		this.studentCoursesId = studentCoursesId;
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



	public Integer getRewardPoints() {
		return rewardPoints;
	}



	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}



	public Timestamp getCreatAt() {
		return creatAt;
	}



	public void setCreatAt(Timestamp creatAt) {
		this.creatAt = creatAt;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	
	
//	public PointChanged(Integer pointChangedId, Integer memberNo, Integer commentId, Integer orderId,
//			Integer studentCourseId, Integer loginRecordId, Integer valueOfChanged, Timestamp creatAt) {
//		super();
//		this.pointChangedId = pointChangedId;
//		this.memberNo = memberNo;
//		this.commentId = commentId;
//		this.shopOrderId = orderId;
//		this.studentCoursesId = studentCourseId;
//		this.loginRecordId = loginRecordId;
//		this.valueOfChanged = valueOfChanged;
//		this.creatAt = creatAt;
//	}
//
//
//
//	public Integer getPointChangedId() {
//		return pointChangedId;
//	}
//
//
//
//	public void setPointChangedId(Integer pointChangedId) {
//		this.pointChangedId = pointChangedId;
//	}
//
//
//
//	public Integer getMemberNo() {
//		return memberNo;
//	}
//
//
//
//	public void setMemberNo(Integer memberNo) {
//		this.memberNo = memberNo;
//	}
//
//
//
//	public Integer getCommentId() {
//		return commentId;
//	}
//
//
//
//	public void setCommentId(Integer commentId) {
//		this.commentId = commentId;
//	}
//
//
//
//	public Integer getShopOrderId() {
//		return shopOrderId;
//	}
//
//
//
//	public void setShopOrderId(Integer shopOrderId) {
//		this.shopOrderId = shopOrderId;
//	}
//
//
//
//	public Integer getStudentCoursesId() {
//		return studentCoursesId;
//	}
//
//
//
//	public void setStudentCoursesId(Integer studentCoursesId) {
//		this.studentCoursesId = studentCoursesId;
//	}
//
//
//
//	public Integer getLoginRecordId() {
//		return loginRecordId;
//	}
//
//
//
//	public void setLoginRecordId(Integer loginRecordId) {
//		this.loginRecordId = loginRecordId;
//	}
//
//
//
//	public Integer getValueOfChanged() {
//		return valueOfChanged;
//	}
//
//
//
//	public void setValueOfChanged(Integer valueOfChanged) {
//		this.valueOfChanged = valueOfChanged;
//	}
//
//
//
//	public Integer getRewardPoints() {
//		return rewardPoints;
//	}
//
//
//
//	public void setRewardPoints(Integer rewardPoints) {
//		this.rewardPoints = rewardPoints;
//	}
//
//
//
//	public Timestamp getCreatAt() {
//		return creatAt;
//	}
//
//
//
//	public void setCreatAt(Timestamp creatAt) {
//		this.creatAt = creatAt;
//	}



	
	

}
