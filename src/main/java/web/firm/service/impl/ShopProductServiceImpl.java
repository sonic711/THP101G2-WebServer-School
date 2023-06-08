package web.firm.service.impl;

import java.util.Base64;
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
		String shopProductImgBase64 = shopProductClass.getShopProductImgBase64();
		if (shopProductImgBase64 != null && !shopProductImgBase64.isEmpty()) {
			byte[] shopProductImg = Base64.getDecoder().decode(shopProductImgBase64);
			shopProductClass.setShopProductImg(shopProductImg);
		}
		
		System.out.println(dao);

		return dao.insert(shopProductClass) >= 1;
	}

	@Override
	public boolean editProduct(ShopProduct shopProduct) {
		String shopProductImgBase64 = shopProduct.getShopProductImgBase64();
		if (shopProductImgBase64 != null && !shopProductImgBase64.isEmpty()) {
			byte[] shopProductImg = Base64.getDecoder().decode(shopProductImgBase64);
			shopProduct.setShopProductImg(shopProductImg);
		}
		
		System.out.println(dao);
		
		return dao.update(shopProduct) >= 1;
	}

	@Override
	public boolean editProductStatus(ShopProduct shopProduct) {
		return dao.updateByProductStatus(shopProduct)>=1;
	}

	@Override
	public ShopProduct selectByProductId(Integer shopProductId) {
		return dao.selectByProductId(shopProductId);
	}

	@Override
	public List<ShopProduct> selectByFirmNo(Integer firmNo) {
		return dao.selectByFirmNo(firmNo);
	}
	



}
