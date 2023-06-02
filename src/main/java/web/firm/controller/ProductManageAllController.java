package web.firm.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.ShopContainer.FIRMPRODUCTPOSTALL_SERVICE;


//查該廠商所有商品
@WebServlet("/productmanageall/*")//*代表可以加任何東西
public class ProductManageAllController extends HttpServlet{
	
	// doGET查詢
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp,FIRMPRODUCTPOSTALL_SERVICE.selectAll()) ;
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp,FIRMPRODUCTPOSTALL_SERVICE.selectByProductFirmNo(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
}
