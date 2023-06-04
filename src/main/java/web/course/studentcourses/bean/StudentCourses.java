package web.course.studentcourses.bean;

import java.sql.Timestamp;

public class StudentCourses {
	



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
	public Integer getStudentCoursesId() {
		return studentCoursesId;
	}
	public void setStudentCoursesId(Integer studentCoursesId) {
		this.studentCoursesId = studentCoursesId;
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
	public Boolean getCoursesProgress() {
		return coursesProgress;
	}
	public void setCoursesProgress(Boolean coursesProgress) {
		this.coursesProgress = coursesProgress;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	
	@Override
	public String toString() {
		return "StudentCourses [courseName=" + courseName + ", userId=" + userId + ", studentCoursesId="
				+ studentCoursesId + ", memberNo=" + memberNo + ", courseId=" + courseId + ", coursesProgress="
				+ coursesProgress + ", updateTime=" + updateTime + "]";
	}


	private String courseName;
	private String userId;
	private Integer studentCoursesId;
    private Integer memberNo;
    private Integer courseId;
    private Boolean coursesProgress;
    private Timestamp updateTime;
}
