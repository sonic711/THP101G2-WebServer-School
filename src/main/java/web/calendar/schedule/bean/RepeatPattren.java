package web.calendar.schedule.bean;

import java.sql.Timestamp;

public class RepeatPattren {
	private Integer repeatId;
	private String repeatPattern;
	private Timestamp createAt;
	
	@Override
	public String toString() {
		return "RepeatPattren [repeatId=" + repeatId + ", repeatPattern=" + repeatPattern + ", createAt=" + createAt
				+ "]";
	}
	
	public Integer getRepeatId() {
		return repeatId;
	}
	public void setRepeatId(Integer repeatId) {
		this.repeatId = repeatId;
	}
	public String getRepeatPattern() {
		return repeatPattern;
	}
	public void setRepeatPattern(String repeatPattern) {
		this.repeatPattern = repeatPattern;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
}
