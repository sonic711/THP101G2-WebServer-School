package web.point.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import static core.util.CommonUtil.*;
import web.point.bean.PointChanged;
import web.point.dao.pointChangedDao;

public class pointChangedDaoImpl implements pointChangedDao {


	

	@Override
	public int insert(PointChanged pointchanged) {
		String sql = "insert into "
				+ "POINTS_CHANGED(MEMBER_NO,COMMENT_ID,ORDER_ID,STUDENT_COURSE_ID,LOGIN_RECORD_ID,VALUE_OF_CHANGING,CREATE_AT) values(?,?,?,?,?,?,now())";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				
				){
			pstmt.setInt(1,pointchanged.getMemberNo());
			pstmt.setInt(2,pointchanged.getCommentId());
			pstmt.setInt(3,pointchanged.getOrderId());
			pstmt.setInt(4,pointchanged.getStudentCourseId());
			pstmt.setInt(5,pointchanged.getValueOfChanged());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return -7;
	}

	@Override
	public List<PointChanged> selectAll(Integer id) {
		String sql = "SELECT PC.POINTS_CHANGED_ID, PC.MEMBER_NO, PC.COMMENT_ID, PC.ORDER_ID, " +
                "PC.STUDENT_COURSE_ID, PC.LOGIN_RECORD_ID, PC.VALUE_OF_CHANGING, " +
                "PC.CREATE_AT, M.REWARD_POINTS " +
                "FROM POINTS_CHANGED PC " +
                "INNER JOIN MEMBER M ON PC.MEMBER_NO = M.MEMBER_NO " +
                "WHERE M.MEMBER_NO = ?";
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, id);
			try(ResultSet rs = pstmt.executeQuery()){
				List<PointChanged> list = new ArrayList<>();
				while (rs.next()) {
					PointChanged PC = new PointChanged();
					PC.setPointChangedId(rs.getInt("POINTS_CHANGED_ID"));
					PC.setMemberNo(rs.getInt("MEMBER_NO"));
					PC.setCommentId(rs.getInt("COMMENT_ID"));
					PC.setOrderId(rs.getInt("ORDER_ID"));
					PC.setStudentCourseId(rs.getInt("STUDENT_COURSE_ID"));
					PC.setLoginRecordId(rs.getInt("LOGIN_RECORD_ID"));
					PC.setValueOfChanged(rs.getInt("VALUE_OF_CHANGING"));
					PC.setCreatAt(rs.getTimestamp("CREATE_AT"));
					PC.setRewardPoints(rs.getInt("REWARD_POINTS"));
					list.add(PC);
				}
				
				return list;
			}
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
