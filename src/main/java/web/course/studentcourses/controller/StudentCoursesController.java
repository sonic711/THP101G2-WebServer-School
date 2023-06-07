package web.course.studentcourses.controller;
import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.course.course.util.CourseContainer.STUDENT_COURSES_SERVICE;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.course.studentcourses.bean.StudentCourses;

@WebServlet("/studentcourses/*")
public class StudentCoursesController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String studentInfo = req.getPathInfo();
	
	if(studentInfo == null || Objects.equals(studentInfo, "/")) {
		writeJsonBean(resp, STUDENT_COURSES_SERVICE.findAllStudentCourse());
	}else {
		try {
			studentInfo = studentInfo.substring(1);
			String[] pathVariables = studentInfo.split("/");
			Integer id = Integer.parseInt(pathVariables[0]);
			writeJsonBean(resp, STUDENT_COURSES_SERVICE.findAllByStudentCourseId(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

@Override
protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		StudentCourses studentCourses = json2Bean(req, StudentCourses.class);
		boolean result = STUDENT_COURSES_SERVICE.editPost(studentCourses);
		writeJsonBean(resp, new CoreBean(result));
	} catch (Exception e) {
		e.printStackTrace();
	}
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		StudentCourses studentCourses = json2Bean(req, StudentCourses.class);
		Boolean result = STUDENT_COURSES_SERVICE.newOneStudentCourse(studentCourses);
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
		boolean result = STUDENT_COURSES_SERVICE.removeCourseById(id);
		writeJsonBean(resp, new CoreBean(result));
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
