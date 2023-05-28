package web.firm.dao;

import java.util.List;

import web.firm.bean.FirmOrder;


public interface FirmOrderDao {
	
	// 查訂單狀態
	List<FirmOrder> selectByOrderStatus(Integer shopOrderStatus);
	
	
	// 後端查全部
	List<FirmOrder> selectAll(); 
	
	

}
