package web.community.post.dao;

import web.community.post.bean.Post;

import java.util.List;

public interface PostDao {
    int insert(Post post);
    int update(Post post);
    Post selectByKey(Integer id);
    int deleteByKey(Integer id);
    List<Post> selectAll();
}
