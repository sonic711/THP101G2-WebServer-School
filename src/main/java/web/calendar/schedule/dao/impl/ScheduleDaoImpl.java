package web.calendar.schedule.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import web.calendar.schedule.bean.MemSchedule;
import web.calendar.schedule.bean.Schedule;
import web.calendar.schedule.dao.ScheduleDao;

public class ScheduleDaoImpl implements ScheduleDao{

	@Override
	public List<Schedule> selectAll() {
		String sql = "select * from CALENDAR_SCHEDULE";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			List<Schedule> list = new ArrayList<>();
			while (rs.next()) {
				Schedule schedule = new Schedule();
				schedule.setScheduleId(rs.getInt("SCHEDULE_ID"));
				schedule.setMemberNo(rs.getInt("MEMBER_NO"));
				schedule.setTask(rs.getString("TASK"));
				schedule.setTagUserDefId(rs.getInt("TAG_USER_DEF_ID"));
				schedule.setDate(rs.getDate("DATE"));
				schedule.setStartTime(rs.getTime("START_TIME"));
				schedule.setEndTime(rs.getTime("END_TIME"));
				schedule.setRepeatPattern(rs.getInt("REPEAT_PATTERN"));
				schedule.setReminder(rs.getInt("REMINDER"));
				schedule.setCreateAt(rs.getTimestamp("CREATE_AT"));
				list.add(schedule);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MemSchedule> selectAllByMemberNo(Integer memberNo) {
		String sql = "select s.SCHEDULE_ID, "
				+ "s.MEMBER_NO, "
				+ "s.TASK, "
				+ "s.TAG_USER_DEF_ID, "
				+ "tud.TAG_ID, "
				+ "tc.COLOR_HEX, "
				+ "tud.DEFINED_COLNAME as TAG_NAME, "
				+ "s.DATE, "
				+ "s.START_TIME, "
				+ "s.END_TIME, "
				+ "rp.REPEAT_ID, "
				+ "rp.REPEAT_PATTERN, "
				+ "rm.REMINDER_ID, "
				+ "rm.REMINDER_TYPE, "
				+ "s.CREATE_AT "
				+ "from CALENDAR_SCHEDULE s "
				+ "join TAG_USER_DEFINED tud on s.TAG_USER_DEF_ID = tud.TAG_USER_DEFINED_ID "
				+ "join TAG_COLOR tc on tud.TAG_ID = tc.TAG_ID "
				+ "join CALENDAR_REPEAT_PATTERN rp on s.REPEAT_PATTERN = rp.REPEAT_ID "
				+ "join CALENDAR_REMINDER rm on s.REMINDER = rm.REMINDER_ID "
				+ "where s.MEMBER_NO = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, memberNo);
			try (
				ResultSet rs = pstmt.executeQuery();
			) {
				List<MemSchedule> list = new ArrayList<>();
				while (rs.next()) {
					MemSchedule memSchedule = new MemSchedule();
					memSchedule.setScheduleId(rs.getInt("SCHEDULE_ID"));
					memSchedule.setMemberNo(rs.getInt("MEMBER_NO"));
					memSchedule.setTask(rs.getString("TASK"));
					memSchedule.setTagUserDefId(rs.getInt("TAG_USER_DEF_ID"));
					memSchedule.setTagId(rs.getInt("TAG_ID"));
					memSchedule.setColorHex(rs.getString("COLOR_HEX"));
					memSchedule.setTagName(rs.getString("TAG_NAME"));
					memSchedule.setDate(rs.getDate("DATE"));
					memSchedule.setStartTime(rs.getTime("START_TIME"));
					memSchedule.setEndTime(rs.getTime("END_TIME"));
					memSchedule.setRepeatId(rs.getInt("REPEAT_ID"));
					memSchedule.setRepeatPattern(rs.getString("REPEAT_PATTERN"));
					memSchedule.setReminderId(rs.getInt("REMINDER_ID"));
					memSchedule.setReminderType(rs.getString("REMINDER_TYPE"));
					memSchedule.setCreateAt(rs.getTimestamp("CREATE_AT"));
					list.add(memSchedule);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(Schedule schedule) {
		String sql = "insert into CALENDAR_SCHEDULE(MEMBER_NO, TASK, TAG_USER_DEF_ID, DATE, START_TIME, END_TIME, REPEAT_PATTERN, REMINDER)"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, schedule.getMemberNo());
			pstmt.setString(2, schedule.getTask());
			pstmt.setInt(3, schedule.getTagUserDefId());
			pstmt.setDate(4, schedule.getDate());
			pstmt.setTime(5, schedule.getStartTime());
			pstmt.setTime(6, schedule.getEndTime());
			pstmt.setInt(7, schedule.getRepeatPattern());
			pstmt.setInt(8, schedule.getReminder());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(Schedule schedule) {
		StringBuilder sql = new StringBuilder("update CALENDAR_SCHEDULE set ");
		String task = schedule.getTask();
		Integer tagUserDefId = schedule.getTagUserDefId();
		Date date = schedule.getDate();
		Time startTime = schedule.getStartTime();
		Time endTime = schedule.getEndTime();
		Integer repearPattern = schedule.getRepeatPattern();
		Integer reminder = schedule.getReminder();
		if (task != null && !task.isEmpty()) {
			sql.append("TASK = ?, ");
		}
		if (tagUserDefId != null) {
			sql.append("TAG_USER_DEF_ID = ?, ");
		}
		
		if (date != null) {
			sql.append("DATE = ?, ");
		}
		
		if (startTime != null) {
			sql.append("START_TIME = ?, ");
		}
		
		if (endTime != null) {
			sql.append("END_TIME = ?, ");
		}
		
		if (repearPattern != null) {
			sql.append("REPEAT_PATTERN = ?, ");
		}
		
		if (reminder != null) {
			sql.append("REMINDER = ?, ");
		}
		sql.deleteCharAt(sql.length()-2);
		sql.append(" where SCHEDULE_ID = ?");
		
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			int offset = 0;
			if (task != null && !task.isEmpty()) {
				offset ++;
				pstmt.setString(offset, task);
			}
			
			if (tagUserDefId != null) {
				offset ++;
				pstmt.setInt(offset, tagUserDefId);
			}
			
			if (date != null) {
				offset ++;
				pstmt.setDate(offset, date);
			}
			
			if (startTime != null) {
				offset ++;
				pstmt.setTime(offset, startTime);
			}
			
			if (endTime != null) {
				offset ++;
				pstmt.setTime(offset, endTime);
			}
			
			if (repearPattern != null) {
				offset ++;
				pstmt.setInt(offset, repearPattern);
			}
			
			if (reminder != null) {
				offset ++;
				pstmt.setInt(offset, reminder);
			}
			offset ++;
			pstmt.setInt(offset, schedule.getScheduleId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteById(Integer scheduleId) {
		String sql = "delete from CALENDAR_SCHEDULE where SCHEDULE_ID = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, scheduleId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<MemSchedule> selectAllByMemberNoAndDate(Integer memberNo, Date date) {
		String sql = "select s.SCHEDULE_ID, "
				+ "s.MEMBER_NO, "
				+ "s.TASK, "
				+ "s.TAG_USER_DEF_ID, "
				+ "tud.TAG_ID, "
				+ "tc.COLOR_HEX, "
				+ "tud.DEFINED_COLNAME as TAG_NAME, "
				+ "s.DATE, "
				+ "s.START_TIME, "
				+ "s.END_TIME, "
				+ "rp.REPEAT_ID, "
				+ "rp.REPEAT_PATTERN, "
				+ "rm.REMINDER_ID, "
				+ "rm.REMINDER_TYPE, "
				+ "s.CREATE_AT "
				+ "from CALENDAR_SCHEDULE s "
				+ "join TAG_USER_DEFINED tud on s.TAG_USER_DEF_ID = tud.TAG_USER_DEFINED_ID "
				+ "join TAG_COLOR tc on tud.TAG_ID = tc.TAG_ID "
				+ "join CALENDAR_REPEAT_PATTERN rp on s.REPEAT_PATTERN = rp.REPEAT_ID "
				+ "join CALENDAR_REMINDER rm on s.REMINDER = rm.REMINDER_ID "
				+ "where s.MEMBER_NO = ? and s.DATE = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, memberNo);
			pstmt.setDate(2, date);
			try (
				ResultSet rs = pstmt.executeQuery();
			) {
				List<MemSchedule> list = new ArrayList<>();
				while (rs.next()) {
					MemSchedule memSchedule = new MemSchedule();
					memSchedule.setScheduleId(rs.getInt("SCHEDULE_ID"));
					memSchedule.setMemberNo(rs.getInt("MEMBER_NO"));
					memSchedule.setTask(rs.getString("TASK"));
					memSchedule.setTagUserDefId(rs.getInt("TAG_USER_DEF_ID"));
					memSchedule.setTagId(rs.getInt("TAG_ID"));
					memSchedule.setColorHex(rs.getString("COLOR_HEX"));
					memSchedule.setTagName(rs.getString("TAG_NAME"));
					memSchedule.setDate(rs.getDate("DATE"));
					memSchedule.setStartTime(rs.getTime("START_TIME"));
					memSchedule.setEndTime(rs.getTime("END_TIME"));
					memSchedule.setRepeatId(rs.getInt("REPEAT_ID"));
					memSchedule.setRepeatPattern(rs.getString("REPEAT_PATTERN"));
					memSchedule.setReminderId(rs.getInt("REMINDER_ID"));
					memSchedule.setReminderType(rs.getString("REMINDER_TYPE"));
					memSchedule.setCreateAt(rs.getTimestamp("CREATE_AT"));
					list.add(memSchedule);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemSchedule selectAllById(Integer scheduleId) {
		String sql = "select s.SCHEDULE_ID, "
				+ "s.MEMBER_NO, "
				+ "s.TASK, "
				+ "s.TAG_USER_DEF_ID, "
				+ "tud.TAG_ID, "
				+ "tc.COLOR_HEX, "
				+ "tud.DEFINED_COLNAME as TAG_NAME, "
				+ "s.DATE, "
				+ "s.START_TIME, "
				+ "s.END_TIME, "
				+ "rp.REPEAT_ID, "
				+ "rp.REPEAT_PATTERN, "
				+ "rm.REMINDER_ID, "
				+ "rm.REMINDER_TYPE, "
				+ "s.CREATE_AT "
				+ "from CALENDAR_SCHEDULE s "
				+ "join TAG_USER_DEFINED tud on s.TAG_USER_DEF_ID = tud.TAG_USER_DEFINED_ID "
				+ "join TAG_COLOR tc on tud.TAG_ID = tc.TAG_ID "
				+ "join CALENDAR_REPEAT_PATTERN rp on s.REPEAT_PATTERN = rp.REPEAT_ID "
				+ "join CALENDAR_REMINDER rm on s.REMINDER = rm.REMINDER_ID "
				+ "where s.SCHEDULE_ID = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, scheduleId);
			try (
				ResultSet rs = pstmt.executeQuery();
			) {
				if (rs.next()) {
					MemSchedule memSchedule = new MemSchedule();
					memSchedule.setScheduleId(rs.getInt("SCHEDULE_ID"));
					memSchedule.setMemberNo(rs.getInt("MEMBER_NO"));
					memSchedule.setTask(rs.getString("TASK"));
					memSchedule.setTagUserDefId(rs.getInt("TAG_USER_DEF_ID"));
					memSchedule.setTagId(rs.getInt("TAG_ID"));
					memSchedule.setColorHex(rs.getString("COLOR_HEX"));
					memSchedule.setTagName(rs.getString("TAG_NAME"));
					memSchedule.setDate(rs.getDate("DATE"));
					memSchedule.setStartTime(rs.getTime("START_TIME"));
					memSchedule.setEndTime(rs.getTime("END_TIME"));
					memSchedule.setRepeatId(rs.getInt("REPEAT_ID"));
					memSchedule.setRepeatPattern(rs.getString("REPEAT_PATTERN"));
					memSchedule.setReminderId(rs.getInt("REMINDER_ID"));
					memSchedule.setReminderType(rs.getString("REMINDER_TYPE"));
					memSchedule.setCreateAt(rs.getTimestamp("CREATE_AT"));
					return memSchedule;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
