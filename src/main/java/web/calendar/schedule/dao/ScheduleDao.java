package web.calendar.schedule.dao;

import java.sql.Date;
import java.util.List;

import web.calendar.schedule.bean.MemSchedule;
import web.calendar.schedule.bean.Schedule;

public interface ScheduleDao {
	
	List<Schedule> selectAll(); // 查詢所有會員的所有日程
	
	List<MemSchedule> selectAllByMemberNo(Integer memberNo); // 查詢某會員的所有日程
	
	List<MemSchedule> selectAllByMemberNoAndDate(Integer memberNo, Date date); // 查詢某會員某日的所有日程
	
	MemSchedule selectAllById(Integer scheduleId); // 查詢單筆日程
	
	int insert(Schedule schedule); // 新增一筆日程
	
	int update(Schedule schedule); // 更新一筆日程
	
	int deleteById(Integer scheduleId); // 刪除一筆日程
	
}
