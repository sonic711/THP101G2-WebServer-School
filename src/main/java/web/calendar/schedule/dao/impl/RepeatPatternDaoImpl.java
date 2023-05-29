package web.calendar.schedule.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.calendar.schedule.bean.RepeatPattren;
import web.calendar.schedule.dao.RepeatPatternDao;

public class RepeatPatternDaoImpl implements RepeatPatternDao{

	@Override
	public RepeatPattren selectRepaPattren(Integer repeatId) {
		String sql = "select * from CALENDAR_REPEAT_PATTERN where REPEAT_ID = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setInt(1, repeatId);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					RepeatPattren repeat = new RepeatPattren();
					repeat.setRepeatId(rs.getInt("REPEAT_ID"));;
					repeat.setRepeatPattern(rs.getString("REPEAT_PATTERN"));
					repeat.setCreateAt(rs.getTimestamp("CREATE_AT"));
					return repeat;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
