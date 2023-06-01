package web.firm.service;

import java.util.List;

import web.firm.bean.FirmClass;

public interface FirmClassService {
	//新增賣場資料
	int insert(FirmClass firmClass);
	
	//更改賣場資料
	int update(FirmClass firmClass);
	
	FirmClass selectByUserId(String userId);
	
	List<FirmClass> selectAll();
}
