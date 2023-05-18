package web.community.reply.service;

import web.community.reply.bean.Reply;
import web.community.reply.bean.ReplyAtt;

import java.util.List;

public interface ReplyAttService {
    boolean newOneReplyAtt(ReplyAtt replyAtt);

    ReplyAtt findReplyAttById(Integer id);

    boolean editReplyAtt(ReplyAtt reply);

    List<ReplyAtt> findAllReplyAttById(Integer id);

    boolean removeReplyAttById(Integer id);
}
