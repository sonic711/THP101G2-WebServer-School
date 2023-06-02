package web.member.follow.bean;

import java.sql.Timestamp;

public class Follow {
	private Integer memberFollowingId;
	private Integer memberNo;
	private Integer memberFollowing;
	private Timestamp followTime;
	private Timestamp createAt;

	@Override
	public String toString() {
		return "Follow [memberFollowingId=" + memberFollowingId + ", memberNo=" + memberNo + ", memberFollowing="
				+ memberFollowing + ", followTime=" + followTime + ", createAt=" + createAt + "]";
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

	public Timestamp getFollowTime() {
		return followTime;
	}

	public void setFollowTime(Timestamp followTime) {
		this.followTime = followTime;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

}
