package web.firm.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.firm.bean.ShopProduct;
import web.member.member.bean.Member;

import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.ShopContainer.FIRMPRODUCTPOSTALL_SERVICE;
import static web.firm.util.ShopContainer.ONPRODUCT_SERVICE;

//查該廠商所有商品
@WebServlet("/productmanageall/*")//*代表可以加任何東西
public class ProductManageController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	Gson gson = new Gson();
	
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
	
	// 尚未
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShopProduct shopProduct = gson.fromJson(req.getReader(), ShopProduct.class);
		boolean result = ONPRODUCT_SERVICE.insert(shopProduct);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "上架成功" : "上架失敗");
		
		resp.getWriter().write(respBody.toString());
	}
}




