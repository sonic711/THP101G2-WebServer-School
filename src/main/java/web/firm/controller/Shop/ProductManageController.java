package web.firm.controller.Shop;

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
import com.google.gson.JsonObject;

import core.bean.CoreBean;
import web.firm.bean.ShopProduct;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static core.util.Constants.GSON;
import static web.firm.util.ShopContainer.FIRMPRODUCTPOSTALL_SERVICE;
import static web.firm.util.ShopContainer.PRODUCT_SERVICE;
//查該廠商所有商品
@WebServlet("/productmanage/*")//*代表可以加任何東西
public class ProductManageController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	Gson gson = new Gson();
	
	/**
	 * 查詢商品
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
	
		List<ShopProduct> list = FIRMPRODUCTPOSTALL_SERVICE.selectByFirmNo(Integer.parseInt(pathVar[0]));
		
		list.forEach(shopProduct -> {
			byte[] shopProductImg = shopProduct.getShopProductImg();
			if (shopProductImg != null && shopProductImg.length != 0) {
				shopProduct.setShopProductImgBase64(Base64.getEncoder().encodeToString(shopProductImg));
			}
//			System.out.println(shopProduct.getShopProductImgBase64());
		});
		resp.getWriter().write(gson.toJson(list));
		
	}
	
	/**
	 * 商品上架
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			ShopProduct shopProduct = json2Bean(req, ShopProduct.class);
			System.out.println(shopProduct);
			Boolean result = PRODUCT_SERVICE.insert(shopProduct);
			writeJsonBean(resp, new CoreBean(true, result.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 編輯商品
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ShopProduct shopProduct = json2Bean(req, ShopProduct.class);
			boolean result = PRODUCT_SERVICE.editProduct(shopProduct);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
}




