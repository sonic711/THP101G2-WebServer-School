package web.course.chapter.controller;

import static core.util.CommonUtil.json2Bean;
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
import web.course.chapter.bean.Chapter;

@WebServlet("/chapter/*")
public class ChapterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String chapterInfo = req.getPathInfo();
		if (chapterInfo == null || Objects.equals(chapterInfo, "/")) {
			writeJsonBean(resp, CHAPTER_SERVICE.findAllChapter());
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

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Chapter chapter = json2Bean(req, Chapter.class);
			boolean result = CHAPTER_SERVICE.editPost(chapter);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Chapter chapter = json2Bean(req, Chapter.class);
			Boolean result = CHAPTER_SERVICE.newOneChapter(chapter);
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
			boolean result = CHAPTER_SERVICE.removeChapterById(id);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
