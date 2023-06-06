package web.manage.courseapply.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.course.course.bean.Course;
import web.manage.courseapply.bean.Courseapply;
import web.manage.courseapply.dao.ManageDao;

public class ManageDaoImpl implements ManageDao {

	@Override
	public int insert(Courseapply courseapply) {
		final String SQL ="insert into MANAGE_COURSE_APPLY(COURSE_APPLY_ID, COURSE_ID, MANAGE_ID, MEMBER_NO, "
                + "CLASS_APPLY_TIME, MANAGE_PTIME, CLASS_CHECK, CLASS_RESULT) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?)";
		try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
		) {
            pstmt.setInt(1, courseapply.getCourseApplyId());
            pstmt.setInt(2, courseapply.getCourseId());
            pstmt.setInt(3, courseapply.getManageId());
            pstmt.setInt(4, courseapply.getMemberNo());
            pstmt.setTimestamp(5, courseapply.getClassApplyTime());
            pstmt.setTimestamp(6, courseapply.getManagePtime());
            pstmt.setBoolean(7, courseapply.getClassCheck());
            pstmt.setBoolean(8, courseapply.getClassResult());
           return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
	}

	@Override
	public int update(Courseapply courseapply) {
		final String SQL ="update MANAGE_COURSE_APPLY set "
                		+ "MANAGE_PTIME = ?, "
                		+ "CLASS_CHECK = ? "
                		+ "where COURSE_APPLY_ID = ?";
		try (
				    Connection conn = getConnection();
				    PreparedStatement pstmt = conn.prepareStatement(SQL)
			 ) {
				
			 	pstmt.setInt(1, courseapply.getCourseApplyId());
	            pstmt.setTimestamp(2, courseapply.getManagePtime());
	            pstmt.setBoolean(3, courseapply.getClassCheck());
	            pstmt.setInt(4, courseapply.getCourseApplyId());
	            
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return 0;
	}
//	public List<Courseapply> selectAllByKey(Boolean check) {
//	    final String SQL = "SELECT C.COURSE_NAME, C.SUMMARY, C.IMAGE, CR.MANAGE_ID, CR.MEMBER_NO, CR.MANAGE_REASON, CR.MANAGE_RTIME, CR.MANAGE_PTIME, CR.MANAGE_RESULT\r\n"
//	    		+ "FROM COURSE C\r\n"
//	    		+ "LEFT JOIN COURSE_REPORT CR ON C.COURSE_ID = CR.COURSE_ID\r\n"
//	    		+ "WHERE C.COURSE_ID = CR.COURSE_ID";
	
	

	@Override
	public List<Courseapply> selectAllByKey(Integer id) {
	    final String SQL = "Select * from MANAGE_COURSE_APPLY where COURSE_APPLY_ID = ?";
	    List<Courseapply> resultList = new ArrayList<>();
	    try (
	        Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(SQL);
	    ) {
	        pstmt.setInt(1, id);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                Courseapply courseapply = new Courseapply();
	                courseapply.setCourseApplyId(rs.getInt("COURSE_APPLY_ID"));
	                courseapply.setCourseId(rs.getInt("COURSE_ID"));
	                courseapply.setClassApplyTime(rs.getTimestamp("CLASS_APPLY_TIME"));
	                courseapply.setClassCheck(rs.getBoolean("CLASS_CHECK"));
	                resultList.add(courseapply);
	            }
	            return resultList;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	@Override
	public Courseapply selectByKey(Integer id) {
		final String SQL = "select * from MANAGE_COURSE_APPLY where COURSE_APPLY_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Courseapply courseapply = new Courseapply();
					courseapply.setCourseApplyId(rs.getInt("COURSE_APPLY_ID"));
					courseapply.setCourseId(rs.getInt("COURSE_ID"));
					courseapply.setManageId(rs.getInt("MANAGE_ID"));
					courseapply.setMemberNo(rs.getInt("MEMBER_NO"));
					courseapply.setClassApplyTime(rs.getTimestamp("CLASS_APPLY_TIME"));
					courseapply.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
					courseapply.setClassCheck(rs.getBoolean("CLASS_CHECK"));
					courseapply.setClassResult(rs.getBoolean("CLASS_RESULT"));
					return courseapply;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	SELECT MC.COURSE_APPLY_ID, MC.COURSE_ID, MC.MANAGE_ID, MC.MEMBER_NO, MC.CLASS_APPLY_TIME,
//	MC.MANAGE_PTIME, MC.CLASS_CHECK, MC.CLASS_RESULT,
//	C.COURSE_NAME, C.SUMMARY, C.ADD_AND_REMOVE, C.COURSES_REPORT, C.UPDATETIME,
//	CH.CHAPTER_ID, CH.CHAPTER_NAME, CH.VIDEO, CH.UPDATETIME as CHAPTER_UPDATETIME
//	FROM MANAGE_COURSE_APPLY MC
//	INNER JOIN COURSE C ON MC.COURSE_ID = C.COURSE_ID
//    INNER JOIN CHAPTER CH ON C.COURSE_ID = CH.COURSE_ID
	public List<Courseapply> selectAll() {
		final String SQL = "	SELECT MC.COURSE_APPLY_ID, MC.COURSE_ID, MC.MANAGE_ID, MC.MEMBER_NO, MC.CLASS_APPLY_TIME,\r\n"
				+ "	MC.MANAGE_PTIME, MC.CLASS_CHECK, MC.CLASS_RESULT,\r\n"
				+ "	C.COURSE_NAME, C.SUMMARY, C.ADD_AND_REMOVE, C.COURSES_REPORT, C.UPDATETIME,\r\n"
				+ "	CH.CHAPTER_ID, CH.CHAPTER_NAME, CH.VIDEO, CH.UPDATETIME as CHAPTER_UPDATETIME\r\n"
				+ "	FROM MANAGE_COURSE_APPLY MC\r\n"
				+ "	INNER JOIN COURSE C ON MC.COURSE_ID = C.COURSE_ID\r\n"
				+ "    INNER JOIN CHAPTER CH ON C.COURSE_ID = CH.COURSE_ID";
		List<Courseapply> resultList = new ArrayList<>();
		try (
				 Connection conn = getConnection();
			    PreparedStatement pstmt = conn.prepareStatement(SQL);
			    ResultSet rs = pstmt.executeQuery();
			) {
			{
			while (rs.next()) {
				Courseapply courseapply = new Courseapply();
				courseapply.setCourseApplyId(rs.getInt("COURSE_APPLY_ID"));
				courseapply.setCourseId(rs.getInt("COURSE_ID"));
				courseapply.setCourseName(rs.getString("COURSE_ID"));
				courseapply.setManageId(rs.getInt("MANAGE_ID"));
				courseapply.setMemberNo(rs.getInt("MEMBER_NO"));
				courseapply.setClassApplyTime(rs.getTimestamp("CLASS_APPLY_TIME"));
				courseapply.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
				courseapply.setClassCheck(rs.getBoolean("CLASS_CHECK"));
				courseapply.setClassResult(rs.getBoolean("CLASS_RESULT"));
				courseapply.setSummary(rs.getString("SUMMARY"));
				courseapply.setAddAndRemove(rs.getBoolean("ADD_AND_REMOVE"));
				courseapply.setCoursesReport(rs.getBoolean("COURSES_REPORT"));
				courseapply.setUpDateTime(rs.getTimestamp("UPDATETIME"));
				courseapply.setChapterId(rs.getInt("CHAPTER_ID"));
				courseapply.setChapterName(rs.getString("CHAPTER_NAME"));
				courseapply.setVideo(rs.getBytes("VIDEO"));
				courseapply.setChapterUpDateTime(rs.getTimestamp("CHAPTER_UPDATETIME"));
				
				
				
				resultList.add(courseapply);
			}
			return resultList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public int deleteByKey(Integer id) {
		final String SQL = "delete from MANAGE_COURSE_APPLY where COURSE_APPLY_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
} 
	
