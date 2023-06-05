package web.member.follow.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import web.member.follow.bean.Follow;
import web.member.follow.bean.Follower;

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
		
		Follower follower = new Follower();
		follower.setMemberNo(Integer.parseInt(pathVar[0]));
		List<Follower> list = FOLLOW_SERVICE.findAllByMemberNo(follower.getMemberNo());
		
		resp.getWriter().write(gson.toJson(list));
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		Follow follow = new Follow();
		follow.setMemberFollowingId(Integer.parseInt(pathVar[0]));
		boolean result = FOLLOW_SERVICE.delete(follow);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "刪除成功" : "刪除失敗");
		
		resp.getWriter().write(respBody.toString());
	}
	
}
