package web.calendar.schedule.service;

import java.sql.Date;
import java.util.List;

import web.calendar.schedule.bean.Schedule;

public interface ScheduleService {

	boolean add(Schedule schedule);
	
	boolean edit(Schedule schedule);
	
	boolean delete(Schedule schedule);
	
	List<Schedule> memberScheduleOnDate(Integer memberNo, Date date);
	
	List<Schedule> findAll();
	
	Schedule singleSchedule(Schedule schedule);
}
