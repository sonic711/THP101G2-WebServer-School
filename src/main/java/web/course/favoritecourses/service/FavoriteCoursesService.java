package web.course.favoritecourses.service;
import java.util.List;

import web.course.favoritecourses.bean.FavoriteCourses;
public interface FavoriteCoursesService {

	 boolean newOneFavoriteCourse(FavoriteCourses favoriteCourses);
	 FavoriteCourses findCourseById(Integer id);
	    List<FavoriteCourses> findAllFavoriteCourse();
	    List<FavoriteCourses> findAllByFavoriteCourseId(Integer id);
	    boolean removeCourseById(Integer id);
	    boolean editPost(FavoriteCourses favoriteCourses);
}
