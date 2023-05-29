package web.member.util;

import web.member.followclass.service.FollowClassService;
import web.member.followclass.service.impl.FollowClassServiceImpl;
import web.member.notification.service.NotificationService;
import web.member.notification.service.impl.NotificationServiceImpl;

import web.member.block.service.BlockService;
import web.member.block.service.impl.BlockServiceImpl;
import web.member.member.service.MemberService;
import web.member.member.service.impl.MemberServiceImpl;

public class MemberContains {
	public static final NotificationService NOTIFICATION_SERVICE = new NotificationServiceImpl();
    public static final FollowClassService FOLLOWCLASS_SERVICE = new FollowClassServiceImpl();
    public static final MemberService MEMBER_SERVICE = new MemberServiceImpl();
    public static final BlockService BLOCK_SERVICE = new BlockServiceImpl();
}
