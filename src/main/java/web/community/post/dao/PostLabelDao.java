package web.community.post.dao;

import web.community.post.bean.PostLabel;
import web.community.post.bean.PostLike;

import java.util.List;

public interface PostLabelDao {

    int insert(List<PostLabel> postLabelList, Integer id);

    int deleteByKey(Integer id);

    List<PostLabel> selectAll();

    /**
     * 用文章編號查詢該文章所有標籤
     *
     * @param id 用COM_POST_ID 文章編號
     * @return List<PostLabel> 該文章的所有標籤
     */
    List<PostLabel> selectAllByKey(Integer id);
}
