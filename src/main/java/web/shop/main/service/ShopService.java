package web.shop.main.service;

import java.util.List;

import web.shop.main.bean.ShopProduct;

public interface ShopService {
	
//	boolean insert(List<ShopProduct> productFavAdd, Integer id);
	
	List<ShopProduct> selectAllByKey(ShopProduct productid);
	
	List<ShopProduct> selectMainProduct(ShopProduct productid);
	
	
	
}
