package web.course.course.controller;

import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.POST_SERVICE;
import static web.course.course.util.CourseContainer.COURSE_SERVICE;
import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
