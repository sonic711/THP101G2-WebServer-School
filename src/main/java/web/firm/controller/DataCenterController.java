package web.firm.controller;

// 用商品id(pk)去加總銷售額
import static core.util.CommonUtil.writeJsonBean;
import static web.firm.util.DataCenterContainer.SALEDATA_SERVICE;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/datacenter/firm/*")
public class DataCenterController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp,SALEDATA_SERVICE.selectAll());
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp,SALEDATA_SERVICE.selectByFirmNo(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

}
