package web.course.course.dao;

import java.util.List;

import web.community.post.bean.Post;
import web.course.course.bean.Course;

public interface CourseDao {
	   int insert(Course course);
	    int update(Course course);
	    List<Course> selectAllByKey(Integer id);
	    List<Course> selectAll();
	    Course selectByKey(Integer id);
	    int deleteByKey(Integer id);
}
