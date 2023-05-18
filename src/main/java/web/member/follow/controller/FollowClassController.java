package web.member.follow.controller;

import core.bean.CoreBean;
import web.member.follow.bean.FollowClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.member.util.MemberContains.FOLLOWCLASS_SERVICE;

@WebServlet("/member/followClass/*")
public class FollowClassController extends HttpServlet {

    /**
     * GET 查詢某會員追蹤的分類 測ok
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        try {
            pathInfo = pathInfo.substring(1);
            String[] pathVariables = pathInfo.split("/");
            Integer id = Integer.parseInt(pathVariables[0]);
            writeJsonBean(resp, FOLLOWCLASS_SERVICE.findAllFollowClassById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * POST 新增某會員追蹤的分類 測ok
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            FollowClass followClass = json2Bean(req, FollowClass.class);
            boolean result = FOLLOWCLASS_SERVICE.newOneFollowClass(followClass);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DELETE 刪除某會員追蹤的分類 測ok
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        try {
            pathInfo = pathInfo.substring(1);
            String[] pathVariables = pathInfo.split("/");
            Integer id = Integer.parseInt(pathVariables[0]);
            writeJsonBean(resp, FOLLOWCLASS_SERVICE.deleteFollowClassById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
