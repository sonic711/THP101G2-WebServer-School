package web.firm.service;

import java.util.List;

import web.firm.bean.FirmOrder;

public interface FirmOrderService {
	
	// 查訂單狀態
	List<FirmOrder> selectByOrderStatus(Integer orderStatus);
		
		
	// 後端查全部
	List<FirmOrder> selectAll(); 

}
