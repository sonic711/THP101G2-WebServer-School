package web.course.favoritecourses.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import web.course.favoritecourses.bean.FavoriteCourses;
import web.course.favoritecourses.dao.FavoriteCoursesDao;

public class FavoriteCoursesDaoImpl implements FavoriteCoursesDao {

	@Override
	public int insert(FavoriteCourses favoritecourses) {
		final String SQL = "insert into FAVORITE_COURSES(COURSE_ID, MEMBER_NO) "
				+ "values(?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, favoritecourses.getCourseId());
			pstmt.setInt(2, favoritecourses.getMemberNo());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<FavoriteCourses> selectAllByKey(Integer id) {
		final String SQL = "select * from FAVORITE_COURSES where FAVORITE_COURSES_ID = ?";
		List<FavoriteCourses> resultList = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					FavoriteCourses favoritecourses = new FavoriteCourses();
					favoritecourses.setFavoriteCoursesId(rs.getInt("FAVORITE_COURSES_ID"));
					favoritecourses.setCourseId(rs.getInt("COURSE_ID"));
					favoritecourses.setMemberNo(rs.getInt("MEMBER_NO"));
					favoritecourses.setFavoriteCourses(rs.getBoolean("FAVORITE_COURSES"));
				      resultList.add(favoritecourses);
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FavoriteCourses> selectAll() {
		final String SQL = "SELECT f.*, m.USER_ID, co.RATING, c.COURSE_ID, c.COURSE_NAME, c.IMAGE " +
				"FROM FAVORITE_COURSES f " +
				"JOIN MEMBER m ON f.MEMBER_NO = m.MEMBER_NO " +
				"JOIN COMMENT co ON f.MEMBER_NO = co.MEMBER_NO " +
				"JOIN COURSE c ON f.COURSE_ID = c.COURSE_ID";
		List<FavoriteCourses> resultList = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery()
			){
			while (rs.next()) {
				FavoriteCourses favoriteCourses = new FavoriteCourses();
				favoriteCourses.setFavoriteCoursesId(rs.getInt("FAVORITE_COURSES_ID"));
				favoriteCourses.setUserId(rs.getString("USER_ID"));
				favoriteCourses.setCourseName(rs.getString("COURSE_NAME"));
				favoriteCourses.setCourseId(rs.getInt("COURSE_ID"));
				favoriteCourses.setMemberNo(rs.getInt("MEMBER_NO"));
				favoriteCourses.setFavoriteCourses(rs.getBoolean("FAVORITE_COURSES"));
				favoriteCourses.setImage(rs.getBytes("IMAGE"));
				favoriteCourses.setUpdateTime(rs.getTimestamp("UPDATETIME"));
				resultList.add(favoriteCourses);
		}			
			return resultList;
		}catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}

	@Override
	public FavoriteCourses selectByKey(Integer id) {
		final String SQL = "select * from FAVORITE_COURSES where FAVORITE_COURSES_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					FavoriteCourses favoritecourses = new FavoriteCourses();
					favoritecourses.setFavoriteCoursesId(rs.getInt("FAVORITE_COURSES_ID"));
					favoritecourses.setCourseId(rs.getInt("COURSE_ID"));
					favoritecourses.setMemberNo(rs.getInt("MEMBER_NO"));
					favoritecourses.setFavoriteCourses(rs.getBoolean("FAVORITE_COURSES"));
					return favoritecourses;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteByKey(Integer id) {
		final String SQL = "delete from FAVORITE_COURSES where FAVORITE_COURSES_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(FavoriteCourses favoriteCourses) {
		final String SQL = "update FAVORITE_COURSES set "
							+ "FAVORITE_COURSES = ? "
							+ "where FAVORITE_COURSES_ID = ?";
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL)
				){
					pstmt.setBoolean(1, favoriteCourses.getFavoriteCourses());
					pstmt.setInt(2, favoriteCourses.getFavoriteCoursesId());
					return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
