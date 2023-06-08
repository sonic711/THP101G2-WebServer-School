package web.shop.Buy.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import web.shop.Buy.bean.ShopBuy;
import web.shop.Buy.dao.ShopBuyDao;
import web.shop.Buy.dao.impl.ShopBuyDaoImpl;
import web.shop.Buy.service.ShopBuyService;

public class ShopBuyServiceImpl implements ShopBuyService {
    private ShopBuyDao shopBuyDao;
    private DataSource dataSource;
    
    
    public ShopBuyServiceImpl() {
        this.dataSource = dataSource;
        shopBuyDao = new ShopBuyDaoImpl();
    }

    public boolean insert(ShopBuy shopBuy) {
        int result = shopBuyDao.insert(shopBuy);
		return result > 0;
    }

    public boolean update(ShopBuy shopBuy) {
    	int result = shopBuyDao.update(shopBuy);
        return result > 0;
    }


	public boolean delete(Integer id) {
		int result = shopBuyDao.delete(id);
        return result > 0;
	}

	@Override
	public boolean updatepoint(ShopBuy shopBuy) {
		int result = shopBuyDao.updatepoint(shopBuy);
        return result > 0;
	}
	
	@Override
	public List<ShopBuy> selectAll() {
		return shopBuyDao.selectAll();
	}



}