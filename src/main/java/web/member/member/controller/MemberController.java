package web.member.member.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.member.member.bean.Member;
import web.member.member.service.MemberService;
import web.member.member.service.impl.MemberServiceImpl;

import static web.member.util.MemberContains.MEMBER_SERVICE;

import java.io.IOException;
import java.util.Base64;
import java.util.List;;

@WebServlet("/members/*")
public class MemberController extends HttpServlet{
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
		
		Member member = new Member();
		member.setMemberEmail(pathVar[0]);
		member.setPassword(pathVar[1]);
		member = MEMBER_SERVICE.login(member);
		
		if (member != null) {
			if (req.getSession(false) != null) {
				req.changeSessionId();
			}
			String profilePhoto64 = null;
			String coverPicture64 = null;
			if (member.getProfilePhoto() != null) {
				profilePhoto64 = Base64.getEncoder().encodeToString(member.getProfilePhoto());
			}
			if (member.getCoverPicture() != null) {
				coverPicture64 = Base64.getEncoder().encodeToString(member.getCoverPicture());
			}
			
			member.setProfilePhoto64(profilePhoto64);
			member.setCoverPicture64(coverPicture64);
			req.getSession().setAttribute("member", member);
		}
		
		resp.getWriter().write(gson.toJson(member));
	}
	
	/**
     * POST 註冊: 新增一筆會員資料
     * 測試 OK
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = gson.fromJson(req.getReader(), Member.class);
		
		boolean result = MEMBER_SERVICE.register(member);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "註冊成功" : "註冊失敗");
		
		resp.getWriter().write(respBody.toString());
	}
	
	/**
     * PUT 編輯: 編輯一筆會員資料
     * 測試 OK
     */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = gson.fromJson(req.getReader(), Member.class);
		HttpSession session = req.getSession();
		Member seMember = (Member) session.getAttribute("member");
		member.setMemberNo(seMember.getMemberNo());
		
		boolean result = MEMBER_SERVICE.editMember(member);
		Member newMember = MEMBER_SERVICE.searchMember(seMember.getMemberEmail());
		System.out.println(newMember);
		req.getSession().setAttribute("member", member);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "編輯成功" : "編輯失敗");
		
		resp.getWriter().write(respBody.toString());
	}
	
	/**
     * OPTIONS: 回傳當前的會員資料
     * 測試 OK
     */
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = (Member)req.getSession().getAttribute("member");
//		member.setPassword(null);
		resp.getWriter().write(gson.toJson(member));
		System.out.println(member);
	}
	
	/**
     * DELETE: 登出
     * 測試 
     */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", true);
		resp.getWriter().write(gson.toJson(respBody));
	}
	
}
