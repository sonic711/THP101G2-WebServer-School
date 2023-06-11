package web.shop.favorite.controller;

import static core.util.CommonUtil.json2Beans;
import static core.util.CommonUtil.writeJsonBean;
import static web.shop.favorite.util.ShopFavoriteContains.SHOP_FAVORITE_ADD_SERVICE;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.shop.favorite.bean.ShopFavoriteAdd;

@WebServlet(urlPatterns = { "/shop/favorite/*" })
public class ShopFavoriteAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ShopFavoriteAdd shopfavoriteadd = json2Beans(req, ShopFavoriteAdd.class);
			System.out.println("ShopFavoriteAdd object: " + shopfavoriteadd.toString()); // 调试输出
			boolean result = SHOP_FAVORITE_ADD_SERVICE.favaddproduct(shopfavoriteadd);
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
					writeJsonBean(resp, SHOP_FAVORITE_ADD_SERVICE.selectFavoriteProduct(id));
				} else {
					// 查询全部数据的逻辑处理
					writeJsonBean(resp, SHOP_FAVORITE_ADD_SERVICE.selectAllFavoriteProducts());
				}
			} else {
				// 查询全部数据的逻辑处理
				writeJsonBean(resp, SHOP_FAVORITE_ADD_SERVICE.selectAllFavoriteProducts());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();

        try {
        	  if (pathInfo != null && pathInfo.length() > 1) {
                  pathInfo = pathInfo.substring(1);
                  String[] pathVariables = pathInfo.split("/");
                  Integer id = Integer.parseInt(pathVariables[0]);
                  boolean result = SHOP_FAVORITE_ADD_SERVICE.favdeletproduct(id);
                  writeJsonBean(resp, new CoreBean(result));
              } else {
            	  return;
              }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}