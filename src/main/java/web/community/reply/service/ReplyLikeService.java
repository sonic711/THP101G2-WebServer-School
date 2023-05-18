package web.community.reply.service;

import web.community.reply.bean.ReplyAtt;
import web.community.reply.bean.ReplyLike;

import java.util.List;

public interface ReplyLikeService {

    boolean newOneReplyLike(ReplyLike replyLike);

    boolean editReplyLike(ReplyLike replyLike);

    List<ReplyLike> findAllReplyLikeById(Integer id);

    boolean removeReplyLikeById(Integer id);

}
