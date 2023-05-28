package web.community.post.service.impl;

import web.community.post.bean.PostLabel;
import web.community.post.dao.PostLabelDao;
import web.community.post.dao.impl.PostLabelDaoImpl;
import web.community.post.service.PostLabelService;

import java.util.List;

public class PostLabelServiceImpl implements PostLabelService {
    private PostLabelDao dao;

    public PostLabelServiceImpl() {
        dao = new PostLabelDaoImpl();
    }


    @Override
    public boolean newPostLabel(List<PostLabel> postLabelList, Integer id) {
        int result = dao.insert(postLabelList, id);
        return result > 0;
    }

    @Override
    public boolean removePostAttById(Integer id) {
        int result = dao.deleteByKey(id);
        return result > 0;
    }

    @Override
    public List<PostLabel> findAllPostLabel() {
        return dao.selectAll();
    }

    @Override
    public List<PostLabel> findAllPostLabelById(Integer id) {
        return dao.selectAllByKey(id);
    }
}
