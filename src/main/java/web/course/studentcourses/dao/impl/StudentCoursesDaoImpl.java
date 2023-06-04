package web.course.studentcourses.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.course.studentcourses.bean.StudentCourses;
import web.course.studentcourses.dao.StudentCoursesDao;

public class StudentCoursesDaoImpl implements StudentCoursesDao{

	@Override
	public int insert(StudentCourses studentcourses) {
		final String SQL = "insert into STUDENT_COURSES(STUDENT_COURSES_ID, MEMBER_NO, COURSE_ID, COURSES_PROGRESS) "
				+ "values(?, ?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, studentcourses.getStudentCoursesId());
			pstmt.setInt(2, studentcourses.getMemberNo());
			pstmt.setInt(3, studentcourses.getCourseId());
			pstmt.setBoolean(4, studentcourses.getCoursesProgress());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}



	@Override
	public List<StudentCourses> selectAllByKey(Integer id) {
		final String SQL = "select * from STUDENT_COURSES where STUDENT_COURSES_ID = ?";
		List<StudentCourses> resultList = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					StudentCourses studentcourses = new StudentCourses();
					studentcourses.setStudentCoursesId(rs.getInt("STUDENT_COURSES_ID"));
					studentcourses.setMemberNo(rs.getInt("MEMBER_NO"));
					studentcourses.setCourseId(rs.getInt("COURSE_ID"));
					studentcourses.setCoursesProgress(rs.getBoolean("COURSES_PROGRESS"));
					resultList.add(studentcourses);
                }
            }
            return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentCourses> selectAll() {
	    final String SQL = "SELECT s.*, m.USER_ID, co.RATING, c.COURSE_ID, c.COURSE_NAME " +
	            "FROM STUDENT_COURSES s " +
	            "JOIN MEMBER m ON s.MEMBER_NO = m.MEMBER_NO " +
	            "JOIN COMMENT co ON s.MEMBER_NO = co.MEMBER_NO " +
	            "JOIN COURSE c ON s.COURSE_ID = c.COURSE_ID";

	    List<StudentCourses> resultList = new ArrayList<>();
	    try (Connection conn = getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(SQL);
	         ResultSet rs = pstmt.executeQuery()
	    ) {
	        while (rs.next()) {
	            StudentCourses studentCourses = new StudentCourses();
	            studentCourses.setStudentCoursesId(rs.getInt("STUDENT_COURSES_ID"));
	            studentCourses.setUserId(rs.getString("USER_ID"));
	            studentCourses.setCourseName(rs.getString("COURSE_NAME"));
	            studentCourses.setCourseId(rs.getInt("COURSE_ID"));
	            studentCourses.setMemberNo(rs.getInt("MEMBER_NO"));
	            studentCourses.setCoursesProgress(rs.getBoolean("COURSES_PROGRESS"));
	            studentCourses.setUpdateTime(rs.getTimestamp("UPDATETIME"));
	            resultList.add(studentCourses);
	        }

	        return resultList;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	@Override
	public StudentCourses selectByKey(Integer id) {
		final String SQL = "select * from STUDENT_COURSES where STUDENT_COURSES_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					StudentCourses studentcourses = new StudentCourses();
					studentcourses.setStudentCoursesId(rs.getInt("STUDENT_COURSES_ID"));
					studentcourses.setMemberNo(rs.getInt("MEMBER_NO"));
					studentcourses.setCourseId(rs.getInt("COURSE_ID"));
					studentcourses.setCoursesProgress(rs.getBoolean("COURSRS_PROGRESS"));
					return studentcourses;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteByKey(Integer id) {
		final String SQL = "delete from STUDENT_COURSES where STUDENT_COURSES_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}



	@Override
	public int update(StudentCourses studentCourses) {
		final String SQL = "update STUDENT_COURSES set "
							+ "COURSES_PROGRESS = ? "
							+ "where STUDENT_COURSES_ID = ?";
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL)
				) {
					pstmt.setBoolean(1, studentCourses.getCoursesProgress());
					pstmt.setInt(2, studentCourses.getStudentCoursesId());
					return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


}
