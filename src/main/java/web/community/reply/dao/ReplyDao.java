package web.community.reply.dao;

import web.community.reply.bean.Reply;

import java.util.List;

public interface ReplyDao {
    int insert(Reply reply);
    int update(Reply reply);
    Reply selectByKey(Integer id);
    int deleteByKey(Integer id);
    List<Reply> selectAll();
    List<Reply> selectAllByKey(Integer id);
}
