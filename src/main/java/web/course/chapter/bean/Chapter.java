package web.course.chapter.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class Chapter {




	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public Integer getChapterSequence() {
		return chapterSequence;
	}
	public void setChapterSequence(Integer chapterSequence) {
		this.chapterSequence = chapterSequence;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	@Override
	public String toString() {
		return "Chapter [chapterId=" + chapterId + ", chapterName=" + chapterName + ", courseId=" + courseId
				+ ", video=" + video + ", chapterSequence=" + chapterSequence + ", updateTime=" + updateTime
				+ ", courseName=" + courseName + "]";
	}

	private Integer chapterId;
	private String chapterName;
	private Integer courseId;
	private String video;
	private Integer chapterSequence;
    private Timestamp updateTime;
    private String courseName;

}
