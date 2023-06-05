package web.course.studentcourses.dao;

import java.util.List;

import web.course.studentcourses.bean.StudentCourses;


public interface StudentCoursesDao {
		 int insert(StudentCourses studentcourses);
		    List<StudentCourses> selectAllByKey(Integer id);
		    List<StudentCourses> selectAll();
		    StudentCourses selectByKey(Integer id);
		    int deleteByKey(Integer id);
		    int update(StudentCourses studentCourses);
}
