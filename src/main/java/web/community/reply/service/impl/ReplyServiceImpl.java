package web.community.reply.service.impl;

import web.community.reply.bean.Reply;
import web.community.reply.dao.ReplyDao;
import web.community.reply.dao.impl.ReplyDaoImpl;
import web.community.reply.service.ReplyService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDao dao;

    public ReplyServiceImpl() {
        dao = new ReplyDaoImpl();
    }

    @Override
    public boolean newOneReply(Reply reply) {
        int result = dao.insert(reply);
        return result > 0;
    }

    @Override
    public Reply findReplyById(Integer id) {
        return dao.selectByKey(id);
    }

    @Override
    public boolean editReply(Reply reply) {
        int result = dao.update(reply);
        return result > 0;
    }

    @Override
    public List<Reply> findAllReply() {
        return dao.selectAll();
    }

    @Override
    public List<Reply> findAllReplyById(Integer id) {
        return dao.selectAllByKey(id);
    }

    @Override
    public boolean removeReplyById(Integer id) {



        int result = dao.deleteByKey(id);
        return result > 0;
    }
}
