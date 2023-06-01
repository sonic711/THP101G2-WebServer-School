package web.calendar.tag.dao;

import java.util.List;

import web.calendar.tag.bean.TagColor;

public interface TagColorDao {
	List<TagColor> selectAllTags(); // 查詢所有標籤
	
	TagColor selectTag(Integer tagId);
	
	
}
