package web.manage.manageaccount.controller;

import static web.manage.util.ManageContains.MANAGE_ACCOUNT_SERVICE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.manage.manageaccount.bean.Manageaccount;

@WebServlet("/managers/*")
public class ManageAccountController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 登入: 查詢有無此管理員
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		Manageaccount manager = new Manageaccount();
		manager.setManageAc(Integer.parseInt(pathVar[0]));
		manager.setManagePass(Integer.parseInt(pathVar[1]));
		manager = MANAGE_ACCOUNT_SERVICE.login(manager);
		
		if (manager != null) {
			if (req.getSession(false) != null) {
				req.changeSessionId();
			}
			req.getSession().setAttribute("manager", manager);
		}
		
		resp.getWriter().write(gson.toJson(manager));
	}
	
	/**
     * OPTIONS: 回傳當前的管理員資料
     * 測試 OK
     */
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Manageaccount manager = (Manageaccount)req.getSession().getAttribute("manager");
		manager.setManagePass(null);
		resp.getWriter().write(gson.toJson(manager));
		System.out.println(manager);
	}
}
