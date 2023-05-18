package web.community.post.service.impl;

import web.community.post.bean.PostAtt;
import web.community.post.dao.PostAttDao;
import web.community.post.dao.PostDao;
import web.community.post.dao.impl.PostAttDaoImpl;
import web.community.post.dao.impl.PostDaoImpl;
import web.community.post.service.PostAttService;

import java.util.List;

public class PostAttServiceImpl implements PostAttService {
    private PostAttDao dao;

    public PostAttServiceImpl() {
        dao = new PostAttDaoImpl();
    }

    @Override
    public boolean newOnePostAtt(PostAtt postAtt) {
        int result = dao.insert(postAtt);
        return result > 0;
    }

    @Override
    public PostAtt findPostById(Integer id) {
        return dao.selectByKey(id);
    }

    @Override
    public boolean editPostAtt(PostAtt postAtt) {
        int result = dao.update(postAtt);
        return result > 0;
    }

    @Override
    public List<PostAtt> findAllPostAttById(Integer id) {
        return dao.selectAllByKey(id);
    }

    @Override
    public boolean removePostAttById(Integer id) {
        int result = dao.deleteByKey(id);
        return result > 0;
    }
}
