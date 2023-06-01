package web.point.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static web.point.util.PointContains.POINT_CHANGED_SERVICE;
import com.google.gson.Gson;
import static core.util.CommonUtil.*;
import core.bean.CoreBean;
import web.point.bean.PointChanged;

@WebServlet("/point")
public class AddNewPCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
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
