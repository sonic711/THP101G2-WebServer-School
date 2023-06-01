package web.firm.service;

import java.util.List;

import web.firm.bean.FirmOrder;

public interface FirmOrderService {
	
	// 查各廠商訂單狀態
	List<FirmOrder> selectByFirmNo(Integer firmNo);		
		
	// 後端查全部
	List<FirmOrder> selectAll(); 

}
