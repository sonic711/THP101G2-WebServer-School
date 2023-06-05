package web.course.chapter.service;

import java.util.List;

import web.course.chapter.bean.Chapter;
import web.course.course.bean.Course;

public interface ChapterService {
	boolean newOneChapter(Chapter chapter);
    Chapter findChapterById(Integer id);
    boolean editPost(Chapter chapter);
    List<Chapter> findAllChapter();
    List<Chapter> findAllByChapterId(Integer id);
    boolean removeChapterById(Integer id);

}
