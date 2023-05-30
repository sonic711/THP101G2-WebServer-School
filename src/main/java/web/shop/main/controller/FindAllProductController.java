package web.shop.main.controller;

import static core.util.CommonUtil.writeJsonBean;
import static web.shop.main.util.ShopContains.SHOP_SERVICE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/shop/*" })
public class FindAllProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo(); // 获取请求的URL路径信息
		if (pathInfo.equals("/another")) {
			try {
				writeJsonBean(resp, SHOP_SERVICE.selectMainProduct(null));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 默认逻辑，处理原来的逻辑
			try {
				writeJsonBean(resp, SHOP_SERVICE.selectAllByKey(null));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
