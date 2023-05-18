package web.community.post.service;

import web.community.post.bean.PostLike;

import java.util.List;

public interface PostLikeService {
    boolean newOnePostLike(PostLike postLike);
    boolean editPostLike(PostLike postLike);
    List<PostLike> findAllPostLikeByPostId(Integer id);
    boolean removePostLikeById(Integer id);
}
