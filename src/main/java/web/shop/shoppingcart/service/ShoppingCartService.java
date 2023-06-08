package web.shop.shoppingcart.service;

import java.util.List;


import web.shop.shoppingcart.bean.ShoppingCart;

public interface ShoppingCartService {
	boolean cartaddproduct(ShoppingCart shoppingcartadd);
	
	boolean cartdeletproduct(Integer id);
	
	List<ShoppingCart> selectAllCartProducts();
	
	List<ShoppingCart> selectCartProduct(Integer id);
	
	List<ShoppingCart> selectPoint();

}
