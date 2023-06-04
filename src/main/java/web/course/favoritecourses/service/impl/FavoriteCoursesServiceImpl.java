package web.course.favoritecourses.service.impl;

import java.util.List;

import web.course.favoritecourses.bean.FavoriteCourses;
import web.course.favoritecourses.dao.FavoriteCoursesDao;
import web.course.favoritecourses.dao.impl.FavoriteCoursesDaoImpl;
import web.course.favoritecourses.service.FavoriteCoursesService;

public class FavoriteCoursesServiceImpl implements FavoriteCoursesService{
private FavoriteCoursesDao dao;

public FavoriteCoursesServiceImpl() {
	dao = new FavoriteCoursesDaoImpl();
}

@Override
public boolean newOneFavoriteCourse(FavoriteCourses favoriteCourses) {
	int result = dao.insert(favoriteCourses);
    return result > 0;
}

@Override
public FavoriteCourses findCourseById(Integer id) {
    return dao.selectByKey(id);

}

@Override
public List<FavoriteCourses> findAllFavoriteCourse() {
	return dao.selectAll();

}

@Override
public List<FavoriteCourses> findAllByFavoriteCourseId(Integer id) {
	return dao.selectAllByKey(id);

}

@Override
public boolean removeCourseById(Integer id) {
	int result = dao.deleteByKey(id);
    return result > 0;
}

@Override
public boolean editPost(FavoriteCourses favoriteCourses) {
	int result = dao.update(favoriteCourses);
    return result > 0;
}


}
