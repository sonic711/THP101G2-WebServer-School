package web.firm.dao;

import java.util.List;

import web.firm.bean.DataCenter;

public interface DataCenterDao {
	
	//查廠商銷售數據
	List<DataCenter> selectByFirmNo(Integer firmNo);
	
	//後臺抓數據
	List<DataCenter> selectAll(); 

}
