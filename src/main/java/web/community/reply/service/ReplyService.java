package web.community.reply.service;

import web.community.reply.bean.Reply;

import java.util.List;

public interface ReplyService {
    boolean newOneReply(Reply reply);
    Reply findReplyById(Integer id);
    boolean editReply(Reply reply);
    boolean removeReplyById(Integer id);
    List<Reply> findAllReply();
    List<Reply> findAllReplyById(Integer id);
}
