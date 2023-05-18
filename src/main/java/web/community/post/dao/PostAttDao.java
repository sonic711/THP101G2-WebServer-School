package web.community.post.dao;

import web.community.post.bean.Post;
import web.community.post.bean.PostAtt;

import java.util.List;

public interface PostAttDao {

    int insert(PostAtt postAtt);

    int update(PostAtt postAtt);

    PostAtt selectByKey(Integer id);

    int deleteByKey(Integer id);

    /**
     * 用文章編號查詢該文章所有附檔案
     * @param id 用COM_POST_ID 文章編號
     * @return List<PostAtt> 該文章的所有附檔
     */
    List<PostAtt> selectAllByKey(Integer id);
}
