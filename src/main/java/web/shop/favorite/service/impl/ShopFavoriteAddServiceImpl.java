package web.shop.favorite.service.impl;

import java.util.List;

import web.shop.favorite.bean.ShopFavoriteAdd;
import web.shop.favorite.dao.ShopFavoriteAddDao;
import web.shop.favorite.dao.impl.ShopFavoriteAddDaoImpl;
import web.shop.favorite.service.ShopFavoriteAddService;

public class ShopFavoriteAddServiceImpl implements ShopFavoriteAddService {
	private ShopFavoriteAddDao dao;

	public ShopFavoriteAddServiceImpl() {
		dao = new ShopFavoriteAddDaoImpl();
	}

	@Override
	public boolean favaddproduct(ShopFavoriteAdd shopfavoriteadd) {
		// TODO Auto-generated method stub
		int result = dao.insert(shopfavoriteadd);
		return result > 0;
	}

	@Override
	public List<ShopFavoriteAdd> selectFavoriteProduct(Integer favoriteproductid) {
		// TODO Auto-generated method stub
		return dao.selectFavoriteProduct(favoriteproductid);
	}

	@Override
	public List<ShopFavoriteAdd> selectAllFavoriteProducts() {
		// TODO Auto-generated method stub
		return dao. selectAllFavoriteProducts();
	}


}
