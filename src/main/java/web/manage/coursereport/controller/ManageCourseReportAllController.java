package web.manage.coursereport.controller;

import static core.util.CommonUtil.json2Bean;
import static web.manage.util.ManageContains.MANAGE_COURSE_REPORT_SERVICE;
import static core.util.CommonUtil.writeJsonBean;


import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.manage.coursereport.bean.Coursereport;

@WebServlet("/coursereport/*")
public class ManageCourseReportAllController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, MANAGE_COURSE_REPORT_SERVICE.findAllManageCourseReport());
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp, MANAGE_COURSE_REPORT_SERVICE.findManageCourseReportById(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
	
	@Override
	
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Coursereport coursereport = json2Bean(req, Coursereport.class);
            boolean result = MANAGE_COURSE_REPORT_SERVICE.editCourseReport(coursereport);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Coursereport coursereport = json2Bean(req, Coursereport.class);
			System.out.println(coursereport);
			Boolean result = MANAGE_COURSE_REPORT_SERVICE.newManageCourseReport(coursereport);
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
			boolean result = MANAGE_COURSE_REPORT_SERVICE.removeManageCourseReportById(id);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
