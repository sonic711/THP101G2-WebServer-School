package web.calendar.schedule.service.impl;

import java.util.List;

import web.calendar.schedule.bean.Schedule;
import web.calendar.schedule.dao.ReminderDao;
import web.calendar.schedule.dao.RepeatPatternDao;
import web.calendar.schedule.dao.ScheduleDao;
import web.calendar.schedule.dao.impl.ReminderDaoImpl;
import web.calendar.schedule.dao.impl.RepeatPatternDaoImpl;
import web.calendar.schedule.dao.impl.ScheduleDaoImpl;
import web.calendar.schedule.service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService{
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
			return false;
		}
		
		// task: 不為空，1-12字元
		String task = schedule.getTask();
		if (task != null 
			&& (task.length() < 1 || task.length() > 12)) {
			return false;
		}
		
		// FIXME 這邊要改，沒有自定義的話要怎麼辦？
		// tag: 不為空，需在
		
		
		// date: 不為空
		
		// startTime: 不為空
		
		// endTime: 不為空
		
		// repeatPattern: 重複類型需再資料庫中存在
		Integer repeatId = schedule.getRepeatPattern();
		if (repeatId != null && repeatDao.selectRepaPattren(repeatId) == null) {
			return false;
		}
		
		// reminder: 提醒類型需再資料庫中存在
		Integer reminderId = schedule.getReminder();
		if (reminderId != null && reminderDao.selectReminder(reminderId) == null) {
			return false;
		}
		return dao.insert(schedule) >= 1;
	}

	@Override
	public boolean edit(Schedule schedule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Schedule schedule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Schedule> findAllByMemberNo(Integer memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
