package web.community.reply.dao.impl;


import web.community.reply.bean.ReplyAtt;
import web.community.reply.dao.ReplyAttDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class ReplyAttDaoImpl implements ReplyAttDao {
    @Override
    public int insert(ReplyAtt replyAtt) {
        final String SQL = "insert into COM_REPLY_ATT(COM_REPLY_ID, COM_REPLY_ATT) "
                           + "values(?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, replyAtt.getComReplyId());
            pstmt.setBytes(2, replyAtt.getComReplyAtt());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(ReplyAtt replyAtt) {
        final String SQL = "update COM_REPLY_ATT set "
                           + "COM_REPLY_ATT = ? "
                           + "where COM_REPLY_ATT_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setBytes(1, replyAtt.getComReplyAtt());
            pstmt.setInt(2, replyAtt.getComReplyAttId());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public ReplyAtt selectByKey(Integer id) {
        final String SQL = "select * from COM_REPLY_ATT where COM_REPLY_ATT_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ReplyAtt replyAtt = new ReplyAtt();
                    replyAtt.setComReplyAttId(rs.getInt("COM_REPLY_ATT_ID"));
                    replyAtt.setComReplyId(rs.getInt("COM_REPLY_ID"));
                    replyAtt.setComReplyAtt(rs.getBytes("COM_REPLY_ATT"));
                    replyAtt.setComReplyUploadTime(rs.getTimestamp("COM_REPLY_UPLOAD_TIME"));

                    return replyAtt;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteByKey(Integer id) {
        final String SQL = "delete from COM_REPLY_ATT where COM_REPLY_ATT_ID = ?";
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
    public List<ReplyAtt> selectAllByKey(Integer id) {
        final String SQL = "select * from COM_REPLY_ATT where COM_REPLY_ID = ?";
        List<ReplyAtt> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ReplyAtt replyAtt = new ReplyAtt();
                    replyAtt.setComReplyAttId(rs.getInt("COM_REPLY_ATT_ID"));
                    replyAtt.setComReplyId(rs.getInt("COM_REPLY_ID"));
                    replyAtt.setComReplyAtt(rs.getBytes("COM_REPLY_ATT"));
                    replyAtt.setComReplyUploadTime(rs.getTimestamp("COM_REPLY_UPLOAD_TIME"));

                    resultList.add(replyAtt);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

