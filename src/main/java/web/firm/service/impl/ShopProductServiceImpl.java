package web.firm.service.impl;

import java.util.List;

import web.firm.bean.ShopProduct;
import web.firm.dao.ShopProductDao;
import web.firm.dao.impl.ShopProductDaoImpl;
import web.firm.service.ShopProductService;


public class ShopProductServiceImpl implements ShopProductService {
	
	private ShopProductDao dao;

	public ShopProductServiceImpl() {
	    dao = new ShopProductDaoImpl();
	}
	    
	@Override
	public List<ShopProduct> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public List<ShopProduct> selectByProductFirmNo(Integer shopProductFirmNo) {
		return dao.selectByProductFirmNo(shopProductFirmNo);
	}

	
	@Override
	public boolean insert(ShopProduct shopProductClass) {
		/**
		 * 商品名稱不可以超過20字
		 */
		String ShopProductName = shopProductClass.getShopProductName();
		if(ShopProductName.length() > 20) {
			return false;
		}
			
		return dao.insert(shopProductClass) >= 1;
	}
	



}
