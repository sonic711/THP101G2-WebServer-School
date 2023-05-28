package web.course.course.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class Course {

	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Boolean getAddAndRemove() {
		return addAndRemove;
	}
	public void setAddAndRemove(Boolean addAndRemove) {
		this.addAndRemove = addAndRemove;
	}
	public Boolean getCoursesReport() {
		return coursesReport;
	}
	public void setCoursesReport(Boolean coursesReport) {
		this.coursesReport = coursesReport;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	private Integer courseId;
	    @Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", memberNo=" + memberNo + ", summary="
				+ summary + ", addAndRemove=" + addAndRemove + ", coursesReport=" + coursesReport + ", updateTime="
				+ updateTime + ", image=" + Arrays.toString(image) + ", userId=" + userId + ", rating=" + rating + "]";
	}
		private String courseName;
	    private Integer memberNo;
	    private String summary;
	    private Boolean addAndRemove;
	    private Boolean coursesReport;
	    private Timestamp updateTime;
	    private byte[] image;
	    private String userId;
	    private Integer rating;

}
