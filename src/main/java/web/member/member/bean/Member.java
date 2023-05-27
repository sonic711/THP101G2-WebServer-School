package web.member.member.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class Member {
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", userId=" + userId + ", password=" + password + ", nickname="
				+ nickname + ", memberIdentity=" + memberIdentity + ", phoneNumber=" + phoneNumber + ", memberEmail="
				+ memberEmail + ", profilePhoto=" + Arrays.toString(profilePhoto) + ", coverPicture="
				+ Arrays.toString(coverPicture) + ", memberStatus=" + memberStatus + ", introduction=" + introduction
				+ ", rewardPoints=" + rewardPoints + ", createAt=" + createAt + "]";
	}
	private Integer memberNo;
	private String userId;
	private String password;
	private String nickname;
	private String memberIdentity;
	private String phoneNumber;
	private String memberEmail;
	private byte[] profilePhoto;
	private byte[] coverPicture;
	private Integer memberStatus;
	private String introduction;
	private Integer rewardPoints;
	private Timestamp createAt;
	
	
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMemberIdentity() {
		return memberIdentity;
	}
	public void setMemberIdentity(String memberIdentity) {
		this.memberIdentity = memberIdentity;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public byte[] getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public byte[] getCoverPicture() {
		return coverPicture;
	}
	public void setCoverPicture(byte[] coverPicture) {
		this.coverPicture = coverPicture;
	}
	public Integer getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(Integer memberStatus) {
		this.memberStatus = memberStatus;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
}
