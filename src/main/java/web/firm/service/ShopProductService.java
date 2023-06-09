package web.firm.service;

import java.util.List;

import web.firm.bean.ShopProduct;

public interface ShopProductService {
	
	
	// 查該廠商所有上架商品資料
	List<ShopProduct> selectByProductFirmNo(Integer shopProductFirmNo); 
	
	// 查該廠商所有商品
	List<ShopProduct> selectByFirmNo(Integer firmNo);
	
	
	// 新增商品
	boolean insert(ShopProduct shopProductClass);
	
	
	// 後臺專用(商品管理所有也可使用)
	List<ShopProduct> selectAll(); 
	
	ShopProduct selectByProductId(Integer shopProductId);
	
	
	boolean editProduct(ShopProduct shopProduct);
	
	boolean editProductStatus(ShopProduct shopProduct);
	
	
// 查詢商品狀態
//	List<ShopProduct> selectByProductStatus(Integer shopProductStatus);
	
	
}
