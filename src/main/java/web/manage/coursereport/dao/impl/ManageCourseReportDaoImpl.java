package web.manage.coursereport.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.course.course.bean.Course;
import web.manage.coursereport.bean.Coursereport;
import web.manage.coursereport.dao.ManageCourseReportDao;

public class ManageCourseReportDaoImpl implements ManageCourseReportDao{
	
	@Override
	public int insert(Coursereport coursereport) {
		final String SQL ="insert into COURSE_REPORT(COURSE_REPORT_ID, MANAGE_ID, COURSE_ID, MEMBER_NO,\" + \" MANAGE_REASON, MANAGE_RTIME, MANAGE_PTIME, MANAGE_RESULT)\" + \" values(?, ?, ?, ?, ?, ?, ?, ?)";
		try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
		) {
            pstmt.setInt(1, coursereport.getCourseReportId());
            pstmt.setInt(2, coursereport.getManageId());
            pstmt.setInt(3, coursereport.getCourseId());
            pstmt.setInt(4, coursereport.getMemberNo());
            pstmt.setString(5, coursereport.getManageReason());
            pstmt.setTimestamp(6, coursereport.getManageRtime());
            pstmt.setTimestamp(7, coursereport.getManagePtime());
            pstmt.setBoolean(8, coursereport.getManageResult());
            
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
	}
	@Override
	public List<Coursereport> selectAllByKey(Integer id) {
		final String SQL = "select * from COURSE_REPORT where COURSE_REPORT_ID = ?";
		List<Coursereport> resultList = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Coursereport coursereport = new Coursereport();
                	coursereport.setCourseReportId(rs.getInt("COURSE_REPORT_ID"));
                	coursereport.setCourseId(rs.getInt("COURSE_ID"));
                	coursereport.setManageId(rs.getInt("MANAGE_ID"));
                	coursereport.setMemberNo(rs.getInt("MEMBER_NO"));
                	coursereport.setManageReason(rs.getString("MANAGE_REASON"));
                	coursereport.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
                	coursereport.setManageRtime(rs.getTimestamp("MANAGE_RTIME"));
                	coursereport.setManageResult(rs.getBoolean("MANAGE_RESULT"));
				    resultList.add(coursereport);
                }
            }
            return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	 public List<Coursereport> selectAll() {
	        final String SQL = "SELECT CR.*, C.COURSE_NAME, C.SUMMARY, C.ADD_AND_REMOVE, CH.VIDEO\r\n"
	        		+ "FROM COURSE_REPORT CR\r\n"
	        		+ "INNER JOIN COURSE C ON CR.COURSE_ID = C.COURSE_ID\r\n"
	        		+ "INNER JOIN CHAPTER CH ON CR.COURSE_ID = CH.COURSE_ID";
	        List<Coursereport> resultList = new ArrayList<>();
			try (Connection conn = getConnection();
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
	                	Coursereport coursereport = new Coursereport();
	                	coursereport.setCourseReportId(rs.getInt("COURSE_REPORT_ID"));
	                	coursereport.setManageId(rs.getInt("MANAGE_ID"));
	                	coursereport.setCourseId(rs.getInt("COURSE_ID"));
	                	coursereport.setMemberNo(rs.getInt("MEMBER_NO"));
	                	coursereport.setManageReason(rs.getString("MANAGE_REASON"));
	                	coursereport.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
	                	coursereport.setManageRtime(rs.getTimestamp("MANAGE_RTIME"));
	                	coursereport.setManageResult(rs.getBoolean("MANAGE_RESULT"));
	                	coursereport.setCourseName(rs.getString("COURSE_NAME"));
	                	coursereport.setSummary(rs.getString("SUMMARY"));
	                	coursereport.setVideo(rs.getBytes("VIDEO"));
	                	coursereport.setAddAndRemove(rs.getBoolean("ADD_AND_REMOVE"));
	                	

	                    resultList.add(coursereport);
	                }
	    			return resultList;
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    		return null;
	    	}
	
	
	
	
	 @Override
		public Coursereport selectByKey(Integer id) {
		 final String SQL = "select * from COURSE_REPORT where COURSE_REPORT_ID = ?";
			try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
				pstmt.setInt(1, id);
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						Coursereport coursereport = new Coursereport();
	                	coursereport.setCourseReportId(rs.getInt("COURSE_REPORT_ID"));
	                	coursereport.setCourseId(rs.getInt("COURSE_ID"));
	                	coursereport.setManageId(rs.getInt("MANAGE_ID"));
	                	coursereport.setMemberNo(rs.getInt("MEMBER_NO"));
	                	coursereport.setManageReason(rs.getString("MANAGE_REASON"));
	                	coursereport.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
	                	coursereport.setManageRtime(rs.getTimestamp("MANAGE_RTIME"));
	                	coursereport.setManageResult(rs.getBoolean("MANAGE_RESULT"));
						return coursereport;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	 
	 @Override
		public int deleteByKey(Integer id) {
		 final String SQL = "delete from COURSE_REPORT where COURSE_REPORT_ID = ?";
			try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
				pstmt.setInt(1, id);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}

	

	 @Override
	 public int update(Coursereport coursereport) {
	        final String SQL = "update COURSE_REPORT set "
	                         + "MANAGE_PTIME = ?, MANAGE_RESULT = ? "
	                           + "where COURSE_REPORT_ID = ?";
	        try (
	                Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(SQL)
	        ) {
	            pstmt.setTimestamp(1, coursereport.getManagePtime());
	            pstmt.setBoolean(2, coursereport.getManageResult());
	            pstmt.setInt(3, coursereport.getCourseReportId());

	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -1;
	    }
}
	