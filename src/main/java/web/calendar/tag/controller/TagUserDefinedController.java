package web.calendar.tag.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.calendar.tag.bean.TagUserDefined;
import web.member.member.bean.Member;

import static web.calendar.util.CalendarContains.USERTAG_SERVICE;

@WebServlet("/calendar/userTag/*")
public class TagUserDefinedController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET 查詢某會員所有自定義標籤
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		TagUserDefined tud = new TagUserDefined();
		Integer memberNo = Integer.parseInt(pathVar[0]);
		tud.setMemberNo(memberNo);
		List<TagUserDefined> list = USERTAG_SERVICE.findAllByMemberNo(memberNo);
		
		resp.getWriter().write(gson.toJson(list));
	}
	
	/**
     * POST 新增全部自定義標籤給某會員
     * 測試 OK
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Member seMember = (Member)session.getAttribute("member");
		Integer memberNo = seMember.getMemberNo();
		
		boolean result = USERTAG_SERVICE.addAll(memberNo);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "新增成功" : "新增失敗");
		
		resp.getWriter().write(respBody.toString());
	}
//	/**
//     * POST 新增一筆自定義標籤
//     * 測試 OK
//     */
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		TagUserDefined tud = gson.fromJson(req.getReader(), TagUserDefined.class);
//		
//		HttpSession session = req.getSession();
//		Member seMember = (Member)session.getAttribute("member");
//		Integer memberNo = seMember.getMemberNo();
//		tud.setMemberNo(memberNo);
//		
//		boolean result = USERTAG_SERVICE.add(tud);
//		
//		JsonObject respBody = new JsonObject();
//		respBody.addProperty("successful", result);
//		respBody.addProperty("message", result ? "新增成功" : "新增失敗");
//		
//		resp.getWriter().write(respBody.toString());
//	}
	
	/**
     * PUT 編輯一筆自定義標籤
     * 測試 OK
     */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TagUserDefined tud = gson.fromJson(req.getReader(), TagUserDefined.class);
		
		HttpSession session = req.getSession();
		Member seMember = (Member)session.getAttribute("member");
		Integer memberNo = seMember.getMemberNo();
		tud.setMemberNo(memberNo);
		
		boolean result = USERTAG_SERVICE.edit(tud);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "編輯成功" : "編輯失敗");
		
		resp.getWriter().write(respBody.toString());
	}
	
	/**
     * DELETE 刪除一筆自定義標籤
     * 測試 OK
     * 用不到
     */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		Integer id = Integer.parseInt(pathVar[0]);
		
		TagUserDefined tud = new TagUserDefined();
		tud.setTagUserDefinedId(id);
		boolean result = USERTAG_SERVICE.delete(tud);
		
		resp.getWriter().write(gson.toJson(result));
	}
	
}
