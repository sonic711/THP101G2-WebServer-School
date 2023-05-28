package web.calendar.schedule.bean;

import java.sql.Timestamp;

public class Reminder {
	private Integer reminderId;
	private String reminderType;
	private Timestamp createAt;
	
	@Override
	public String toString() {
		return "Reminder [reminderId=" + reminderId + ", reminderType=" + reminderType + ", createAt=" + createAt + "]";
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
