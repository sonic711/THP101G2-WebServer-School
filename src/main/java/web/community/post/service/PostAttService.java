package web.community.post.service;

import web.community.post.bean.Post;
import web.community.post.bean.PostAtt;

import java.util.List;

public interface PostAttService {
    boolean newOnePostAtt(PostAtt postAtt);
    PostAtt findPostById(Integer id);
    boolean editPostAtt(PostAtt postAtt);
    List<PostAtt> findAllPostAttById(Integer id);
    boolean removePostAttById(Integer id);
}
