package web.manage.courseapply.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class Courseapply {
	private Integer courseApplyId;
	private Integer courseId;
	private Integer manageId;
	private Integer memberNo;
	private Timestamp classApplyTime;
	private Timestamp managePtime;
	private boolean classCheck;
	private boolean classResult;
	private String courseName;
    private String summary;
    private byte[] video;
    private Boolean addAndRemove;
    private Boolean CoursesReport;
    private Timestamp UpDateTime;
    private Integer chapterId;
    private String chapterName;
    private Timestamp ChapterUpDateTime;
	
    
    public Integer getCourseApplyId() {
		return courseApplyId;
	}
	public void setCourseApplyId(Integer courseApplyId) {
		this.courseApplyId = courseApplyId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getManageId() {
		return manageId;
	}
	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public Timestamp getClassApplyTime() {
		return classApplyTime;
	}
	public void setClassApplyTime(Timestamp classApplyTime) {
		this.classApplyTime = classApplyTime;
	}
	public Timestamp getManagePtime() {
		return managePtime;
	}
	public void setManagePtime(Timestamp managePtime) {
		this.managePtime = managePtime;
	}
	public boolean getClassCheck() {
		return classCheck;
	}
	public void setClassCheck(boolean classCheck) {
		this.classCheck = classCheck;
	}
	public boolean getClassResult() {
		return classResult;
	}
	public void setClassResult(boolean classResult) {
		this.classResult = classResult;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public byte[] getVideo() {
		return video;
	}
	public void setVideo(byte[] video) {
		this.video = video;
	}
	public Boolean getAddAndRemove() {
		return addAndRemove;
	}
	public void setAddAndRemove(Boolean addAndRemove) {
		this.addAndRemove = addAndRemove;
	}
	public Boolean getCoursesReport() {
		return CoursesReport;
	}
	public void setCoursesReport(Boolean coursesReport) {
		CoursesReport = coursesReport;
	}
	public Timestamp getUpDateTime() {
		return UpDateTime;
	}
	public void setUpDateTime(Timestamp upDateTime) {
		UpDateTime = upDateTime;
	}
	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public Timestamp getChapterUpDateTime() {
		return ChapterUpDateTime;
	}
	public void setChapterUpDateTime(Timestamp chapterUpDateTime) {
		ChapterUpDateTime = chapterUpDateTime;
	}
	@Override
	public String toString() {
		return "Courseapply [courseApplyId=" + courseApplyId + ", courseId=" + courseId + ", manageId=" + manageId
				+ ", memberNo=" + memberNo + ", classApplyTime=" + classApplyTime + ", managePtime=" + managePtime
				+ ", classCheck=" + classCheck + ", classResult=" + classResult + ", courseName=" + courseName
				+ ", summary=" + summary + ", video=" + Arrays.toString(video) + ", addAndRemove=" + addAndRemove
				+ ", CoursesReport=" + CoursesReport + ", UpDateTime=" + UpDateTime + ", chapterId=" + chapterId
				+ ", chapterName=" + chapterName + ", ChapterUpDateTime=" + ChapterUpDateTime + "]";
	}
    
    
}