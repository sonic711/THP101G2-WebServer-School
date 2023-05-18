package web.community.reply.service;

import web.community.reply.bean.Reply;

import java.util.List;

public interface ReplyService {
    boolean newOneReply(Reply reply);
    Reply findReplyById(Integer id);
    boolean editReply(Reply reply);
    List<Reply> findAllReply();
    boolean removeReplyById(Integer id);
}
