package web.firm.service;

import java.util.List;

import web.firm.bean.FirmClass;

public interface FirmService {
	
	// 註冊
	boolean register(FirmClass firm);
	
	// 登入
	FirmClass login(FirmClass firm);
	
	// 查詢所有廠商
	List<FirmClass> findAll();
}
