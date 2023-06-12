package web.course.course.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


import web.course.course.bean.Course;
import web.course.course.dao.CourseDao;

public class CourseDaoImpl implements CourseDao {

	@Override
	public int insert(Course course) {
		final String SQL = "insert into COURSE(COURSE_NAME, MEMBER_NO, SUMMARY, ADD_AND_REMOVE, COURSES_REPORT, IMAGE) "
				+ "values(?, ?, ?, ?, ?, ?)";
		try (
				Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(SQL)
			){
			pstmt.setString(1, course.getCourseName());
			pstmt.setInt(2, course.getMemberNo());
			pstmt.setString(3, course.getSummary());
			pstmt.setBoolean(4, course.getAddAndRemove());
			pstmt.setBoolean(5, course.getCoursesReport());
			pstmt.setBytes(6, course.getImage());
		return	pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(Course course) {
		final String SQL = "update COURSE set " 
							+ "COURSE_NAME = ?," 
							+ "SUMMARY = ?,"
							+ "ADD_AND_REMOVE = ?,"  
							+ "IMAGE = ? "
							+ "where COURSE_ID = ?";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL)
			){
			pstmt.setString(1,course.getCourseName());
			pstmt.setString(2,course.getSummary());
			pstmt.setBoolean(3,course.getAddAndRemove());
			pstmt.setBytes(4,course.getImage());
			pstmt.setInt(5, course.getCourseId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Course> selectAllByKey(Integer id) {
		final String SQL = "select * from COURSE where COURSE_ID = ?";
		List<Course> resultList = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Course course = new Course();
					course.setCourseId(rs.getInt("COURSE_ID"));
					course.setCourseName(rs.getString("COURSE_NAME"));
					course.setMemberNo(rs.getInt("MEMBER_NO"));
					course.setSummary(rs.getString("SUMMARY"));
					course.setAddAndRemove(rs.getBoolean("ADD_AND_REMOVE"));
					course.setCoursesReport(rs.getBoolean("COURSES_REPORT"));
					course.setImage(rs.getBytes("IMAGE"));
				    resultList.add(course);
                }
            }
            return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Course> selectAll() {
		final String SQL = "SELECT c.COURSE_ID, c.COURSE_NAME, c.MEMBER_NO, c.SUMMARY, c.ADD_AND_REMOVE, "
			       + "c.COURSES_REPORT, c.UPDATETIME, c.IMAGE, m.USER_ID, MAX(co.RATING) AS RATING "
			       + "FROM db02_school.COURSE c "
			       + "JOIN MEMBER m ON c.MEMBER_NO = m.MEMBER_NO "
			       + "JOIN COMMENT co ON c.MEMBER_NO = co.MEMBER_NO "
			       + "WHERE c.ADD_AND_REMOVE = true "
			       + "GROUP BY c.COURSE_ID, c.COURSE_NAME, c.MEMBER_NO, c.SUMMARY, c.ADD_AND_REMOVE, "
			                + "c.COURSES_REPORT, c.UPDATETIME, c.IMAGE, m.USER_ID; ";

//				"SELECT c.*, m.USER_ID, co.RATING\r\n" + "FROM COURSE c\r\n"
//				+ "JOIN MEMBER m ON c.MEMBER_NO = m.MEMBER_NO\r\n" + "JOIN COMMENT co ON c.MEMBER_NO = co.MEMBER_NO "
//				+ "WHERE c.ADD_AND_REMOVE = true;";
		List<Course> resultList = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt("COURSE_ID"));
				course.setCourseName(rs.getString("COURSE_NAME"));
				course.setMemberNo(rs.getInt("MEMBER_NO"));
				course.setSummary(rs.getString("SUMMARY"));
				course.setAddAndRemove(rs.getBoolean("ADD_AND_REMOVE"));
				course.setCoursesReport(rs.getBoolean("COURSES_REPORT"));
				course.setUpdateTime(rs.getTimestamp("UPDATETIME"));
				course.setImage(rs.getBytes("IMAGE"));
				course.setUserId(rs.getString("USER_ID"));
				if(rs.getObject("RATING") != null) {
	                course.setRating(rs.getString("RATING"));
				}else {
					 course.setRating("");
				}
				resultList.add(course);
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Course selectByKey(Integer id) {
		final String SQL = "select * from COURSE where COURSE_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Course course = new Course();
					course.setCourseId(rs.getInt("COURSE_ID"));
					course.setCourseName(rs.getString("COURSE_NAME"));
					course.setMemberNo(rs.getInt("MEMBER_NO"));
					course.setSummary(rs.getString("SUMMARY"));
					course.setAddAndRemove(rs.getBoolean("ADD_AND_REMOVE"));
					course.setCoursesReport(rs.getBoolean("COURSES_REPORT"));
					course.setImage(rs.getBytes("IMAGE"));
					return course;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteByKey(Integer id) {
		final String SQL = "delete from COURSE where COURSE_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
