package web.member.block.bean;

import java.sql.Timestamp;

public class Block {
	private Integer memberBlockingId;
	private Integer memberNo;
	private Integer memberBlocking;
	private Timestamp blockTime;
	private Timestamp createAt;
	
	@Override
	public String toString() {
		return "Block [memberBlockingId=" + memberBlockingId + ", memberNo=" + memberNo + ", memberBlocking="
				+ memberBlocking + ", blockTime=" + blockTime + ", createAt=" + createAt + "]";
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
	public Timestamp getBlockTime() {
		return blockTime;
	}
	public void setBlockTime(Timestamp blockTime) {
		this.blockTime = blockTime;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
}
