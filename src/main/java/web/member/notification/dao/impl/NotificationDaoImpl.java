package web.member.notification.dao.impl;

import web.community.reply.bean.ReplyAtt;
import web.member.notification.bean.Notification;
import web.member.notification.dao.NotificationDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class NotificationDaoImpl implements NotificationDao {
    @Override
    public int insert(Notification notification) {
        final String SQL = "insert into MEMBER_NOTIFICATION(MEMBER_NO, NOTIFICATION_CONTENT) "
                           + "values(?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, notification.getMemberNo());
            pstmt.setString(2, notification.getNotificationContent());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(Notification notification) {
        final String SQL = "update MEMBER_NOTIFICATION set "
                           + "NOTIFICATION_STATUS = ? "
                           + "where NOTIFICATION_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setBoolean(1, notification.getNotificationStatus());
            pstmt.setInt(2, notification.getNotificationId());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteByKey(Integer id) {
        final String SQL = "delete from MEMBER_NOTIFICATION where NOTIFICATION_ID = ?";
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
    public List<Notification> findAllById(Integer id) {
        final String SQL = "select * from MEMBER_NOTIFICATION where MEMBER_NO = ?";
        List<Notification> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Notification notification = new Notification();
                    notification.setNotificationId(rs.getInt("NOTIFICATION_ID"));
                    notification.setMemberNo(rs.getInt("MEMBER_NO"));
                    notification.setNotificationContent(rs.getString("NOTIFICATION_CONTENT"));
                    notification.setNotificationStatus(rs.getBoolean("NOTIFICATION_STATUS"));
                    notification.setNotificationTime(rs.getTimestamp("NOTIFICATION_TIME"));

                    resultList.add(notification);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
