package web.community.post.service.impl;

import web.community.post.bean.PostLike;
import web.community.post.dao.PostLikeDao;
import web.community.post.dao.impl.PostLikeDaoImpl;
import web.community.post.service.PostLikeService;

import java.util.List;

public class PostLikeServiceImpl implements PostLikeService {
    private PostLikeDao dao;

    public PostLikeServiceImpl() {
        dao = new PostLikeDaoImpl();
    }

    @Override
    public boolean newOnePostLike(PostLike postLike) {
        int result = dao.insert(postLike);
        return result > 0;
    }

    @Override
    public boolean editPostLike(PostLike postLike) {
        int result = dao.update(postLike);
        return result > 0;
    }

    @Override
    public List<PostLike> findAllPostLikeByPostId(Integer id) {
        return dao.selectAllByKey(id);
    }

    @Override
    public boolean removePostLikeById(Integer id) {
        int result = dao.deleteByKey(id);
        return result > 0;
    }
}
