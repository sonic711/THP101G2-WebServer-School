package web.course.course.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.community.post.bean.Post;
import web.course.course.bean.Course;
import web.course.course.dao.CourseDao;

public class CourseDaoImpl implements CourseDao {

	@Override
	public int insert(Course course) {
		final String SQL = "insert into COURSE(COURSE_ID, COURSE_NAME, MEMBER_NO, SUMMARY, ADD_AND_REMOVE, COURSE_REPORT, IMAGE) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, course.getCourseId());
			pstmt.setString(2, course.getCourseName());
			pstmt.setInt(3, course.getMemberNo());
			pstmt.setString(4, course.getSummary());
			pstmt.setBoolean(5, course.getAddAndRemove());
			pstmt.setBoolean(6, course.getCoursesReport());
			pstmt.setBytes(7, course.getImage());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Course> selectAllByKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> selectAll() {
        final String SQL = "SELECT c.*, m.USER_ID, co.RATING\r\n"
        		+ "FROM COURSE c\r\n"
        		+ "JOIN MEMBER m ON c.MEMBER_NO = m.MEMBER_NO\r\n"
        		+ "JOIN COMMENT co ON c.MEMBER_NO = co.MEMBER_NO;";
        List<Course> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery()
        ) {
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
                course.setRating(rs.getInt("RATING"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
