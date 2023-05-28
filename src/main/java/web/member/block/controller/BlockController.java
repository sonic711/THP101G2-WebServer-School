package web.member.block.controller;

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

import web.member.block.bean.Block;
import web.member.member.bean.Member;

import static web.member.util.MemberContains.BLOCK_SERVICE;

@WebServlet("/member/block/*")
public class BlockController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
     * GET 查詢該會員所有封鎖對象
     * 測試 OK
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		
		Block block = new Block();
		block.setMemberNo(Integer.parseInt(pathVar[0]));
		List<Block> list = BLOCK_SERVICE.findAllByMemberNo(block.getMemberNo());
		
		resp.getWriter().write(gson.toJson(list));	
	}
	
	
	/**
     * POST  新增某會員的一筆封鎖資料
     * 測試 OK
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		Block block = gson.fromJson(req.getReader(), Block.class);
		HttpSession session = req.getSession();
		Member seMember = (Member) session.getAttribute("member");
		Integer memberNo = seMember.getMemberNo();
		block.setMemberNo(memberNo);
		
		boolean result = BLOCK_SERVICE.add(block);
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "新增成功" : "新增失敗");
		
		resp.getWriter().write(gson.toJson(respBody.toString()));
	}
	
	/**
     * DELETE  刪除某會員的一筆封鎖資料
     * 測試 OK
     */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVar = pathInfo.split("/");
		Integer id = Integer.parseInt(pathVar[0]);
		
		Block block = new Block();
		block.setMemberBlockingId(id);
		boolean result = BLOCK_SERVICE.delete(block);

		resp.getWriter().write(gson.toJson(result));
		
	}
	
}
