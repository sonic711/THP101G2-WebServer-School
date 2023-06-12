package web.course.chapter.controller;

import static core.util.CommonUtil.writeJsonBean;
import static web.course.course.util.CourseContainer.CHAPTER_SERVICE;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
@WebServlet("/chaptervideo/*")
public class ChapterVideoController  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String chapterInfo = req.getPathInfo();
		if (chapterInfo == null || Objects.equals(chapterInfo, "/")) {
			writeJsonBean(resp, new CoreBean(false, "不支援此方法"));
		} else {
			try {
				chapterInfo = chapterInfo.substring(1);
				String[] pathVariables = chapterInfo.split("/");
				Integer id = Integer.parseInt(pathVariables[0]);
				writeJsonBean(resp, CHAPTER_SERVICE.findAllByChapterId(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
