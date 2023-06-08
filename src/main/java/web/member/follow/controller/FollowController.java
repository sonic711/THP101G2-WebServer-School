package web.member.follow.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.member.follow.bean.Follow;
import web.member.follow.bean.Follower;
import web.member.member.bean.Member;

import static web.member.util.MemberContains.FOLLOW_SERVICE;

import java.io.IOException;
import java.util.List;

@WebServlet("/member/follow/followers/*")
public class FollowController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 查詢該會員所有追蹤對象
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");

		List<Follower> list = FOLLOW_SERVICE.findAllByMemberNo(Integer.parseInt(pathVar[0]));
		
		resp.getWriter().write(gson.toJson(list));
	}
	
	/**
     * POST 新增追蹤
     * 測試 OK
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = gson.fromJson(req.getReader(), Member.class);
		Follow follow = new Follow();
		HttpSession session = req.getSession();
		Member seMember = (Member) session.getAttribute("member");
		follow.setMemberNo(seMember.getMemberNo());
		follow.setMemberFollowing(member.getMemberNo());
		
		boolean result = FOLLOW_SERVICE.add(follow);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "新增成功" : "新增失敗");
		
		resp.getWriter().write(gson.toJson(respBody));
	}
	
	/**
     * DELETE 刪除對方的追蹤
     * 測試 OK
     */
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
	
	/**
     * OPTIONS 查詢互追列表
     * 測試 
     */
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Member seMember = (Member) session.getAttribute("member");
		List<Follower> list = FOLLOW_SERVICE.FollowBackList(seMember.getMemberNo());
		resp.getWriter().write(gson.toJson(list));
;	}
	
}
