package web.community.reply.dao.impl;

import web.community.reply.bean.ReplyAtt;
import web.community.reply.bean.ReplyLike;
import web.community.reply.dao.ReplyLikeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class ReplyLikeDaoImpl implements ReplyLikeDao {
    @Override
    public int insert(ReplyLike replyLike) {
        final String SQL = "insert into COM_REPLY_LIKE(MEMBER_NO, COM_REPLY_ID, COM_REPLY_EMOTION) "
                           + "values(?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, replyLike.getMemberNo());
            pstmt.setInt(2, replyLike.getComReplyId());
            pstmt.setBoolean(3, replyLike.getComReplyEmotion());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(ReplyLike replyLike) {
        final String SQL = "update COM_REPLY_LIKE set "
                           + "COM_REPLY_EMOTION = ? "
                           + "where COM_REPLY_LIKE_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setBoolean(1, replyLike.getComReplyEmotion());
            pstmt.setInt(2, replyLike.getComReplyLikeId());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteByKey(Integer id) {
        final String SQL = "delete from COM_REPLY_LIKE where COM_REPLY_LIKE_ID = ?";
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
    public List<ReplyLike> selectAllByKey(Integer id) {
        final String SQL = "select * from COM_REPLY_LIKE where COM_REPLY_ID = ?";
        List<ReplyLike> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ReplyLike replyLike = new ReplyLike();
                    replyLike.setComReplyLikeId(rs.getInt("COM_REPLY_LIKE_ID"));
                    replyLike.setMemberNo(rs.getInt("MEMBER_NO"));
                    replyLike.setComReplyId(rs.getInt("COM_REPLY_ID"));
                    replyLike.setComReplyEmotion(rs.getBoolean("COM_REPLY_EMOTION"));

                    resultList.add(replyLike);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
