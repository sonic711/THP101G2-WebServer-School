package web.calendar.schedule.service;

import java.util.List;

import web.calendar.schedule.bean.Schedule;

public interface ScheduleService {

	boolean add(Schedule schedule);
	
	boolean edit(Schedule schedule);
	
	boolean delete(Schedule schedule);
	
	List<Schedule> findAllByMemberNo(Integer memberNo);
	
	List<Schedule> findAll();
}
