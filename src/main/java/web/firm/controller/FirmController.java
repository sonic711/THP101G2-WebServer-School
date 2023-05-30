package web.firm.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.firm.bean.FirmClass;

import static web.firm.util.FirmContainer.FIRM_SERVICE;

import java.io.IOException;

@WebServlet("/firms/*")
public class FirmController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 登入: 查詢有無此會員
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		FirmClass firm = new FirmClass();
		firm.setFirmEmail(pathVar[0]);
		firm.setPassword(pathVar[1]);
		firm = FIRM_SERVICE.login(firm);
		
		if (firm != null) {
			if (req.getSession(false) != null) {
				req.changeSessionId();
			}
			req.getSession().setAttribute("firm", firm);
		}
		
		resp.getWriter().write(gson.toJson(firm));
	}
	
	/**
     * POST 註冊: 新增一筆會員資料
     * 測試 
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FirmClass firm = gson.fromJson(req.getReader(), FirmClass.class);
		
		boolean result = FIRM_SERVICE.register(firm);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "註冊成功" : "註冊失敗");
		
		resp.getWriter().write(respBody.toString());
	}
	
	/**
     * OPTIONS: 回傳當前的會員資料
     * 測試 OK
     */
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FirmClass firm = (FirmClass)req.getSession().getAttribute("firm");
		firm.setPassword(null);
		resp.getWriter().write(gson.toJson(firm));
	}
	
	/**
     * DELETE: 登出
     * 測試 OK
     */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", true);
		resp.getWriter().write(gson.toJson(respBody));
	}
}
