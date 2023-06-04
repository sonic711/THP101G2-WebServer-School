package web.member.follow.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import web.member.follow.bean.Follow;
import web.member.follow.bean.Followers;

import static web.member.util.MemberContains.FOLLOW_SERVICE;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet("/member/follow/followers/*")
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
		
		Followers followers = new Followers();
		followers.setMemberNo(Integer.parseInt(pathVar[0]));
		List<Followers> list = FOLLOW_SERVICE.findAllByMemberNo(followers.getMemberNo());
		
		Type listType = new TypeToken<List<Followers>>() {}.getType();
		String jsonList = gson.toJson(list, listType);
		resp.getWriter().write(gson.toJson(jsonList));
	}
	
}
