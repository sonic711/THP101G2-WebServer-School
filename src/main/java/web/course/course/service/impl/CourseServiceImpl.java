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
		int result = dao.insert(course);
        return result > 0;
	        }
	       
	@Override
	public Course findCourseById(Integer id) {
        return dao.selectByKey(id);
	}

	@Override
	public boolean editPost(Course course) {
		int result = dao.update(course);
        return result > 0;
	}

	@Override
	public List<Course> findAllCourse() {
		return dao.selectAll();
	}

	@Override
	public List<Course> findAllByCourseId(Integer id) {
		return dao.selectAllByKey(id);
	}

	@Override
	public boolean removeCourseById(Integer id) {
		int result = dao.deleteByKey(id);
        return result > 0;
	}

}
