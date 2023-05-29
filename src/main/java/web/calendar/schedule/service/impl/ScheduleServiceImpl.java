package web.calendar.schedule.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import web.calendar.schedule.bean.Schedule;
import web.calendar.schedule.dao.ReminderDao;
import web.calendar.schedule.dao.RepeatPatternDao;
import web.calendar.schedule.dao.ScheduleDao;
import web.calendar.schedule.dao.impl.ReminderDaoImpl;
import web.calendar.schedule.dao.impl.RepeatPatternDaoImpl;
import web.calendar.schedule.dao.impl.ScheduleDaoImpl;
import web.calendar.schedule.service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {
	private ScheduleDao dao;
	private ReminderDao reminderDao;
	private RepeatPatternDao repeatDao;

	public ScheduleServiceImpl() {
		dao = new ScheduleDaoImpl();
		reminderDao = new ReminderDaoImpl();
		repeatDao = new RepeatPatternDaoImpl();
	}

	@Override
	public boolean add(Schedule schedule) {
		// memberNo: 不為空
		Integer memberNo = schedule.getMemberNo();
		if (memberNo == null) {
			System.out.println("memberNo");
			return false;
		}

		// task: 不為空，1-12字元
		String task = schedule.getTask();
		if (task != null 
			&& (task.length() < 1 || task.length() > 12)) {
			System.out.println("task");
			return false;
		}

		// tag: 不為空
		Integer tagDefId = schedule.getTagUserDefId();
		if (tagDefId == null) {
			System.out.println("tag");
			return false;
		}

		// date: 不為空
		Date date = schedule.getDate();
		if (date == null) {
			System.out.println("date");
			return false;
		}

		// startTime: 不為空
		Time startTime = schedule.getStartTime();
		if (startTime == null) {
			System.out.println("time1");
			return false;
		}

		// endTime: 不為空
		Time endTime = schedule.getEndTime();
		if (endTime == null) {
			System.out.println("time2");
			return false;
		}

		// repeatPattern: 重複類型需再資料庫中存在
		Integer repeatId = schedule.getRepeatPattern();
		if (repeatId != null 
			&& repeatDao.selectRepaPattren(repeatId) == null) {
			System.out.println("repeat");
			return false;
		}

		// reminder: 提醒類型需再資料庫中存在
		Integer reminderId = schedule.getReminder();
		if (reminderId != null 
			&& reminderDao.selectReminder(reminderId) == null) {
			System.out.println("reminder");
			return false;
		}
		return dao.insert(schedule) >= 1;
	}

	@Override
	public boolean edit(Schedule schedule) {
		// memberNo: 不為空
		Integer memberNo = schedule.getMemberNo();
		if (memberNo == null) {
			return false;
		}

		// task: 不為空，1-12字元
		String task = schedule.getTask();
		if (task != null 
			&& (task.length() < 1 || task.length() > 12)) {
			return false;
		}

		// tag: 不為空
		Integer tagDefId = schedule.getTagUserDefId();
		if (tagDefId == null) {
			return false;
		}

		// date: 不為空
		Date date = schedule.getDate();
		if (date == null) {
			return false;
		}

		// startTime: 不為空
		Time startTime = schedule.getStartTime();
		if (startTime == null) {
			return false;
		}

		// endTime: 不為空
		Time endTime = schedule.getEndTime();
		if (endTime == null) {
			return false;
		}

		// repeatPattern: 重複類型需再資料庫中存在
		Integer repeatId = schedule.getRepeatPattern();
		if (repeatId != null 
			&& repeatDao.selectRepaPattren(repeatId) == null) {
			return false;
		}

		// reminder: 提醒類型需再資料庫中存在
		Integer reminderId = schedule.getReminder();
		if (reminderId != null 
			&& reminderDao.selectReminder(reminderId) == null) {
			return false;
		}
		return dao.update(schedule) >= 1;
	}

	@Override
	public boolean delete(Schedule schedule) {
		Integer scheduleId = schedule.getScheduleId();
		if (scheduleId == null) {
			return false;
		}
		return dao.deleteById(scheduleId) >= 1;
	}

	@Override
	public List<Schedule> memberScheduleOnDate(Integer memberNo, Date date) {
		return dao.selectAllByMemberNoAndDate(memberNo, date);
	}

	@Override
	public List<Schedule> findAll() {
		return dao.selectAll();
	}

	@Override
	public Schedule singleSchedule(Schedule schedule) {
		Integer scheduleId = schedule.getScheduleId();
		if (scheduleId == null) {
			return null;
		}
		return dao.selectAllById(scheduleId);
	}

}
