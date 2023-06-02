package web.point.controller;

import static core.util.CommonUtil.writeJsonBean;
import static web.point.util.PointContains.POINT_CHANGED_SERVICE;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import core.bean.CoreBean;
import web.point.bean.PointChanged;


@WebServlet("/point/*")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		  String pathInfo = req.getPathInfo();

	        
	            try {
	                pathInfo = pathInfo.substring(1);
	                String[] pathVariables = pathInfo.split("/");
	                Integer id = Integer.parseInt(pathVariables[0]);
	                writeJsonBean(resp, POINT_CHANGED_SERVICE.selectAll(id));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		
		
		try {
			PointChanged PC = gson.fromJson(req.getReader(),PointChanged.class);
			boolean result = POINT_CHANGED_SERVICE.insert(PC);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
}
