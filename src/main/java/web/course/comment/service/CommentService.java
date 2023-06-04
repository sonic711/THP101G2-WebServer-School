package web.course.comment.service;

import java.util.List;

import web.course.comment.bean.Comment;

public interface CommentService {
	
	 	boolean newOneComment(Comment comment);
	 	Comment findCourseById(Integer id);
	    boolean editPost(Comment comment);
	    List<Comment> findAllComment();
	    List<Comment> findAllByCommentId(Integer id);
	    boolean removeCommentById(Integer id);
}
