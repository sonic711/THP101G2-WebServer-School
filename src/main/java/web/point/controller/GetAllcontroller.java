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

import core.bean.CoreBean;


@WebServlet("/point/*")
public class GetAllcontroller extends HttpServlet {
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
	
}
