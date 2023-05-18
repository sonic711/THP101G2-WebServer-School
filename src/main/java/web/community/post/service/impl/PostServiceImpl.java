package web.community.post.service.impl;

import web.community.post.bean.Post;
import web.community.post.dao.PostDao;
import web.community.post.dao.impl.PostDaoImpl;
import web.community.post.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    private PostDao dao;

    public PostServiceImpl() {
        dao = new PostDaoImpl();
    }

    @Override
    public boolean newOnePost(Post post) {
        int result = dao.insert(post);
        return result > 0;
    }

    @Override
    public Post findPostById(Integer id) {
        return dao.selectByKey(id);
    }

    @Override
    public boolean editPost(Post post) {
        int result = dao.update(post);
        return result > 0;
    }

    @Override
    public List<Post> findAllPost() {
        return dao.selectAll();
    }

    @Override
    public boolean removePostById(Integer id) {
        int result = dao.deleteByKey(id);
        return result > 0;
    }
}
