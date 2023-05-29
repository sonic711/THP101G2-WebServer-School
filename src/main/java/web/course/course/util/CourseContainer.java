package web.course.course.util;

import web.community.classes.service.ClassService;
import web.community.classes.service.impl.ClassServiceImpl;
import web.course.course.service.CourseService;
import web.course.course.service.impl.CourseServiceImpl;

public class CourseContainer {
    public static final CourseService COURSE_SERVICE = new CourseServiceImpl();

}
