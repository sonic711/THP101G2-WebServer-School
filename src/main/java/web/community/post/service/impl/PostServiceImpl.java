package web.community.post.service.impl;

import jdk.jfr.TransitionFrom;
import web.community.post.bean.Post;
import web.community.post.bean.PostLabel;
import web.community.post.dao.PostDao;
import web.community.post.dao.PostLabelDao;
import web.community.post.dao.impl.PostDaoImpl;
import web.community.post.dao.impl.PostLabelDaoImpl;
import web.community.post.service.PostService;

import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {
    private PostDao dao;
    private PostLabelDao labelDao;

    public PostServiceImpl() {
        dao = new PostDaoImpl();
        labelDao = new PostLabelDaoImpl();
    }
    // 沒選擇分類回傳0 新增文章失敗回傳1 全部成功回傳2
    @Override
    public Integer newOnePost(Post post) {

        Integer secClassId = post.getComSecClassId();

        if(secClassId == null || secClassId < 1) return 0;
        int result = dao.insert(post);
        if(result < 1){
            return 1;
        }
        post.setComPostId(result);
        labelDao.insert(post.getLabelList(), result);
        return 2;
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
