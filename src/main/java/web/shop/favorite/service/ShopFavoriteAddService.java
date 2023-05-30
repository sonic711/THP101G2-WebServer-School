package web.shop.favorite.service;

import java.util.List;


import web.shop.favorite.bean.ShopFavoriteAdd;

public interface ShopFavoriteAddService {
	boolean favaddproduct(ShopFavoriteAdd shopfavoriteadd);
	
	boolean favdeletproduct(Integer id);
	
	List<ShopFavoriteAdd> selectAllFavoriteProducts();
	
	List<ShopFavoriteAdd> selectFavoriteProduct(Integer favoriteproductid);
}