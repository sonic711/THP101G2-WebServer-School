package web.member.follow.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class Followers {
	private Integer memberFollowingId;
	private Integer memberNo;
	private Integer memberFollowing;
	private String userId;
	private String nickname;
	private String memberIdentity;
	private byte[] profilePhoto;
	private String profilePhoto64;
	private Integer memberStatus;
	private String introduction;
	private Timestamp followTime;

	@Override
	public String toString() {
		return "Followers [memberFollowingId=" + memberFollowingId + ", memberNo=" + memberNo + ", memberFollowing="
				+ memberFollowing + ", userId=" + userId + ", nickname=" + nickname + ", memberIdentity="
				+ memberIdentity + ", profilePhoto=" + Arrays.toString(profilePhoto) + ", profilePhoto64="
				+ profilePhoto64 + ", memberStatus=" + memberStatus + ", introduction=" + introduction + ", followTime="
				+ followTime + "]";
	}

	public Integer getMemberFollowingId() {
		return memberFollowingId;
	}

	public void setMemberFollowingId(Integer memberFollowingId) {
		this.memberFollowingId = memberFollowingId;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getMemberFollowing() {
		return memberFollowing;
	}

	public void setMemberFollowing(Integer memberFollowing) {
		this.memberFollowing = memberFollowing;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getProfilePhoto64() {
		return profilePhoto64;
	}

	public void setProfilePhoto64(String profilePhoto64) {
		this.profilePhoto64 = profilePhoto64;
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

	public Timestamp getFollowTime() {
		return followTime;
	}

	public void setFollowTime(Timestamp followTime) {
		this.followTime = followTime;
	}

}
