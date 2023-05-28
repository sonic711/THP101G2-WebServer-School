package web.shop.main.service.impl;

import java.util.List;

import web.community.post.dao.PostAttDao;
import web.community.post.dao.impl.PostAttDaoImpl;
import web.shop.main.bean.ShopProduct;
import web.shop.main.dao.ShopDao;
import web.shop.main.dao.impl.ShopDaonImpl;
import web.shop.main.service.ShopService;

public class ShopServiceImpl implements ShopService{
	private ShopDao dao;

    public ShopServiceImpl() {
        dao = new ShopDaonImpl();
    }

//	@Override
//	public boolean insert(List<ShopProduct>productFavAdd, Integer id) {
//		// TODO Auto-generated method stub
//		 int result = dao.insert(productFavAdd, id);
//	        return result > 0;
//	}

	@Override
	public List<ShopProduct> selectAllByKey(ShopProduct productid) {
		// TODO Auto-generated method stub
		return dao.selectAllByKey(productid);
	}

	@Override
	public List<ShopProduct> selectMainProduct(ShopProduct productid) {
		// TODO Auto-generated method stub
		return dao.selectMainProduct(productid);
	}

}
