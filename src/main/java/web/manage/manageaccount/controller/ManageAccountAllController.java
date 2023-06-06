package web.manage.manageaccount.controller;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.course.course.util.CourseContainer.COURSE_SERVICE;
import static web.manage.util.ManageContains.MANAGE_ACCOUNT_SERVICE;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import core.bean.CoreBean;
import web.course.course.bean.Course;
import web.manage.manageaccount.bean.Manageaccount;


@WebServlet("/manageaccount/*")
public class ManageAccountAllController extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;

	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
		
        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, MANAGE_ACCOUNT_SERVICE.findAllManageAccount());
        } else  {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp, MANAGE_ACCOUNT_SERVICE.findManageAccountById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		}
	}
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	Manageaccount manageaccount = json2Bean(req, Manageaccount.class);
            boolean result = MANAGE_ACCOUNT_SERVICE.editManageAccount(manageaccount);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Manageaccount manageaccount = json2Bean(req, Manageaccount.class);
			System.out.println(manageaccount);
			Boolean result = MANAGE_ACCOUNT_SERVICE.newOneManageAccount(manageaccount);
			writeJsonBean(resp, new CoreBean(true, result.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pathInfo = req.getPathInfo();
		
		try {
			pathInfo = pathInfo.substring(1);
			String[] pathVariables = pathInfo.split("/");
			Integer id = Integer.parseInt(pathVariables[0]);
			boolean result = MANAGE_ACCOUNT_SERVICE.removeManageAccountById(id);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
	