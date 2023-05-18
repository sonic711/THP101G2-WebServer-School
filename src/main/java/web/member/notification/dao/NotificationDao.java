package web.member.notification.dao;

import web.member.notification.bean.Notification;

import java.util.List;

public interface NotificationDao {

    int insert(Notification notification);

    int update(Notification notification);

    int deleteByKey(Integer id);

    List<Notification> findAllById(Integer id);
}
