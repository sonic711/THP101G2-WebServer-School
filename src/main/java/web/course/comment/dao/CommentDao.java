package web.course.comment.dao;

import java.util.List;

import web.course.comment.bean.Comment;

public interface CommentDao {
	int insert(Comment comment);
    int update(Comment comment);
    List<Comment> selectAllByKey(Integer id);
    List<Comment> selectAll();
    Comment selectByKey(Integer id);
    int deleteByKey(Integer id);
}
