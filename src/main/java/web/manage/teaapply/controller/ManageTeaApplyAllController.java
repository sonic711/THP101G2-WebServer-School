package web.manage.teaapply.controller;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.manage.util.ManageContains.MANAGE_ACCOUNT_SERVICE;
import static web.manage.util.ManageContains.MANAGE_TEA_APPLY_SERVICE;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.manage.manageaccount.bean.Manageaccount;
import web.manage.teaapply.bean.Teaapply;

@WebServlet("/teaapply/*")
public class ManageTeaApplyAllController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String pathInfo = req.getPathInfo();

	        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
	            writeJsonBean(resp, MANAGE_TEA_APPLY_SERVICE.findAllManageTeaApply());
	        } else {
	            try {
	                pathInfo = pathInfo.substring(1);
	                String[] pathVariables = pathInfo.split("/");
	                Integer id = Integer.parseInt(pathVariables[0]);
	                writeJsonBean(resp, MANAGE_TEA_APPLY_SERVICE.findManageTeapplyById(id));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 @Override
	 protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        try {
	            Teaapply teaapply = json2Bean(req,  Teaapply.class);
	            boolean result = MANAGE_TEA_APPLY_SERVICE.editManageTeaApply(teaapply);
	            writeJsonBean(resp, new CoreBean(result));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 @Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				Teaapply teaapply  = json2Bean(req, Teaapply.class);
				System.out.println(teaapply);
				Boolean result = MANAGE_TEA_APPLY_SERVICE.newOneManageTeaApply(teaapply);
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
				boolean result = MANAGE_TEA_APPLY_SERVICE.removeManageTeaApplyById(id);
				writeJsonBean(resp, new CoreBean(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
