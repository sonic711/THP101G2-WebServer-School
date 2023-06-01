package web.member.follow.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.member.follow.bean.Follow;

import static web.member.util.MemberContains.FOLLOW_SERVICE;

import java.io.IOException;
import java.util.List;

@WebServlet("/member/follow/*")
public class FollowController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 查詢該會員所有追蹤對象
     * 測試 
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		Follow follow = new Follow();
		follow.setMemberNo(Integer.parseInt(pathVar[0]));
		List<Follow> list = FOLLOW_SERVICE.findAllByMemberNo(follow.getMemberNo());
		
		resp.getWriter().write(gson.toJson(list));
	}
	
}
