package web.member.member.controller;

import static web.member.util.MemberContains.MEMBER_SERVICE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/member/forgetPassword/*")
public class MemberForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 查詢此會員手機
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		System.out.println(pathVar[0]);
		
		String phone = MEMBER_SERVICE.getPhone(pathVar[0]);
		System.out.println(phone);
		resp.getWriter().write(gson.toJson(phone));
	}
}
