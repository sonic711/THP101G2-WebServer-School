package web.manage.manageper.controller;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.manage.util.ManageContains.MANAGE_PER_SERVICE;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import core.bean.CoreBean;
import web.manage.manageper.bean.Manageper;

@WebServlet("/manageper/*")
public class ManageManagePerAllController {
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String pathInfo = req.getPathInfo();

	        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
	            writeJsonBean(resp, new CoreBean(false));
	        } else {
	            try {
	                pathInfo = pathInfo.substring(1);
	                String[] pathVariables = pathInfo.split("/");
	                Integer id = Integer.parseInt(pathVariables[0]);
	                writeJsonBean(resp, MANAGE_PER_SERVICE.findAllManagePerByMAId(id));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
}
	 protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        try {
	        	Manageper manageper = json2Bean(req, Manageper.class);
	            boolean result = MANAGE_PER_SERVICE.editManagePer(manageper);
	            writeJsonBean(resp, new CoreBean(result));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	 
}
