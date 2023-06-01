package web.shop.favorite.dao;

import java.util.List;


import web.shop.favorite.bean.ShopFavoriteAdd;

public interface ShopFavoriteAddDao {

	int insert(ShopFavoriteAdd shopfavoriteadd);
	
	int deleteByKey(Integer id);
	
	public List<ShopFavoriteAdd> selectAllFavoriteProducts();
	
	List<ShopFavoriteAdd> selectFavoriteProduct(Integer favoriteproductid);
	
	
}
