package web.calendar.schedule.bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Schedule {
	private Integer scheduleId;
	private Integer memberNo;
	private String task;
	private Integer tagUserDefId;
	private Date date;
	private Time startTime;
	private Time endTime;
	private Integer repeatPattern;
	private Integer reminder;
	private Timestamp createAt;
	
	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", memberNo=" + memberNo + ", task=" + task + ", tagUserDefId="
				+ tagUserDefId + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", repeatPattern=" + repeatPattern + ", reminder=" + reminder + ", createAt=" + createAt + "]";
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
	public Integer getRepeatPattern() {
		return repeatPattern;
	}
	public void setRepeatPattern(Integer repeatPattern) {
		this.repeatPattern = repeatPattern;
	}
	public Integer getReminder() {
		return reminder;
	}
	public void setReminder(Integer reminder) {
		this.reminder = reminder;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
	
}
