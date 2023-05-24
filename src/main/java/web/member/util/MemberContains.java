package web.member.util;

import web.member.followclass.service.FollowClassService;
import web.member.followclass.service.impl.FollowClassServiceImpl;
import web.member.notification.service.NotificationService;
import web.member.notification.service.impl.NotificationServiceImpl;

public class MemberContains {
    public static final NotificationService NOTIFICATION_SERVICE = new NotificationServiceImpl();
    public static final FollowClassService FOLLOWCLASS_SERVICE = new FollowClassServiceImpl();
}
