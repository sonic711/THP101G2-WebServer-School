package web.calendar.schedule.bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class MemSchedule {
	private Integer scheduleId;
	private Integer memberNo;
	private String task;
	private Integer tagUserDefId;
	private Integer tagId;
	private String colorHex;
	private String tagName;
	private Date date;
	private Time startTime;
	private Time endTime;
	private Integer repeatId;
	private String repeatPattern;
	private Integer reminderId;
	private String reminderType;
	private Timestamp createAt;

	@Override
	public String toString() {
		return "MemSchedule [scheduleId=" + scheduleId + ", memberNo=" + memberNo + ", task=" + task + ", tagUserDefId="
				+ tagUserDefId + ", tagId=" + tagId + ", colorHex=" + colorHex + ", tagName=" + tagName + ", date="
				+ date + ", startTime=" + startTime + ", endTime=" + endTime + ", repeatId=" + repeatId
				+ ", repeatPattern=" + repeatPattern + ", reminderId=" + reminderId + ", reminderType=" + reminderType
				+ ", createAt=" + createAt + "]";
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Integer getTagUserDefId() {
		return tagUserDefId;
	}

	public void setTagUserDefId(Integer tagUserDefId) {
		this.tagUserDefId = tagUserDefId;
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

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
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

	public Integer getReminderId() {
		return reminderId;
	}

	public void setReminderId(Integer reminderId) {
		this.reminderId = reminderId;
	}

	public String getReminderType() {
		return reminderType;
	}

	public void setReminderType(String reminderType) {
		this.reminderType = reminderType;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

}
