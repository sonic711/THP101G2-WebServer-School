package web.firm.dao;

import java.util.List;

import web.firm.bean.FirmClass;

public interface FirmDaoToGrace {
	
	FirmClass selectByFirmNo(Integer FirmNo);
	

	//新增賣場資料
	int insert(FirmClass firmClass);
	
	//更改賣場資料
	int update(FirmClass firmClass);
	
	// 登入用
	FirmClass selectByEmailAndPassword(String email, String password);
	
	// 查詢某廠商
	FirmClass selectByEmail(String email);
	
	// 查詢所有廠商
	List<FirmClass> selectAll();
	
	// 
	FirmClass selectByUserId(String userId);
	
	FirmClass selectByPhone(String phone);
}
