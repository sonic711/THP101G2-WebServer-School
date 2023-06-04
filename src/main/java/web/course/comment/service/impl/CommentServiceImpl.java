package web.course.comment.service.impl;

import java.util.List;

import web.course.comment.bean.Comment;
import web.course.comment.dao.CommentDao;
import web.course.comment.dao.impl.CommentDaoImpl;
import web.course.comment.service.CommentService;



public class CommentServiceImpl implements CommentService{
	
	private CommentDao dao;
	
	public CommentServiceImpl() {
		dao = new CommentDaoImpl();
	}

	@Override
	public boolean newOneComment(Comment comment) {
		int result = dao.insert(comment);
        return result > 0;
	}

	@Override
	public Comment findCourseById(Integer id) {
        return dao.selectByKey(id);

	}

	@Override
	public boolean editPost(Comment comment) {
		int result = dao.update(comment);
        return result > 0;
	}

	@Override
	public List<Comment> findAllComment() {
		return dao.selectAll();

	}

	@Override
	public List<Comment> findAllByCommentId(Integer id) {
		return dao.selectAllByKey(id);

	}

	@Override
	public boolean removeCommentById(Integer id) {
		int result = dao.deleteByKey(id);
        return result > 0;
	}



}
