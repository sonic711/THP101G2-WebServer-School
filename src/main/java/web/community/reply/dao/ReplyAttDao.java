package web.community.reply.dao;

import web.community.reply.bean.ReplyAtt;

import java.util.List;

public interface ReplyAttDao {

    int insert(ReplyAtt replyAtt);

    int update(ReplyAtt replyAtt);

    ReplyAtt selectByKey(Integer id);

    int deleteByKey(Integer id);

    /**
     * 用文章編號找所有附檔
     */
    List<ReplyAtt> selectAllByKey(Integer id);
}
