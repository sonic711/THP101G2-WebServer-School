package web.shop.main.dao;

import java.util.List;

import web.shop.main.bean.ShopProduct;

public interface ShopDao {
	
	List<ShopProduct> selectAllByKey(ShopProduct productid);
	
	List<ShopProduct> selectMainProduct(ShopProduct productid);
	
}
