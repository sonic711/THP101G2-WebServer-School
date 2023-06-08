package web.shop.Buy.controller;

import java.io.IOException;
import java.util.Base64;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.json2Beans;
import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.POSTATT_SERVICE;
import static web.shop.Buy.util.ShopBuyContains.SHOP_BUY;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.community.post.bean.PostAtt;
import web.shop.Buy.bean.ShopBuy;

@WebServlet(urlPatterns = { "/shop/buy/*" })
public class ShopBuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ShopBuy shopBuy = json2Beans(req, ShopBuy.class);
			System.out.println("ShopBuy object: " + shopBuy.toString()); // 调试输出
			boolean result = SHOP_BUY.insert(shopBuy);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
			writeJsonBean(resp, SHOP_BUY.selectAll());
			
		}
		

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		try {
			pathInfo = pathInfo.substring(1);
			String[] pathVariables = pathInfo.split("/");
			Integer id = Integer.parseInt(pathVariables[0]);
			boolean result = SHOP_BUY.delete(id);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo(); // 获取请求的URL路径信息
		if (pathInfo.equals("/point")) { 
		try {
	            ShopBuy shopbuy = json2Bean(req, ShopBuy.class);
	            boolean result = SHOP_BUY.updatepoint(shopbuy);
	            writeJsonBean(resp, new CoreBean(result));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}else {
		try {
		 ShopBuy shopbuy = json2Bean(req, ShopBuy.class);
         boolean result = SHOP_BUY.update(shopbuy);
         writeJsonBean(resp, new CoreBean(result));
     } catch (Exception e) {
         e.printStackTrace();
     }
     }
		
	}
}


