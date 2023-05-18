package web.community.reply.service.impl;

import web.community.reply.bean.ReplyAtt;
import web.community.reply.dao.ReplyAttDao;
import web.community.reply.dao.impl.ReplyAttDaoImpl;
import web.community.reply.service.ReplyAttService;

import java.util.List;

public class ReplyAttServiceImpl implements ReplyAttService {
    private ReplyAttDao dao;

    public ReplyAttServiceImpl() {
        dao = new ReplyAttDaoImpl();
    }
    @Override
    public boolean newOneReplyAtt(ReplyAtt replyAtt) {
        int result = dao.insert(replyAtt);
        return result > 0;
    }

    @Override
    public ReplyAtt findReplyAttById(Integer id) {
        return dao.selectByKey(id);
    }

    @Override
    public boolean editReplyAtt(ReplyAtt reply) {
        int result = dao.update(reply);
        return result > 0;
    }

    @Override
    public List<ReplyAtt> findAllReplyAttById(Integer id) {
        return dao.selectAllByKey(id);
    }

    @Override
    public boolean removeReplyAttById(Integer id) {
        int result = dao.deleteByKey(id);
        return result > 0;
    }
}
