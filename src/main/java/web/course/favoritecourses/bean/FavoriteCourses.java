package web.course.favoritecourses.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class FavoriteCourses {
	

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
	public Integer getFavoriteCoursesId() {
		return favoriteCoursesId;
	}
	public void setFavoriteCoursesId(Integer favoriteCoursesId) {
		this.favoriteCoursesId = favoriteCoursesId;
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
	public Boolean getFavoriteCourses() {
		return favoriteCourses;
	}
	public void setFavoriteCourses(Boolean favoriteCourses) {
		this.favoriteCourses = favoriteCourses;
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

	

	
	public String getCourseUserId() {
		return courseUserId;
	}
	public void setCourseUserId(String courseUserId) {
		this.courseUserId = courseUserId;
	}
	
	@Override
	public String toString() {
		return "FavoriteCourses [courseUserId=" + courseUserId + ", image=" + Arrays.toString(image) + ", courseName="
				+ courseName + ", userId=" + userId + ", favoriteCoursesId=" + favoriteCoursesId + ", courseId="
				+ courseId + ", memberNo=" + memberNo + ", favoriteCourses=" + favoriteCourses + ", updateTime="
				+ updateTime + "]";
	}

	private String courseUserId;
	private byte[] image ;
	private String courseName;
	private String userId;
	private Integer favoriteCoursesId;
    private Integer courseId;
    private Integer memberNo;
    private Boolean favoriteCourses;
    private Timestamp updateTime;


}
