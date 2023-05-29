package web.point.dao;

import java.util.List;

import web.point.bean.memberLoginRecord;

public interface memberLoginRecordDao {
	// 新增一筆登入紀錄
	int insert(memberLoginRecord mLR);
	// 查詢該MEMBER_NO的所有登入紀錄
	List<memberLoginRecord> selectAllbyMNo(Integer MNo);
	
}
