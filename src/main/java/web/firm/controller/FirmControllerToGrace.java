package web.firm.controller;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.FirmClassContainer.FIRMDATAPOST;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import core.bean.CoreBean;
import web.firm.bean.FirmClass;
import web.firm.bean.ShopProduct;


@WebServlet("/firmData/*")
public class FirmControllerToGrace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp,FIRMDATAPOST.selectAll()) ;
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp,FIRMDATAPOST.selectByFirmNo(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			FirmClass firmClass = json2Bean(req, FirmClass.class);
			boolean result = FIRMDATAPOST.editFirm(firmClass);
			writeJsonBean(resp, new CoreBean(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FirmClass firm = (FirmClass)req.getSession().getAttribute("firm");
		firm.setPassword(null);
		resp.getWriter().write(gson.toJson(firm));
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", true);
		resp.getWriter().write(gson.toJson(respBody));
	}
//	@Override
//	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		FirmClass firm = gson.fromJson(req.getReader(), FirmClass.class);
//		HttpSession session = req.getSession();
//		FirmClass seFirm = (FirmClass) session.getAttribute("firm");
//		firm.setFirmNo(seFirm.getFirmNo());
//		
//		boolean result = FIRMDATAPOST.editFirm(firm);
//		FirmClass newFirm = FIRMDATAPOST.searchFirm(seFirm.getFirmEmail());
//		System.out.println(newFirm);
//		req.getSession().setAttribute("firm", firm);
//		
//		JsonObject respBody = new JsonObject();
//		respBody.addProperty("successful", result);
//		respBody.addProperty("message", result ? "編輯成功" : "編輯失敗");
//		
//		resp.getWriter().write(respBody.toString());
//	}

	
}
