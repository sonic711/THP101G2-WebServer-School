package web.firm.util;


import web.firm.service.ShopProductService;
import web.firm.service.impl.ShopProductServiceImpl;

public class ShopContainer {

	 public static final ShopProductService FIRMPRODUCTPOSTALL_SERVICE = new ShopProductServiceImpl();
	 
	 public static final ShopProductService SHOPHOMEPAGE_SERVICE = new ShopProductServiceImpl();
	 
	 public static final ShopProductService ALLPRODUCT_SERVICE = new ShopProductServiceImpl();
	 
	 public static final ShopProductService ONPRODUCT_SERVICE = new ShopProductServiceImpl();
}
