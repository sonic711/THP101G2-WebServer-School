package web.calendar.tag.dao;

import java.util.List;

import web.calendar.tag.bean.TagUserDefined;

public interface TagUserDefDao {
	
	List<TagUserDefined> selectAll(); // 查詢所有會員的所有自定義標籤
	
	List<TagUserDefined> selectByMemberNo(Integer memberNo); //查詢某會員的所有自定義標籤
	
	int insert(TagUserDefined tud); // 新增一筆自定義標籤
	
	int update(TagUserDefined tud); // 更新一筆自定義標籤
	
	int deleteById(Integer tudId); // 刪除一筆自定義標籤
	
	TagUserDefined selectByDefined(Integer tudId); // 查詢單筆自定義標籤
	
}
