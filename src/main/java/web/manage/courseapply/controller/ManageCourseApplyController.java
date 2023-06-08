package web.manage.courseapply.controller;
import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.manage.util.ManageContains.MANAGE_SERVICE;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import core.bean.CoreBean;
import web.manage.courseapply.bean.Courseapply;

@WebServlet("/courseapply/*")
public class ManageCourseApplyController extends HttpServlet {
	
	 

	 /**
	     * GET 查詢所有檢舉文章
	     */
	private static final long serialVersionUID = 1L;
	   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if (pathInfo == null || Objects.equals(pathInfo, "/")) {
			 writeJsonBean(resp, MANAGE_SERVICE.findAllCourseApply());
		} else {
			try {
				pathInfo = pathInfo.substring(1);
				String[] pathVariables = pathInfo.split("/");
				Integer id = Integer.parseInt(pathVariables[0]);
				writeJsonBean(resp, MANAGE_SERVICE.findCourseApplyById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 }
	   @Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Courseapply courseapply = json2Bean(req, Courseapply.class);
			boolean result = MANAGE_SERVICE.editPost(courseapply);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   
	   @Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				Courseapply courseapply = json2Bean(req, Courseapply.class);
				System.out.println(courseapply);
				Boolean result = MANAGE_SERVICE.newManageCourseApply(courseapply);
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
				boolean result = MANAGE_SERVICE.removeManageCourseApplyById(id);
				writeJsonBean(resp, new CoreBean(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	   
}
	
	
