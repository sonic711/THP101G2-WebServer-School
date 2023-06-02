package web.point.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import static core.util.CommonUtil.*;

import web.member.member.bean.Member;
import web.point.bean.PointChanged;
import web.point.dao.pointChangedDao;

public class pointChangedDaoImpl implements pointChangedDao {


	

	@Override
	public int insert(PointChanged pointchanged) {
	
		
		// 搞交易控制
		// 寫3個sql(提取MEMBER_NO、insert一筆、update一筆)
//		String sql1 = "";
		
		
		String sql2 = "insert into "
				+ "POINTS_CHANGED(MEMBER_NO,COMMENT_ID,SHOP_ORDER_ID,STUDENT_COURSES_ID,LOGIN_RECORD_ID,VALUE_OF_CHANGING) values(?,?,?,?,?,?)";
		
		String sql3 = "update MEMBER set REWARD_POINTS = REWARD_POINTS + ? where MEMBER_NO = ? ";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				PreparedStatement pstmt3 = conn.prepareStatement(sql3);
				
				
				){
			conn.setAutoCommit(false);
			try {
				pstmt2.setObject(1,pointchanged.getMemberNo());
				pstmt2.setObject(2,pointchanged.getCommentId());
				pstmt2.setObject(3,pointchanged.getShopOrderId());
				pstmt2.setObject(4,pointchanged.getStudentCoursesId());
				pstmt2.setObject(5,pointchanged.getLoginRecordId());
				pstmt2.setInt(6,pointchanged.getValueOfChanged());
				int rs2 =  pstmt2.executeUpdate();
				if (rs2 < 1) {
					return -2;
				}
				pstmt3.setInt(1,pointchanged.getValueOfChanged());
				pstmt3.setInt(2,pointchanged.getMemberNo());
				int rs3 = pstmt3.executeUpdate();
				if (rs3 < 1) {
					return -3;
				}
				conn.commit();
				return rs3;
			}catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return -7;
	}

	@Override
	public List<PointChanged> selectAll(Integer id) {
		String sql = "SELECT PC.POINTS_CHANGED_ID, PC.MEMBER_NO, PC.COMMENT_ID, PC.SHOP_ORDER_ID, " +
                "PC.STUDENT_COURSES_ID, PC.LOGIN_RECORD_ID, PC.VALUE_OF_CHANGING, " +
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
					PC.setShopOrderId(rs.getInt("SHOP_ORDER_ID"));
					PC.setStudentCoursesId(rs.getInt("STUDENT_COURSES_ID"));
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
