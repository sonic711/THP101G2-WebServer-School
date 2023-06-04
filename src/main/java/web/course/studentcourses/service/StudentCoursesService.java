package web.course.studentcourses.service;
import java.util.List;

import web.course.studentcourses.bean.StudentCourses;

public interface StudentCoursesService {
	boolean newOneStudentCourse(StudentCourses studentCourses);
	StudentCourses findStudentCourseById(Integer id);
	    List<StudentCourses> findAllStudentCourse();
	    List<StudentCourses> findAllByStudentCourseId(Integer id);
	    boolean removeCourseById(Integer id);
	    boolean editPost(StudentCourses studentCourses);
}
