package web.firm.service.impl;

import java.util.List;

import web.firm.bean.ShopProductClass;
import web.firm.dao.ShopProductClassDao;
import web.firm.dao.impl.ShopProductClassDaoImpl;
import web.firm.service.ShopProductClassService;


public class ShopProductClassServiceImpl implements ShopProductClassService {
	
	 private ShopProductClassDao dao;

	    public ShopProductClassServiceImpl() {
	        dao = new ShopProductClassDaoImpl();
	    }
	    
	@Override
	public List<ShopProductClass> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public List<ShopProductClass> selectByProductFirmNo(Integer shopProductFirmNo) {
		return dao.selectByProductFirmNo(shopProductFirmNo);
	}
	
	@Override
	public List<ShopProductClass> selectByProductStatus(Integer shopProductStatus) {
		return dao.selectByProductStatus(shopProductStatus);
	}
	
	@Override
	public int insert(ShopProductClass shopProductClass) {
		// TODO Auto-generated method stub
		return 0;
	}
	



}
