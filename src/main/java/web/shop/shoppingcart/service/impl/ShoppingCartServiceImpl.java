package web.shop.shoppingcart.service.impl;

import java.util.List;


import web.shop.shoppingcart.bean.ShoppingCart;
import web.shop.shoppingcart.dao.ShoppingCartDao;
import web.shop.shoppingcart.dao.impl.ShoppingCartDaoImpl;
import web.shop.shoppingcart.service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService{
	private ShoppingCartDao dao;

	public ShoppingCartServiceImpl() {
		dao = new ShoppingCartDaoImpl();
		}

	@Override
	public boolean cartaddproduct(ShoppingCart shoppingcartadd) {
		// TODO Auto-generated method stub
		int result = dao.insert(shoppingcartadd);
		return result > 0;
	}

	@Override
	public boolean cartdeletproduct(Integer id) {
		int result = dao.deleteByKey(id);
        return result > 0;
	}

	@Override
	public List<ShoppingCart> selectAllCartProducts() {
		// TODO Auto-generated method stub
		return dao. selectAllCartProducts();
	}

	@Override
	public List<ShoppingCart> selectCartProduct(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectCartProduct(id);
	}

	@Override
	public List<ShoppingCart> selectPoint(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectPoint(id);
	}

}
