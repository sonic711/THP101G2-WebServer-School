package web.manage.teaapply.controller;

import static core.util.CommonUtil.writeJsonBean;
import static web.manage.util.ManageContains.MANAGE_TEA_APPLY_SERVICE;
import static web.member.util.MemberContains.MEMBER_SERVICE;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectMemberAllController {
	
	@WebServlet("/teaapply/")
	public class MemberGetAllController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String pathInfo = req.getPathInfo();
	        
	        if (pathInfo.equals("/ddd")) {
	            writeJsonBean(resp, MANAGE_TEA_APPLY_SERVICE.findSelectMember(null));
	        }else{
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
	}
}
	           
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
