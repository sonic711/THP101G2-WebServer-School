package web.point.dao;

import java.util.List;

import web.point.bean.PointChanged;

public interface pointChangedDao {
	// 新增一筆資料(課程完成率相關)
	int insertForSC();
	// 新增一筆資料(評分相關)
	int insertForCMT();
	//新增一筆資料(登入相關)
	int insertForMLR();
	//新增一筆資料(積分折抵相關)
	int insertForSO();
	
	
	// 以會員編號查詢多筆資料
	List<PointChanged> selectAllByMId (Integer id);
	
	
	
}
