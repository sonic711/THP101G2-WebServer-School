package web.manage.coursereport.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class Coursereport {
	
	private Integer courseReportId;
	private Integer	manageId; 
	private Integer courseId ;
	private Integer memberNo ;
	private String manageReason;
	private Timestamp manageRtime;
    private Timestamp managePtime;
    private Boolean	manageResult;
    private String courseName;
    private String summary;
    private byte[] video;
    private Boolean addAndRemove;
	public Integer getCourseReportId() {
		return courseReportId;
	}
	public void setCourseReportId(Integer courseReportId) {
		this.courseReportId = courseReportId;
	}
	public Integer getManageId() {
		return manageId;
	}
	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getManageReason() {
		return manageReason;
	}
	public void setManageReason(String manageReason) {
		this.manageReason = manageReason;
	}
	public Timestamp getManageRtime() {
		return manageRtime;
	}
	public void setManageRtime(Timestamp manageRtime) {
		this.manageRtime = manageRtime;
	}
	public Timestamp getManagePtime() {
		return managePtime;
	}
	public void setManagePtime(Timestamp managePtime) {
		this.managePtime = managePtime;
	}
	public Boolean getManageResult() {
		return manageResult;
	}
	public void setManageResult(Boolean manageResult) {
		this.manageResult = manageResult;
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
	@Override
	public String toString() {
		return "Coursereport [courseReportId=" + courseReportId + ", manageId=" + manageId + ", courseId=" + courseId
				+ ", memberNo=" + memberNo + ", manageReason=" + manageReason + ", manageRtime=" + manageRtime
				+ ", managePtime=" + managePtime + ", manageResult=" + manageResult + ", courseName=" + courseName
				+ ", summary=" + summary + ", video=" + Arrays.toString(video) + ", addAndRemove=" + addAndRemove + "]";
	}
	
}
	
