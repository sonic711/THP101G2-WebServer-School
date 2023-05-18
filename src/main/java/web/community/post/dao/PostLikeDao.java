package web.community.post.dao;

import web.community.post.bean.PostLike;

import java.util.List;

public interface PostLikeDao {
    int insert(PostLike postLike);

    int update(PostLike postLike);

    int deleteByKey(Integer id);

    /**
     * 用文章編號查詢該文章所有表情
     * @param id 用COM_POST_ID 文章編號
     * @return List<PostLike> 該文章的所有表情
     */
    List<PostLike> selectAllByKey(Integer id);
}
