package web.firm.util;


import web.firm.service.ShopProductClassService;
import web.firm.service.impl.ShopProductClassServiceImpl;

public class ShopContainer {

	 public static final ShopProductClassService FIRMPRODUCTPOSTALL_SERVICE = new ShopProductClassServiceImpl();
	 
	 public static final ShopProductClassService SHOPHOMEPAGE_SERVICE = new ShopProductClassServiceImpl();
	 
	 public static final ShopProductClassService ALLPRODUCT_SERVICE = new ShopProductClassServiceImpl();
}
