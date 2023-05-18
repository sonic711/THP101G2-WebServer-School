package web.community.reply.service.impl;

import web.community.reply.bean.ReplyLike;
import web.community.reply.dao.ReplyLikeDao;
import web.community.reply.dao.impl.ReplyLikeDaoImpl;
import web.community.reply.service.ReplyLikeService;

import java.util.List;

public class ReplyLikeServiceImpl implements ReplyLikeService {
    private ReplyLikeDao dao;

    public ReplyLikeServiceImpl() {
        dao = new ReplyLikeDaoImpl();
    }

    @Override
    public boolean newOneReplyLike(ReplyLike replyLike) {
        int result = dao.insert(replyLike);
        return result > 0;
    }

    @Override
    public boolean editReplyLike(ReplyLike replyLike) {
        int result = dao.update(replyLike);
        return result > 0;
    }

    @Override
    public List<ReplyLike> findAllReplyLikeById(Integer id) {
        return dao.selectAllByKey(id);
    }

    @Override
    public boolean removeReplyLikeById(Integer id) {
        int result = dao.deleteByKey(id);
        return result > 0;
    }
}
