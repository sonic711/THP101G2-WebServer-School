package web.calendar.tag.service;

import java.util.List;

import web.calendar.tag.bean.TagUserDefined;

public interface TagUserDefService {

	boolean add(TagUserDefined tud); // 新增
	
	boolean edit(TagUserDefined tud); // 修改
	
	boolean delete(TagUserDefined tud); // 刪除
	
	List<TagUserDefined> findAllByMemberNo(Integer memberNo); // 查詢單一會員的自定義標籤
	
	List<TagUserDefined> findAll(); // 查詢全部(後台)
}
