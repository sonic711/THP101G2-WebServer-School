package web.firm.dao;

import web.firm.bean.FirmClass;

public interface FirmClassDao {
	
	//新增賣場資料
	int insert(FirmClass firmClass);
	
	//更改賣場資料
	int update(FirmClass firmClass);

}
