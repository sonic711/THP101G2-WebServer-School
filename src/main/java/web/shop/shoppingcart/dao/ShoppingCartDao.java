package web.shop.shoppingcart.dao;

import java.util.List;

import web.shop.shoppingcart.bean.ShoppingCart;

public interface ShoppingCartDao {
	
	int insert(ShoppingCart shoppingcartadd);
	
	int deleteByKey(Integer id);
	
	public List<ShoppingCart> selectAllCartProducts();
	
	List<ShoppingCart> selectCartProduct(Integer id);
}
