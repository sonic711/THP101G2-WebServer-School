package web.course.course.service;

import java.util.List;

import web.community.post.bean.Post;
import web.course.course.bean.Course;

public interface CourseService {
    boolean newOneCourse(Course course);
    Course findCourseById(Integer id);
    boolean editPost(Course course);
    List<Course> findAllCourse();
    List<Course> findAllByCourseId(Integer id);
    boolean removeCourseById(Integer id);
}
