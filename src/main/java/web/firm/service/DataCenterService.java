package web.firm.service;

import java.util.List;

import web.firm.bean.DataCenter;

public interface DataCenterService {
	

	//查廠商銷售數據
	List<DataCenter> selectByFirmNo(Integer firmNo);
	
	//後臺抓數據
	List<DataCenter> selectAll(); 
	
}
