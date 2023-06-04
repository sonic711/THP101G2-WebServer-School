package web.course.comment.bean;

import java.sql.Timestamp;
import java.util.Arrays;

import com.mysql.cj.jdbc.Blob;

public class Comment {
	




	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Boolean getCommentReport() {
		return commentReport;
	}
	public void setCommentReport(Boolean commentReport) {
		this.commentReport = commentReport;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", memberNo=" + memberNo + ", courseId=" + courseId + ", rating="
				+ rating + ", comment=" + comment + ", image=" + Arrays.toString(image) + ", commentReport="
				+ commentReport + ", courseName=" + courseName + ", userId=" + userId + ", updateTime=" + updateTime
				+ "]";
	}




	private Integer commentId;
	private Integer memberNo;
	private Integer courseId;
	private Integer rating;
	private String comment;
	private byte[] image;
	private Boolean commentReport;
	private String courseName;
	private String userId;
    private Timestamp updateTime;

}
