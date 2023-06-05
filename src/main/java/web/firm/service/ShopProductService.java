package web.firm.service;

import java.util.List;

import web.firm.bean.ShopProduct;

public interface ShopProductService {
	
	
	// 查該廠商所有資料
	List<ShopProduct> selectByProductFirmNo(Integer shopProductFirmNo); 
	
	
	// 新增商品
	boolean insert(ShopProduct shopProductClass);
	
	
	// 後臺專用(商品管理所有也可使用)
	List<ShopProduct> selectAll(); 
	
	
	
	
// 查詢商品狀態
//	List<ShopProduct> selectByProductStatus(Integer shopProductStatus);
	
	
}
