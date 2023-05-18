package web.community.reply.dao;

import web.community.reply.bean.ReplyAtt;
import web.community.reply.bean.ReplyLike;

import java.util.List;

public interface ReplyLikeDao {
    int insert(ReplyLike replyLike);

    int update(ReplyLike replyLike);

    int deleteByKey(Integer id);

    /**
     * 用comReplyId(回覆編號)找所有的喜歡
     */
    List<ReplyLike> selectAllByKey(Integer id);
}
