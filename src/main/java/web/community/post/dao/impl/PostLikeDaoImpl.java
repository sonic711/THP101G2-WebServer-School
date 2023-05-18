package web.community.post.dao.impl;


import web.community.post.bean.PostLike;
import web.community.post.dao.PostLikeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class PostLikeDaoImpl implements PostLikeDao {

    @Override
    public int insert(PostLike postLike) {
        final String SQL = "insert into COM_POST_LIKE(MEMBER_NO, COM_POST_ID, COM_POST_EMOTION) "
                           + "values(?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, postLike.getMemberNo());
            pstmt.setInt(2, postLike.getComPostId());
            pstmt.setByte(3, postLike.getComPostEmotion());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(PostLike postLike) {
        final String SQL = "update COM_POST_LIKE set "
                           + "COM_POST_EMOTION = ? "
                           + "where COM_POST_LIKE_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setByte(1, postLike.getComPostEmotion());
            pstmt.setInt(2, postLike.getComPostLikeId());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteByKey(Integer id) {
        final String SQL = "delete from COM_POST_LIKE where COM_POST_LIKE_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<PostLike> selectAllByKey(Integer id) {
        final String SQL = "select * from COM_POST_LIKE where COM_POST_ID = ?";
        List<PostLike> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PostLike postLike = new PostLike();
                    postLike.setComPostLikeId(rs.getInt("COM_POST_LIKE_ID"));
                    postLike.setComPostId(rs.getInt("COM_POST_ID"));
                    postLike.setMemberNo(rs.getInt("MEMBER_NO"));
                    postLike.setComPostEmotion(rs.getByte("COM_POST_EMOTION"));

                    resultList.add(postLike);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
