package web.course.chapter.dao;

import java.util.List;

import web.course.chapter.bean.Chapter;
import web.course.course.bean.Course;

public interface ChapterDao {
	  int insert(Chapter chapter);
	    int update(Chapter chapter);
	    List<Chapter> selectAllByKey(Integer id);
	    List<Chapter> selectAll();
	    Chapter selectByKey(Integer id);
	    int deleteByKey(Integer id);

}
