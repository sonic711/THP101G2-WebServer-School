package web.community.post.service;

import web.community.post.bean.Post;

import java.util.List;

public interface PostService {
    Integer newOnePost(Post post);
    Post findPostById(Integer id);
    boolean editPost(Post post);
    List<Post> findAllPost();
    boolean removePostById(Integer id);
}
