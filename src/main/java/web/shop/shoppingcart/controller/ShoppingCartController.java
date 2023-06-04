package web.shop.shoppingcart.controller;

import static core.util.CommonUtil.json2Beans;
import static core.util.CommonUtil.writeJsonBean;
import static web.shop.favorite.util.ShopFavoriteContains.SHOP_FAVORITE_ADD_SERVICE;
import static web.shop.shoppingcart.util.ShoppingCartContains.SHOPPING_CART;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.shop.shoppingcart.bean.ShoppingCart;

@WebServlet(urlPatterns = { "/shop/shoppingcart/*" })
public class ShoppingCartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ShoppingCart shoppingCart = json2Beans(req, ShoppingCart.class);
			System.out.println("ShoppCartaddobject: " + shoppingCart.toString()); // 调试输出
			boolean result = SHOPPING_CART.cartaddproduct(shoppingCart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String pathInfo = req.getPathInfo();
			if (pathInfo != null && pathInfo.length() > 1) {
				String str = pathInfo.substring(1);
				String[] xxx = str.split("/");
				if (xxx.length > 0) {
					Integer id = Integer.parseInt(xxx[0]);
					writeJsonBean(resp, SHOPPING_CART.selectCartProduct(id));
				} else {
					// 查询全部数据的逻辑处理
					writeJsonBean(resp, SHOPPING_CART.selectAllCartProducts());
				}
			} else {
				// 查询全部数据的逻辑处理
				writeJsonBean(resp, SHOPPING_CART.selectAllCartProducts());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	        String pathInfo = req.getPathInfo();

	        try {
	            pathInfo = pathInfo.substring(1);
	            String[] pathVariables = pathInfo.split("/");
	            Integer id = Integer.parseInt(pathVariables[0]);
	            boolean result = SHOPPING_CART.cartdeletproduct(id);
	            writeJsonBean(resp, new CoreBean(result));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


