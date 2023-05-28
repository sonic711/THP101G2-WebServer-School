package web.calendar.schedule.dao;

import web.calendar.schedule.bean.Reminder;

public interface ReminderDao {
	Reminder selectReminder(Integer reminderId);
}
