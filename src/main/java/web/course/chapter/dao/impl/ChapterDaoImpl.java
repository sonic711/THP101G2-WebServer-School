package web.course.chapter.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.course.chapter.bean.Chapter;
import web.course.chapter.dao.ChapterDao;

public class ChapterDaoImpl implements ChapterDao{

	@Override
	public int insert(Chapter chapter) {
		final String SQL = "insert into CHAPTER(CHAPTER_NAME, COURSE_ID, VIDEO, CHAPTER_SEQUENCE) "
				+ "values(?, ?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setString(1, chapter.getChapterName());
			pstmt.setInt(2, chapter.getCourseId());
			pstmt.setString(3, chapter.getVideo());
			pstmt.setInt(4, chapter.getChapterSequence());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(Chapter chapter) {
		final String SQL = "UPDATE CHAPTER SET "
		        + "CHAPTER_NAME = ?, "
		        + "VIDEO = ?, "
		        + "CHAPTER_SEQUENCE = ? "
		        + "WHERE CHAPTER_ID = ?";
	    try (
	            Connection conn = getConnection(); 
	            PreparedStatement pstmt = conn.prepareStatement(SQL)
	        ){
	        pstmt.setString(1, chapter.getChapterName());
	        pstmt.setString(2, chapter.getVideo());
	        pstmt.setInt(3, chapter.getChapterSequence());
	        pstmt.setInt(4, chapter.getChapterId());
	        return pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}

	@Override
	public List<Chapter> selectAllByKey(Integer id) {
		final String SQL = "select * CHAPTER where CHAPTER_ID = ?";
		List<Chapter> resultlist = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Chapter chapter = new Chapter();
					chapter.setChapterId(rs.getInt("CHAPTER_ID"));
					chapter.setChapterName(rs.getString("CHAPTER_NAME"));
					chapter.setCourseId(rs.getInt("COURSE_ID"));
					chapter.setVideo(rs.getString("VIDEO"));
					chapter.setChapterSequence(rs.getInt("CHAPTER_SEQUENCE"));
					resultlist.add(chapter);
                }
            }
            return resultlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Chapter> selectAll() {
		final String SQL = "SELECT c.*, o.COURSE_NAME\r\n" + "FROM CHAPTER c\r\n"
				+ "JOIN COURSE o ON c.COURSE_ID = o.COURSE_ID\r\n;";
		List<Chapter> resultList = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Chapter chapter = new Chapter();
				chapter.setCourseName(rs.getString("COURSE_NAME"));
				chapter.setChapterId(rs.getInt("CHAPTER_ID"));
				chapter.setChapterName(rs.getString("CHAPTER_NAME"));
				chapter.setCourseId(rs.getInt("COURSE_ID"));
				chapter.setVideo(rs.getString("VIDEO"));
				chapter.setChapterSequence(rs.getInt("CHAPTER_SEQUENCE"));
				chapter.setUpdateTime(rs.getTimestamp("UPDATETIME"));
				resultList.add(chapter);
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Chapter selectByKey(Integer id) {
		final String SQL = "select * from CHAPTER where CHAPTER_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Chapter chapter = new Chapter();
					chapter.setChapterId(rs.getInt("CHAPTER_ID"));
					chapter.setChapterName(rs.getString("CHAPTER_NAME"));
					chapter.setCourseId(rs.getInt("COURSE_ID"));
					chapter.setVideo(rs.getString("VIDEO"));
					chapter.setChapterSequence(rs.getInt("CHAPTER_SEQUENCE"));
					return chapter;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteByKey(Integer id) {
		final String SQL = "delete from CHAPTER where CHAPTER_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
 