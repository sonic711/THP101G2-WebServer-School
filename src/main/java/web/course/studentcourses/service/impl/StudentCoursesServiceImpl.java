package web.course.studentcourses.service.impl;

import java.util.List;

import web.course.studentcourses.bean.StudentCourses;
import web.course.studentcourses.dao.StudentCoursesDao;
import web.course.studentcourses.dao.impl.StudentCoursesDaoImpl;
import web.course.studentcourses.service.StudentCoursesService;

public class StudentCoursesServiceImpl implements StudentCoursesService{
private StudentCoursesDao dao;

public StudentCoursesServiceImpl() {
	dao = new StudentCoursesDaoImpl();
}

@Override
public boolean newOneStudentCourse(StudentCourses studentCourses) {
	int result = dao.insert(studentCourses);
    return result > 0;
}

@Override
public StudentCourses findStudentCourseById(Integer id) {
    return dao.selectByKey(id);

}

@Override
public List<StudentCourses> findAllStudentCourse() {
	return dao.selectAll();

}

@Override
public List<StudentCourses> findAllByStudentCourseId(Integer id) {
	return dao.selectAllByKey(id);

}

@Override
public boolean removeCourseById(Integer id) {
	int result = dao.deleteByKey(id);
    return result > 0;
}

@Override
public boolean editPost(StudentCourses studentCourses) {
	int result = dao.update(studentCourses);
    return result > 0;
}


}
