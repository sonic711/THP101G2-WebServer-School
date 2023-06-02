package web.firm.controller;

import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.FirmOrderContainer.ORDERPOSTALL_SERVICE;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 查所有訂單
@WebServlet("/ordermanager/*")
public class FirmOrderStatusOne  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp,ORDERPOSTALL_SERVICE.selectAll());
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp,ORDERPOSTALL_SERVICE.selectAll());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
}
