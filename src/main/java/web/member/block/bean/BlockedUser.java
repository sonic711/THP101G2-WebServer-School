package web.member.block.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class BlockedUser {
	private Integer memberBlockingId;
	private Integer memberNo;
	private Integer memberBlocking;
	private String userId;
	private String nickname;
	private String memberIdentity;
	private byte[] profilePhoto;
	private String profilePhoto64;
	private byte[] coverPicture;
	private String coverPicture64;
	private Integer memberStatus;
	private String introduction;
	private Timestamp blockTime;
	@Override
	public String toString() {
		return "BlockedUser [memberBlockingId=" + memberBlockingId + ", memberNo=" + memberNo + ", memberBlocking="
				+ memberBlocking + ", userId=" + userId + ", nickname=" + nickname + ", memberIdentity="
				+ memberIdentity + ", profilePhoto=" + Arrays.toString(profilePhoto) + ", profilePhoto64="
				+ profilePhoto64 + ", coverPicture=" + Arrays.toString(coverPicture) + ", coverPicture64="
				+ coverPicture64 + ", memberStatus=" + memberStatus + ", introduction=" + introduction + ", blockTime="
				+ blockTime + "]";
	}
	public Integer getMemberBlockingId() {
		return memberBlockingId;
	}
	public void setMemberBlockingId(Integer memberBlockingId) {
		this.memberBlockingId = memberBlockingId;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public Integer getMemberBlocking() {
		return memberBlocking;
	}
	public void setMemberBlocking(Integer memberBlocking) {
		this.memberBlocking = memberBlocking;
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
	public byte[] getCoverPicture() {
		return coverPicture;
	}
	public void setCoverPicture(byte[] coverPicture) {
		this.coverPicture = coverPicture;
	}
	public String getCoverPicture64() {
		return coverPicture64;
	}
	public void setCoverPicture64(String coverPicture64) {
		this.coverPicture64 = coverPicture64;
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
	public Timestamp getBlockTime() {
		return blockTime;
	}
	public void setBlockTime(Timestamp blockTime) {
		this.blockTime = blockTime;
	}
	
	
	
}
