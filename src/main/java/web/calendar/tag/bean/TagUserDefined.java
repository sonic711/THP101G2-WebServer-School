package web.calendar.tag.bean;

import java.sql.Timestamp;

public class TagUserDefined {
	private Integer tagUserDefinedId;
	private Integer memberNo;
	private Integer tagId;
	private String definedColname;
	private Timestamp createAt;
	
	@Override
	public String toString() {
		return "TagUserDefined [tagUserDefinedId=" + tagUserDefinedId + ", memberNo=" + memberNo + ", tagId=" + tagId
				+ ", definedColname=" + definedColname + ", createAt=" + createAt + "]";
	}

	public Integer getTagUserDefinedId() {
		return tagUserDefinedId;
	}

	public void setTagUserDefinedId(Integer tagUserDefinedId) {
		this.tagUserDefinedId = tagUserDefinedId;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getDefinedColname() {
		return definedColname;
	}

	public void setDefinedColname(String definedColname) {
		this.definedColname = definedColname;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
}
