package web.member.block.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.member.block.bean.Block;

import static web.member.util.MemberContains.BLOCK_SERVICE;

/**
 * GET 查詢所有會員封鎖資料
 * 測試 OK
 */
@WebServlet("/member/block/getAll")
public class BlockGetAllController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		List<Block> list = BLOCK_SERVICE.findAll();
		resp.getWriter().write(gson.toJson(list));
	}
}
