package web.community.util;

import web.community.classes.service.ClassService;
import web.community.classes.service.impl.ClassServiceImpl;
import web.community.post.service.PostAttService;
import web.community.post.service.PostLabelService;
import web.community.post.service.PostLikeService;
import web.community.post.service.PostService;
import web.community.post.service.impl.PostAttServiceImpl;
import web.community.post.service.impl.PostLabelServiceImpl;
import web.community.post.service.impl.PostLikeServiceImpl;
import web.community.post.service.impl.PostServiceImpl;
import web.community.reply.service.ReplyAttService;
import web.community.reply.service.ReplyLikeService;
import web.community.reply.service.ReplyService;
import web.community.reply.service.impl.ReplyAttServiceImpl;
import web.community.reply.service.impl.ReplyLikeServiceImpl;
import web.community.reply.service.impl.ReplyServiceImpl;

public class CommunityContains {
    public static final ClassService CLASS_SERVICE = new ClassServiceImpl();
    public static final PostService POST_SERVICE = new PostServiceImpl();
    public static final PostLabelService POSTLABEL_SERVICE = new PostLabelServiceImpl();
    public static final PostAttService POSTATT_SERVICE = new PostAttServiceImpl();
    public static final PostLikeService POSTLIKE_SERVICE = new PostLikeServiceImpl();
    public static final ReplyService REPLY_SERVICE = new ReplyServiceImpl();
    public static final ReplyAttService REPLYATT_SERVICE = new ReplyAttServiceImpl();
    public static final ReplyLikeService REPLYLIKE_SERVICE = new ReplyLikeServiceImpl();
}
