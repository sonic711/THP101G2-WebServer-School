package web.calendar.tag.bean;

import java.sql.Timestamp;

public class TagColor {
	private Integer tagId;
	private String colorHex;
	private String colorName;
	private Timestamp createAt;

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", colorHex=" + colorHex + ", colorName=" + colorName + ", createAt=" + createAt
				+ "]";
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getColorHex() {
		return colorHex;
	}

	public void setColorHex(String colorHex) {
		this.colorHex = colorHex;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

}
