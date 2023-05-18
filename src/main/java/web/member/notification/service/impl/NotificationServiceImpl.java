package web.member.notification.service.impl;

import web.member.notification.bean.Notification;
import web.member.notification.dao.NotificationDao;
import web.member.notification.dao.impl.NotificationDaoImpl;
import web.member.notification.service.NotificationService;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {
    private NotificationDao dao;

    public NotificationServiceImpl() {
        dao = new NotificationDaoImpl();
    }

    @Override
    public boolean newOneNotification(Notification notification) {
        int result = dao.insert(notification);
        return result > 0;
    }

    @Override
    public boolean editNotification(Notification notification) {
        int result = dao.update(notification);
        return result > 0;
    }

    @Override
    public boolean deleteNotificationById(Integer id) {
        int result = dao.deleteByKey(id);
        return result > 0;
    }

    @Override
    public List<Notification> findAllNotificationById(Integer id) {
        return dao.findAllById(id);
    }
}
