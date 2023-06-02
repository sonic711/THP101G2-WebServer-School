package web.community.reply.dao;

import web.community.reply.bean.Reply;
import web.community.reply.bean.ReplyAndLike;

import java.util.List;

public interface ReplyDao {
    int insert(Reply reply);
    int update(Reply reply);
    Reply selectByKey(Integer id);
    int deleteByKey(Integer id);
    List<Reply> selectAll();
    List<Reply> selectAllByKey(Integer id);
    /**
     *  用comPostId(文章編號)找所有回覆跟喜歡
     * */
    List<ReplyAndLike> selectAllReplyAndLikeByKey(Integer id);
}
