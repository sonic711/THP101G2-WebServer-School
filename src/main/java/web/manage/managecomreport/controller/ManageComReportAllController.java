package web.manage.managecomreport.controller;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.course.course.util.CourseContainer.CHAPTER_SERVICE;
import static web.course.course.util.CourseContainer.COURSE_SERVICE;
import static web.manage.util.ManageContains.MANAGE_COM_REPORT_SERVICE;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import core.bean.CoreBean;
import web.course.chapter.bean.Chapter;
import web.manage.managecomreport.bean.Managecomreport;

@WebServlet("/managecomreport/*")
public class ManageComReportAllController extends HttpServlet{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String pathInfo = req.getPathInfo();

	        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
	            writeJsonBean(resp, MANAGE_COM_REPORT_SERVICE.findAllManageComReport());
	        } else {
	            try {
	                pathInfo = pathInfo.substring(1);
	                String[] pathVariables = pathInfo.split("/");
	                Integer id = Integer.parseInt(pathVariables[0]);
	                writeJsonBean(resp, MANAGE_COM_REPORT_SERVICE.findManageComReportById(id));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	@Override
	 protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        try {
	        	Managecomreport managecomreport = json2Bean(req, Managecomreport.class);
	            boolean result = MANAGE_COM_REPORT_SERVICE.editManageComReport(managecomreport);
	            writeJsonBean(resp, new CoreBean(result));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 @Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				Managecomreport managecomreport = json2Bean(req, Managecomreport.class);
				Boolean result = MANAGE_COM_REPORT_SERVICE.newOneManageComReport(managecomreport);
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
				boolean result = MANAGE_COM_REPORT_SERVICE.removeManageComReportById(id);
				writeJsonBean(resp, new CoreBean(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
