package web.firm.controller.Shop;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.ShopContainer.PRODUCTSTATUS_SERVICE;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.firm.bean.ShopProduct;

@WebServlet("/productstatus/*")
public class ProductStatusController extends HttpServlet{
	
	
	/**
	 * 商品下架 測試ok
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ShopProduct shopProduct = json2Bean(req, ShopProduct.class);
			boolean result = PRODUCTSTATUS_SERVICE.editProductStatus(shopProduct);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 回傳商品資料 
	 */
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
	            ShopProduct shopProduct = json2Bean(req, ShopProduct.class);
	            ShopProduct result = PRODUCTSTATUS_SERVICE.selectByProductId(shopProduct.getShopProductId());
	            writeJsonBean(resp, result);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
