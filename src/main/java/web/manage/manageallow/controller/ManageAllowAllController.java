package web.manage.manageallow.controller;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.manage.util.ManageContains.MANAGE_ALLOW_SERVICE;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.CoreBean;
import web.manage.manageallow.bean.Manageallow;

@WebServlet("/manageallow/*")
public class ManageAllowAllController {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, new CoreBean(false));
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp, MANAGE_ALLOW_SERVICE.findAllManageAllowByMAId(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Manageallow  manageallow = json2Bean(req, Manageallow.class);
            boolean result = MANAGE_ALLOW_SERVICE.checkManageAllow(manageallow);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

}