package web.firm.controller;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.FirmClassContainer.FIRMDATAPOST;
import static web.firm.util.FirmContainer.FIRM_SERVICE;

import java.io.IOException;
import java.util.Base64;
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
import web.firm.bean.FirmClass;
import web.firm.bean.ShopProduct;


@WebServlet("/firmData/*")
public class FirmControllerToGrace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
	 * 搜尋所有廠商 測試ok
	 * 透過id搜尋廠商 測試ok
	 */
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp,FIRMDATAPOST.selectAll()) ;
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp,FIRMDATAPOST.selectByFirmNo(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	/**
	 * 更改廠商資料 測試ok
	 */
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			FirmClass firmClass = json2Bean(req, FirmClass.class);
			boolean result = FIRMDATAPOST.editFirm(firmClass);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 回傳廠商資訊 測試ok (韋辰0.0)
	 */
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FirmClass firm = (FirmClass)req.getSession().getAttribute("firm");
		firm.setPassword(null);
		resp.getWriter().write(gson.toJson(firm));
	}
	
	/**
	 * 登出 測試ok (韋辰0.0)
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", true);
		resp.getWriter().write(gson.toJson(respBody));
	}

}
