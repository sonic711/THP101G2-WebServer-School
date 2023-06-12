package web.member.member.controller;

import static web.member.util.MemberContains.MEMBER_SERVICE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.member.member.bean.Member;

@WebServlet("/member/forgetPassword/*")
public class MemberForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 查詢此會員
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		Member member = MEMBER_SERVICE.searchMember(pathVar[0]);
		System.out.println(member);
		if (member != null) {
			resp.getWriter().write(gson.toJson(member));
		} else {
			System.out.println("member is null");
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = gson.fromJson(req.getReader(), Member.class);
		
		boolean result = MEMBER_SERVICE.editMember(member);
		Member newMember = MEMBER_SERVICE.searchMember(member.getMemberEmail());
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "編輯成功" : "編輯失敗");
		
		resp.getWriter().write(respBody.toString());
	}

	
}
