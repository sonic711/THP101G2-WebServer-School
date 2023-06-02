package web.firm.dao;

import java.util.List;

import web.firm.bean.FirmOrder;


public interface FirmOrderDao {
	
	// 查廠商訂單狀態
	List<FirmOrder> selectByFirmNo(Integer firmNo);
	
	
	// 後端查全部
	List<FirmOrder> selectAll(); 
	
	

}
