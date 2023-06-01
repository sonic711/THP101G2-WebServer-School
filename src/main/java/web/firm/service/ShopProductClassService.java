package web.firm.service;

import java.util.List;

import web.firm.bean.ShopProductClass;

public interface ShopProductClassService {
	// 後臺專用(商品管理所有也可使用)
	List<ShopProductClass> selectAll(); 
	
	// 查該廠商所有資料
	List<ShopProductClass> selectByProductFirmNo(Integer shopProductFirmNo); 
	
	// 新增商品
	int insert(ShopProductClass shopProductClass);
	
	
	// 查詢商品狀態
	List<ShopProductClass> selectByProductStatus(Integer shopProductStatus);
	
	
}
