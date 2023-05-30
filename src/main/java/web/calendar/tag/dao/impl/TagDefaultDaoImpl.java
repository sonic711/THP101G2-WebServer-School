package web.calendar.tag.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.calendar.tag.dao.TagDefaultDao;

public class TagDefaultDaoImpl implements TagDefaultDao{
	
	@Override
	public int insertAllByMemberNo(Integer memberNo, Integer tagId, String tagColor) {
		String sql = "insert into TAG_USER_DEFINED(MEMBER_NO, TAG_ID, DEFINED_COLNAME) "
				+ "values(?, ?, ?)";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, tagId);
			pstmt.setString(3, tagColor);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public int selectIdAndName(Integer memberNo) {
		String sql = "select TAG_ID, COLOR_NAME from TAG_COLOR";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			int insertCount = 0;
			while (rs.next()) {
				Integer tagId = rs.getInt("TAG_ID");
				String tagColor = rs.getString("COLOR_NAME");
				int result = insertAllByMemberNo(memberNo, tagId, tagColor);
				if(result > 0) {
					insertCount += result;
				}
			}
			return insertCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
