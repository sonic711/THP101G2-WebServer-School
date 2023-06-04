package web.course.course.util;


import web.course.chapter.service.ChapterService;
import web.course.chapter.service.impl.ChapterServiceImpl;
import web.course.comment.service.CommentService;
import web.course.comment.service.impl.CommentServiceImpl;
import web.course.course.service.CourseService;
import web.course.course.service.impl.CourseServiceImpl;
import web.course.favoritecourses.service.FavoriteCoursesService;
import web.course.favoritecourses.service.impl.FavoriteCoursesServiceImpl;
import web.course.studentcourses.service.StudentCoursesService;
import web.course.studentcourses.service.impl.StudentCoursesServiceImpl;

public class CourseContainer {
    public static final CourseService COURSE_SERVICE = new CourseServiceImpl();
    public static final ChapterService CHAPTER_SERVICE = new ChapterServiceImpl();
    public static final CommentService COMMENT_SERVICE = new CommentServiceImpl();
    public static final FavoriteCoursesService FAVORITE_COURSES_SERVICE = new FavoriteCoursesServiceImpl();
    public static final StudentCoursesService STUDENT_COURSES_SERVICE = new StudentCoursesServiceImpl();
}
