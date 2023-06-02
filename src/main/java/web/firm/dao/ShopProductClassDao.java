package web.firm.dao;

import java.util.List;

import web.firm.bean.ShopProductClass;


// 商品管理Dao
public interface ShopProductClassDao {
	// 查詢該廠商商品
	List<ShopProductClass> selectByProductFirmNo(Integer shopProductFirmNo); 
	
	// 查詢狀態：透過狀態回傳的數字，找到正確的資料
	List<ShopProductClass> selectByProductStatus(Integer shopProductStatus); 
	
	// 新增商品
	int insert(ShopProductClass shopProductClass);
	
	// 更新資料
	int update(ShopProductClass shopProduct);
	
	// 更新狀態
	int updateByProductStatus(ShopProductClass shopProductStatus);
	
	//  刪除(前端隱藏數據)->商品首頁會用到
	int deleteByStatus(Integer shopProductStatusD);
	
	
	// 給後臺專用(呼叫方法就可以拿到全部的資料)
	List<ShopProductClass> selectAll(); 
}
