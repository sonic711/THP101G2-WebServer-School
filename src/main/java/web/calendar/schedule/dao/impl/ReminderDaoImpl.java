package web.calendar.schedule.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.calendar.schedule.bean.Reminder;
import web.calendar.schedule.dao.ReminderDao;

public class ReminderDaoImpl implements ReminderDao{

	@Override
	public Reminder selectReminder(Integer reminderId) {
		String sql = "select * from CALENDAR_REMINDER where REMINDER_ID = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setInt(1, reminderId);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					Reminder reminder = new Reminder();
					reminder.setReminderId(rs.getInt("RIMINDER_ID"));;
					reminder.setReminderType(rs.getString("REMINDER_TYPE"));
					reminder.setCreateAt(rs.getTimestamp("CREATE_AT"));
					return reminder;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
