package web.calendar.schedule.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.calendar.schedule.bean.MemSchedule;
import web.calendar.schedule.bean.Schedule;
import web.member.member.bean.Member;

import static web.calendar.util.CalendarContains.SCHEDULE_SERVICE;;


@WebServlet("/calendar/schedule/*")
public class ScheduleController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	/**
     * GET: 顯示該會員某天的所有日程
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		MemSchedule memSchedule = new MemSchedule();
		Integer memberNo = Integer.parseInt(pathVar[0]);
		memSchedule.setMemberNo(memberNo);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 3; i++) {
			sb.append(pathVar[i]);
			if (i < 3 ) {
				sb.append("-");
			}
		}
		LocalDate localDate = LocalDate.parse(sb.toString());
		Date date = Date.valueOf(localDate);
		List<MemSchedule> list = SCHEDULE_SERVICE.memberScheduleOnDate(memberNo, date);
		
		resp.getWriter().write(gson.toJson(list));
	}
	
	/**
     * POST: 新增一筆日程 
     * 測試 OK
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Schedule schedule = gson.fromJson(req.getReader(), Schedule.class);
		
		HttpSession session = req.getSession();
		Member seMember = (Member)session.getAttribute("member");
		Integer memberNo = seMember.getMemberNo();
		schedule.setMemberNo(memberNo);
		System.out.println(schedule);
		boolean result = SCHEDULE_SERVICE.add(schedule);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "新增成功" : "新增失敗");
		
		resp.getWriter().write(gson.toJson(respBody));
	}
	
	/**
     * PUT: 編輯一筆日程
     * 測試 OK
     */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Schedule schedule = gson.fromJson(req.getReader(), Schedule.class);
		HttpSession session = req.getSession();
		Member seMember = (Member)session.getAttribute("member");
		Integer memberNo = seMember.getMemberNo();
		schedule.setMemberNo(memberNo);
		
		boolean result = SCHEDULE_SERVICE.edit(schedule);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "編輯成功" : "編輯失敗");
		
		resp.getWriter().write(respBody.toString());
	}
	
	
	/**
     * DELETE: 刪除一筆日程
     * 測試 OK
     */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		Integer id = Integer.parseInt(pathVar[0]);
		
		Schedule schedule = new Schedule();
		schedule.setScheduleId(id);
		boolean result = SCHEDULE_SERVICE.delete(schedule);
		
		resp.getWriter().write(gson.toJson(result));
	}
	
	
	/**
     * OPTIONS: 顯示一筆日程
     * 測試 OK
     */
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemSchedule memSchedule = gson.fromJson(req.getReader(), MemSchedule.class);
		HttpSession session = req.getSession();
		Member seMember = (Member)session.getAttribute("member");
		memSchedule.setMemberNo(seMember.getMemberNo());
		memSchedule = SCHEDULE_SERVICE.singleSchedule(memSchedule);
		
		resp.getWriter().write(gson.toJson(memSchedule));
	}
}
