package web.firm.controller.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.ShopContainer.SHOPHOMEPAGE_SERVICE;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/shophomepage/*")
public class ShopHomePageProductOnController extends HttpServlet {

	/**
	 * 賣家首頁
	 * 查該廠商商品狀態為上架中的狀態
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp,SHOPHOMEPAGE_SERVICE.selectAll());
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp,SHOPHOMEPAGE_SERVICE.selectByProductFirmNo(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
}
