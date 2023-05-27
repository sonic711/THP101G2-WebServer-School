package web.member.member.controller;

import static web.member.util.MemberContains.MEMBER_SERVICE;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.member.member.bean.Member;

/**
 * GET 查詢所有會員資料
 * 測試 OK
 */
@WebServlet("/member/getAll")
public class MemberGetAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		List<Member> list = MEMBER_SERVICE.findAll();
		resp.getWriter().write(gson.toJson(list));
	}
}
