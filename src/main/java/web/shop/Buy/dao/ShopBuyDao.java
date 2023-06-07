package web.shop.Buy.dao;

import java.util.List;

import web.shop.Buy.bean.ShopBuy;

public interface ShopBuyDao {
	
	int insert(ShopBuy shopBuy);
	
	List<ShopBuy> selectAll();
	
	int update(ShopBuy shopBuy);
	
	int delete(Integer id);
	
	int updatepoint(ShopBuy shopBuy);

}
