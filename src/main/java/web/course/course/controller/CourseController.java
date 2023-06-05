package web.course.course.controller;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.course.course.util.CourseContainer.COURSE_SERVICE;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.course.course.bean.Course;

@WebServlet("/course/*")
public class CourseController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String courseInfo = req.getPathInfo();

		if (courseInfo == null || Objects.equals(courseInfo, "/")) {
			writeJsonBean(resp, COURSE_SERVICE.findAllCourse());
		} else {
			try {
				courseInfo = courseInfo.substring(1);
				String[] pathVariables = courseInfo.split("/");
				Integer id = Integer.parseInt(pathVariables[0]);
				writeJsonBean(resp, COURSE_SERVICE.findCourseById(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Course course = json2Bean(req, Course.class);
			boolean result = COURSE_SERVICE.editPost(course);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Course course = json2Bean(req, Course.class);
			System.out.println(course);
			Boolean result = COURSE_SERVICE.newOneCourse(course);
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
			boolean result = COURSE_SERVICE.removeCourseById(id);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
