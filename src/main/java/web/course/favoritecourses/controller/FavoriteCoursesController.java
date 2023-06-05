package web.course.favoritecourses.controller;
import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.course.course.util.CourseContainer.FAVORITE_COURSES_SERVICE;
import static web.course.course.util.CourseContainer.STUDENT_COURSES_SERVICE;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.course.favoritecourses.bean.FavoriteCourses;
import web.course.studentcourses.bean.StudentCourses;

@WebServlet("/favoritecourses/*")
public class FavoriteCoursesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String favoriteInfo = req.getPathInfo();
	
	if(favoriteInfo == null || Objects.equals(favoriteInfo, "/")) {
		writeJsonBean(resp, FAVORITE_COURSES_SERVICE.findAllFavoriteCourse());
	}else {
		try {
			favoriteInfo = favoriteInfo.substring(1);
			String[] pathVariables = favoriteInfo.split("/");
			Integer id = Integer.parseInt(pathVariables[0]);
			writeJsonBean(resp, FAVORITE_COURSES_SERVICE.findCourseById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

@Override
protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		FavoriteCourses favoriteCourses = json2Bean(req, FavoriteCourses.class);
		boolean result = FAVORITE_COURSES_SERVICE.editPost(favoriteCourses);
		writeJsonBean(resp, new CoreBean(result));
	} catch (Exception e) {
		e.printStackTrace();
	}
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		FavoriteCourses favoriteCourses = json2Bean(req, FavoriteCourses.class);
		Boolean result = FAVORITE_COURSES_SERVICE.newOneFavoriteCourse(favoriteCourses);
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
		boolean result = FAVORITE_COURSES_SERVICE.removeCourseById(id);
		writeJsonBean(resp, new CoreBean(result));
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
