package web.point.dao;

import java.util.List;

import web.point.bean.PointChanged;

public interface pointChangedDao {
	// 新增一筆資料
	int insert(PointChanged pointchanged);
	// 查詢一筆資料
	List<PointChanged> selectAll (Integer id);
	
	
	
	
	
	
}
