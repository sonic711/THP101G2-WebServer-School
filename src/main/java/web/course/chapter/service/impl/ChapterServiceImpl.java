package web.course.chapter.service.impl;

import java.util.List;

import web.course.chapter.bean.Chapter;
import web.course.chapter.dao.ChapterDao;
import web.course.chapter.dao.impl.ChapterDaoImpl;
import web.course.chapter.service.ChapterService;

public class ChapterServiceImpl implements ChapterService{
	 private ChapterDao dao;
	 
	 public ChapterServiceImpl() {
		 dao = new ChapterDaoImpl();
	 }

	@Override
	public boolean newOneChapter(Chapter chapter) {
		int result = dao.insert(chapter);
        return result > 0;
	}

	@Override
	public Chapter findChapterById(Integer id) {
		return (Chapter) dao.selectByKey(id);
	}

	@Override
	public boolean editPost(Chapter chapter) {
		int result = dao.update(chapter);
        return result > 0;
	}

	@Override
	public List<Chapter> findAllChapter() {
		return dao.selectAll();
	}

	@Override
	public List<Chapter> findAllByChapterId(Integer id) {
		return dao.selectAllByKey(id);
	}

	@Override
	public boolean removeChapterById(Integer id) {
		int result = dao.deleteByKey(id);
        return result > 0;
	}





}
