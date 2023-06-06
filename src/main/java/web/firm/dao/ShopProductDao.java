package web.firm.dao;

import java.util.List;

import web.firm.bean.ShopProduct;


// 商品管理Dao
public interface ShopProductDao {
	
	// 查詢該廠商所有商品
	List<ShopProduct> selectByProductFirmNo(Integer shopProductFirmNo); 
	
	// 查詢狀態：透過狀態回傳的數字，找到正確的資料
	List<ShopProduct> selectByProductStatus(Integer shopProductStatus); 
	
	// 新增商品
	int insert(ShopProduct shopProductClass);
	
	// 更新資料
	int update(ShopProduct shopProduct);
	
	// 更新狀態
	int updateByProductStatus(ShopProduct shopProductStatus);
	
	
	
	// 給後臺專用(呼叫方法就可以拿到全部的資料)
	List<ShopProduct> selectAll(); 
}
