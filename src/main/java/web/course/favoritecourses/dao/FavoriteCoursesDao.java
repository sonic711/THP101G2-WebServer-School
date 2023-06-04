package web.course.favoritecourses.dao;

import java.util.List;

import web.course.favoritecourses.bean.FavoriteCourses;
import web.course.studentcourses.bean.StudentCourses;


public interface FavoriteCoursesDao {
	 int insert(FavoriteCourses favoritecourses);
	    List<FavoriteCourses> selectAllByKey(Integer id);
	    List<FavoriteCourses> selectAll();
	    FavoriteCourses selectByKey(Integer id);
	    int deleteByKey(Integer id);
	    int update(FavoriteCourses favoriteCourses);

	
}
