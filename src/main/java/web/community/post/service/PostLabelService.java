package web.community.post.service;

import web.community.post.bean.PostLabel;

import java.util.List;

public interface PostLabelService {
    boolean newPostLabel(List<PostLabel> postLabelList);
    boolean removePostAttById(Integer id);
    List<PostLabel> findAllPostLabel();
    List<PostLabel> findAllPostLabelById(Integer id);
}
