package web.community.reply.dao.impl;

import web.community.reply.bean.Reply;
import web.community.reply.dao.ReplyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class ReplyDaoImpl implements ReplyDao {
    @Override
    public int insert(Reply reply) {
        final String SQL = "insert into COM_REPLY(MEMBER_NO, COM_REPLY_TO, COM_REPLY_CONTENT) "
                           + "values(?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, reply.getMemberNo());
            pstmt.setInt(2, reply.getComReplyTo());
            pstmt.setString(3, reply.getComReplyContent());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(Reply reply) {
        final String SQL = "update COM_REPLY set "
                           + "COM_REPLY_CONTENT = ? "
                           + "where COM_REPLY_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setString(1, reply.getComReplyContent());
            pstmt.setInt(2, reply.getComReplyId());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Reply selectByKey(Integer id) {
        final String SQL = "select * from COM_REPLY where COM_REPLY_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Reply reply = new Reply();
                    reply.setComReplyId(rs.getInt("COM_REPLY_ID"));
                    reply.setMemberNo(rs.getInt("MEMBER_NO"));
                    reply.setComReplyTo(rs.getInt("COM_REPLY_TO"));
                    reply.setComReplyContent(rs.getString("COM_REPLY_CONTENT"));
                    reply.setComReplyTime(rs.getTimestamp("COM_REPLY_TIME"));
                    reply.setComReplyAccessSetting(rs.getBoolean("COM_REPLY_ACCESS_SETTING"));

                    return reply;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteByKey(Integer id) {
        final String SQL = "delete from COM_REPLY where COM_REPLY_ID = ?";
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
    public List<Reply> selectAll() {
        final String SQL = "select * from COM_REPLY";
        List<Reply> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {

                Reply reply = new Reply();
                reply.setComReplyId(rs.getInt("COM_REPLY_ID"));
                reply.setMemberNo(rs.getInt("MEMBER_NO"));
                reply.setComReplyTo(rs.getInt("COM_REPLY_TO"));
                reply.setComReplyContent(rs.getString("COM_REPLY_CONTENT"));
                reply.setComReplyTime(rs.getTimestamp("COM_REPLY_TIME"));
                reply.setComReplyAccessSetting(rs.getBoolean("COM_REPLY_ACCESS_SETTING"));

                resultList.add(reply);
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reply> selectAllByKey(Integer id) {
        final String SQL = "SELECT r.*, m.PROFILE_PHOTO,m.NICKNAME, m.USER_ID FROM COM_REPLY r left join MEMBER m on r.MEMBER_NO = m.MEMBER_NO where COM_REPLY_TO = ?";
        List<Reply> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);

        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    Reply reply = new Reply();
                    reply.setComReplyId(rs.getInt("COM_REPLY_ID"));
                    reply.setMemberNo(rs.getInt("MEMBER_NO"));
                    reply.setNickName(rs.getString("NICKNAME"));
                    reply.setUserId(rs.getString("USER_ID"));
                    reply.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
                    reply.setComReplyTo(rs.getInt("COM_REPLY_TO"));
                    reply.setComReplyContent(rs.getString("COM_REPLY_CONTENT"));
                    reply.setComReplyTime(rs.getTimestamp("COM_REPLY_TIME"));
                    reply.setComReplyAccessSetting(rs.getBoolean("COM_REPLY_ACCESS_SETTING"));

                    resultList.add(reply);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

