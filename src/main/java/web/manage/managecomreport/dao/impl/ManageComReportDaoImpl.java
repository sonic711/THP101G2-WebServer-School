package web.manage.managecomreport.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import web.course.course.bean.Course;
import web.manage.managecomreport.bean.Managecomreport;
import web.manage.managecomreport.dao.ManageComReportDao;

public class ManageComReportDaoImpl implements ManageComReportDao {
	public int insert(Managecomreport managecomreport) {
		
        final String SQL = "insert into MANAGE_COM_REPORT(MANAGE_COM_REPORT, MANAGE_ID, COM_POST_ID,"
        		+ " MEMBER_NO, MANAGE_REASON, MANAGE_RTIME, MANAGE_PTIME, MANAGE_RESULT) "
                           + "values(?, ?, ?, ?, ?, ? ,? ,?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
        	 pstmt.setInt(1, managecomreport.getManageComReportId());
             pstmt.setInt(2, managecomreport.getManageId());
             pstmt.setInt(3, managecomreport.getComPostId());
             pstmt.setInt(4, managecomreport.getMemberNo());
             pstmt.setString(5, managecomreport.getManageReason());
             pstmt.setTimestamp(6, managecomreport.getManageRtime());
             pstmt.setTimestamp(7, managecomreport.getManagePtime());
             pstmt.setBoolean(8, managecomreport.getManageResult());
             
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
	
	public int update(Managecomreport managecomreport) {
        final String SQL = "update MANAGE_COM_REPORT set "
                           + "MANAGE_PTIME = ? ,MANAGE_RESULT = ?"
                           + "where MANAGE_COM_REPORT = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setTimestamp(1, managecomreport.getManagePtime());
            pstmt.setBoolean(2, managecomreport.getManageResult());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
	public List<Managecomreport> selectAllByKey(Integer id) {
        final String SQL = "select * from MANAGE_COM_REPORT where COM_POST_ID = ?";
        List<Managecomreport> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	Managecomreport managecomreport = new Managecomreport();
                	managecomreport.setManageComReportId(rs.getInt("MANAGE_COM_REPORT"));
                	managecomreport.setManageId(rs.getInt("MANAGE_ID"));
                	managecomreport.setComPostId(rs.getInt("COM_POST_ID"));
                	managecomreport.setMemberNo(rs.getInt("MEMBER_NO"));
                	managecomreport.setManageReason(rs.getString("MANAGE_REASON"));
                	managecomreport.setManageRtime(rs.getTimestamp("MANAGE_RTIME"));
                	managecomreport.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
                	managecomreport.setManageResult(rs.getBoolean("MANAGE_RESULT"));

                    resultList.add(managecomreport);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@Override
	public List<Managecomreport> selectAll() {
		final String SQL = "SELECT MCR.*, CP.*, CR.*\r\n"
				+ "FROM MANAGE_COM_REPORT MCR\r\n"
				+ "JOIN COM_POST CP ON MCR.COM_POST_ID = CP.COM_POST_ID\r\n"
				+ "JOIN COM_REPLY CR ON CP.COM_POST_ID = CR.COM_REPLY_TO;";
		List<Managecomreport> resultList = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Managecomreport managecomreport = new Managecomreport();
            	managecomreport.setManageComReportId(rs.getInt("MANAGE_COM_REPORT"));
            	managecomreport.setManageId(rs.getInt("MANAGE_ID"));
            	managecomreport.setComPostId(rs.getInt("COM_POST_ID"));
            	managecomreport.setMemberNo(rs.getInt("MEMBER_NO"));
            	managecomreport.setManageReason(rs.getString("MANAGE_REASON"));
            	managecomreport.setManageRtime(rs.getTimestamp("MANAGE_RTIME"));
            	managecomreport.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
            	managecomreport.setManageResult(rs.getBoolean("MANAGE_RESULT"));
            	managecomreport.setComReplyId(rs.getInt("COM_REPLY_ID"));
            	managecomreport.setComReplyTo(rs.getInt("COM_REPLY_TO"));
            	managecomreport.setComReplyContent(rs.getString("COM_REPLY_CONTENT"));
            	managecomreport.setComReplyTime(rs.getTimestamp("COM_REPLY_TIME"));
            	managecomreport.setComReplyAccessSetting(rs.getBoolean("COM_REPLY_ACCESS_SETTING"));
            	managecomreport.setComPostTitle(rs.getString("COM_POST_TITLE"));
            	managecomreport.setComPostContent(rs.getString("COM_POST_CONTENT"));
            	managecomreport.setComPostTime(rs.getTimestamp("COM_POST_TIME"));
            	managecomreport.setComPostStates(rs.getBoolean("COM_POST_STATUS"));
            	managecomreport.setComPostAccessSetting(rs.getBoolean("COM_POST_ACCESS_SETTING"));
            	
         
				resultList.add(managecomreport);
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Managecomreport selectByKey(Integer id) {
		final String SQL = "select * from MANAGE_COM_REPORT where COM_POST_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Managecomreport managecomreport = new Managecomreport();
					managecomreport.setManageComReportId(rs.getInt("MANAGE_COM_REPORT"));
                	managecomreport.setManageId(rs.getInt("MANAGE_ID"));
                	managecomreport.setComPostId(rs.getInt("COM_POST_ID"));
                	managecomreport.setMemberNo(rs.getInt("MEMBER_NO"));
                	managecomreport.setManageReason(rs.getString("MANAGE_REASON"));
                	managecomreport.setManageRtime(rs.getTimestamp("MANAGE_RTIME"));
                	managecomreport.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
                	managecomreport.setManageResult(rs.getBoolean("MANAGE_RESULT"));
					return managecomreport;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteByKey(Integer id) {
		final String SQL = "delete from MANAGE_COM_REPORT where COM_POST_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
