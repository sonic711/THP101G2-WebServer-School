package web.member.notification.service;

import web.member.notification.bean.Notification;

import java.util.List;

public interface NotificationService {
    boolean newOneNotification(Notification notification);
    boolean editNotification(Notification notification);
    boolean deleteNotificationById(Integer id);
    List<Notification> findAllNotificationById(Integer id);
}
