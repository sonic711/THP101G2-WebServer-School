package web.shop.Buy.service;

import java.util.List;
import web.shop.Buy.bean.ShopBuy;

public interface ShopBuyService {
	boolean insert(ShopBuy shopBuy);
	
    List<ShopBuy> selectAll();
    
    boolean update(ShopBuy shopBuy);
    
    boolean delete(Integer id);
    
    boolean updatepoint(ShopBuy shopBuy);

}
