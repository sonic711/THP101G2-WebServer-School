package web.member.follow.controller;

import static web.member.util.MemberContains.FOLLOW_SERVICE;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.member.follow.bean.Followers;
import static web.member.util.MemberContains.FOLLOW_SERVICE;

@WebServlet("/member/follow/fans/*")
public class FansController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 查詢該會員所有粉絲
     * 測試 
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		Followers fans = new Followers();
		fans.setMemberFollowing(Integer.parseInt(pathVar[0]));
		List<Followers> list = FOLLOW_SERVICE.findAllByMemberFollowing(fans.getMemberFollowing());
		
		resp.getWriter().write(gson.toJson(list));
	}
}
