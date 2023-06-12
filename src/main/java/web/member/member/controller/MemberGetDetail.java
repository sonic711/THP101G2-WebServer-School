package web.member.member.controller;

import static web.member.util.MemberContains.MEMBER_SERVICE;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.member.member.bean.Member;
import static web.member.util.MemberContains.MEMBER_SERVICE;


@WebServlet("/member/getDetail/*")
public class MemberGetDetail extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 查詢此會員密碼
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		System.out.println(pathVar[0]);
		
		String password = MEMBER_SERVICE.getPW(pathVar[0]);
		
		resp.getWriter().write(gson.toJson(password));
	}
	
	/**
     * POST 登入
     * 測試 OK
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = gson.fromJson(req.getReader(), Member.class);
		System.out.println(member);
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
}
