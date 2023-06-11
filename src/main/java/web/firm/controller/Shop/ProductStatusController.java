package web.firm.controller.Shop;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.ShopContainer.PRODUCT_SERVICE;
import static web.firm.util.ShopContainer.SHOPHOMEPAGE_SERVICE;
import static web.firm.util.ShopContainer.PRODUCTSTATUS_SERVICE;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import core.bean.CoreBean;
import web.firm.bean.ShopProduct;

@WebServlet("/productstatus/*")
public class ProductStatusController extends HttpServlet{
	Gson gson = new Gson();
	
	/**
	 * 查詢單一產品資料
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		ShopProduct result = PRODUCT_SERVICE.selectByProductId(Integer.parseInt(pathVar[0]));
		
		if (result != null) {
			if (req.getSession(false) != null) {
				req.changeSessionId();
			}
			req.getSession().setAttribute("shopProduct", result);
		}
		
		String shopProductImgBase64 = null;
		if (result.getShopProductImg() != null) {
			shopProductImgBase64 = Base64.getEncoder().encodeToString(result.getShopProductImg());
		}

		
		result.setShopProductImgBase64(shopProductImgBase64);
		resp.getWriter().write(gson.toJson(result));
	}
	
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
		ShopProduct shopProduct = (ShopProduct)req.getSession().getAttribute("shopProduct");
		resp.getWriter().write(gson.toJson(shopProduct));
		System.out.println("shopProductID:"+ shopProduct);
	}

}
