package web.course.course.service.impl;

import java.util.List;

import web.course.course.bean.Course;
import web.course.course.dao.CourseDao;
import web.course.course.dao.impl.CourseDaoImpl;
import web.course.course.service.CourseService;

public class CourseServiceImpl implements CourseService{
	private CourseDao dao;
	
	public CourseServiceImpl() {
		dao = new CourseDaoImpl();
	}

	@Override
	public boolean newOneCourse(Course course) {
			// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course findCourseById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editPost(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> findAllCourse() {
		return dao.selectAll();
	}

	@Override
	public List<Course> findAllByCourseId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCourseById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
