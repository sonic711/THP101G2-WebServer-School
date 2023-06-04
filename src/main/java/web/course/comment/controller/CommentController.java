package web.course.comment.controller;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.course.course.util.CourseContainer.COMMENT_SERVICE;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.course.comment.bean.Comment;

@WebServlet("/comment/*")
public class CommentController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String commentInfo = req.getPathInfo();
		if (commentInfo == null || Objects.equals(commentInfo, "/")) {
			writeJsonBean(resp, COMMENT_SERVICE.findAllComment());
		} else {
			try {
				commentInfo = commentInfo.substring(1);
				String[] pathVariables = commentInfo.split("/");
				Integer id = Integer.parseInt(pathVariables[0]);
				writeJsonBean(resp, COMMENT_SERVICE.findAllByCommentId(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Comment comment = json2Bean(req, Comment.class);
			boolean result = COMMENT_SERVICE.editPost(comment);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Comment comment = json2Bean(req, Comment.class);
			Boolean result = COMMENT_SERVICE.newOneComment(comment);
			writeJsonBean(resp, new CoreBean(true, result.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pathInfo = req.getPathInfo();
		
		try {
			pathInfo = pathInfo.substring(1);
			String[] pathVariables = pathInfo.split("/");
			Integer id = Integer.parseInt(pathVariables[0]);
			boolean result = COMMENT_SERVICE.removeCommentById(id);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

