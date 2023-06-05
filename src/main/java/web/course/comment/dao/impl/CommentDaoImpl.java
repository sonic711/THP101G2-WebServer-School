package web.course.comment.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

import web.course.comment.bean.Comment;
import web.course.comment.dao.CommentDao;

public class CommentDaoImpl implements CommentDao{

	@Override
	public int insert(Comment comment) {
		final String SQL = "insert into COMMENT(COMMENT_ID,  MEMBER_NO, COURSE_ID, RATING, COMMENT, IMAGE, COMMENT_REPORT) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(SQL)
			){
			pstmt.setInt(1, comment.getCommentId());
			pstmt.setInt(2, comment.getMemberNo());
			pstmt.setInt(3, comment.getCourseId());
			pstmt.setInt(4, comment.getRating());
			pstmt.setString(5, comment.getComment());
			pstmt.setBytes(6, comment.getImage());
			pstmt.setBoolean(7, comment.getCommentReport());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(Comment comment) {
	    final String SQL = "update COMMENT set"
	                       + " RATING = ?,"
	                       + " COMMENT = ?,"
	                       + " IMAGE = ?"
	                       + " where COMMENT_ID = ?";
	    try (
	        Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(SQL);
	    ) {
	        pstmt.setInt(1, comment.getRating());
	        pstmt.setString(2, comment.getComment());
	        pstmt.setBytes(3, comment.getImage());
	        pstmt.setInt(4, comment.getCommentId());
	        return pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}

	@Override
	public List<Comment> selectAllByKey(Integer id) {
		final String SQL = "select * from COMMENT where COMMENT_ID = ?";
		List<Comment> resultlist = new ArrayList<>();
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(SQL)
				) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Comment comment = new Comment();
					comment.setCommentId(rs.getInt("COMMENT_ID"));
					comment.setMemberNo(rs.getInt("MEMBER_NO"));
					comment.setCourseId(rs.getInt("COURSE_ID"));
					comment.setRating(rs.getInt("RATING"));
					comment.setComment(rs.getString("COMMENT"));
					comment.setImage(rs.getBytes("IMAGE"));
					comment.setCommentReport(rs.getBoolean("COMMENT_REPORT"));
					
					resultlist.add(comment);
				}
			}
			return resultlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Comment> selectAll() {
		final String SQL = "SELECT c.*, m.USER_ID, co.COURSE_NAME\r\n" + "FROM COMMENT c\r\n"
				+ "JOIN MEMBER m ON c.MEMBER_NO = m.MEMBER_NO\r\n" + "JOIN COURSE co ON c.COURSE_ID = co.COURSE_ID;";
		List<Comment> resultList = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setCommentId(rs.getInt("COMMENT_ID"));
				comment.setMemberNo(rs.getInt("MEMBER_NO"));
				comment.setCourseId(rs.getInt("COURSE_ID"));
				comment.setRating(rs.getInt("RATING"));
				comment.setComment(rs.getString("COMMENT"));
				comment.setImage(rs.getBytes("IMAGE"));
				comment.setCommentReport(rs.getBoolean("COMMENT_REPORT"));
				comment.setUpdateTime(rs.getTimestamp("UPDATETIME"));
				comment.setUserId(rs.getString("USER_ID"));
				comment.setCourseName(rs.getString("COURSE_NAME"));
				resultList.add(comment);
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Comment selectByKey(Integer id) {
		final String SQL = "select * from COMMENT where COMMENT_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Comment comment = new Comment();
					comment.setCommentId(rs.getInt("COMMENT_ID"));
					comment.setMemberNo(rs.getInt("MEMBER_NO"));
					comment.setCourseId(rs.getInt("COURSE_ID"));
					comment.setRating(rs.getInt("RATING"));
					comment.setComment(rs.getString("COMMENT"));
					comment.setImage(rs.getBytes("IMAGE"));
					comment.setCommentReport(rs.getBoolean("COMMENT_REPORT"));
					
					return comment;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteByKey(Integer id) {
		final String SQL = "delete from COMMENT where COMMENT_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
