package web.community.reply.service;

import web.community.reply.bean.Reply;
import web.community.reply.bean.ReplyAndLike;

import java.util.List;

public interface ReplyService {
    boolean newOneReply(Reply reply);
    Reply findReplyById(Integer id);
    boolean editReply(Reply reply);
    boolean removeReplyById(Integer id);
    List<Reply> findAllReply();
    List<Reply> findAllReplyById(Integer id);
    /**
     *  用comPostId(文章編號)找所有回覆跟喜歡
     * */
    List<ReplyAndLike> findAllReplyAndLikeById(Integer id);
}
