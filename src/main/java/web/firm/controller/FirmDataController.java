package web.firm.controller;

import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.FirmClassContainer.FIRMDATAPOST;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firm/personaldata/*")
public class FirmDataController extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp,FIRMDATAPOST.selectAll());
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

}
