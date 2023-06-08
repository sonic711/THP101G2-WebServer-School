package web.member.follow.controller;

import static web.member.util.MemberContains.FOLLOW_SERVICE;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

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

@WebServlet("/member/follow/fans/*")
public class FansController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 查詢該會員所有粉絲
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		List<Follower> list = FOLLOW_SERVICE.findAllByMemberFollowing(Integer.parseInt(pathVar[0]));
		
		list.forEach(fan -> {
			String profilePhoto64 = null;
			String coverPicture64 = null;
			if (fan.getProfilePhoto() != null) {
				profilePhoto64 = Base64.getEncoder().encodeToString(fan.getProfilePhoto());
				fan.setProfilePhoto64(profilePhoto64);
				fan.setProfilePhoto(null);
			}
			if (fan.getCoverPicture() != null) {
				coverPicture64 = Base64.getEncoder().encodeToString(fan.getCoverPicture());
				fan.setCoverPicture64(coverPicture64);
				fan.setCoverPicture(null);
			}
			
		});
		
		resp.getWriter().write(gson.toJson(list));
	}
	
	
	/**
     * DELETE 取消追蹤對方(unfollow)
     * 測試 OK
     */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		HttpSession session = req.getSession();
		Member seMember = (Member) session.getAttribute("member");
		
		Follow follow = new Follow();
		follow.setMemberFollowing(Integer.parseInt(pathVar[0]));
		follow.setMemberNo(seMember.getMemberNo());
		boolean result = FOLLOW_SERVICE.unfollow(follow);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "刪除成功" : "刪除失敗");
		System.out.println(respBody.toString());
		resp.getWriter().write(gson.toJson(respBody));
	}
	
}
