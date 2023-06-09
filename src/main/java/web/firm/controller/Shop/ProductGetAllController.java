package web.firm.controller.Shop;

import static core.util.CommonUtil.writeJsonBean;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static web.firm.util.ShopContainer.ALLPRODUCT_SERVICE;

public class ProductGetAllController {

	/**
	 * 查詢所有商品
	 * 查詢該廠商商品
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp,ALLPRODUCT_SERVICE.selectAll());
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp,ALLPRODUCT_SERVICE.selectByFirmNo(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

}
