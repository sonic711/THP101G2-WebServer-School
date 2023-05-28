package web.community.reply.controller;

import core.bean.CoreBean;
import web.community.reply.bean.ReplyAtt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.REPLYATT_SERVICE;

@WebServlet("/community/replyAtt/*")
public class ReplyAttController extends HttpServlet {
    /**
     * GET
     * /   不支援查詢所有留言的附檔案
     * /*  查詢該留言的附檔案 測ok
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, new CoreBean(false, "不支援查詢所有留言的附檔案"));
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp, REPLYATT_SERVICE.findAllReplyAttById(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Post 新增該留言的附檔案 測ok
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ReplyAtt replyAtt = json2Bean(req, ReplyAtt.class);
            boolean result = REPLYATT_SERVICE.newOneReplyAtt(replyAtt);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * PUT 修改該留言的附檔案 測ok
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ReplyAtt replyAtt = json2Bean(req, ReplyAtt.class);
            boolean result = REPLYATT_SERVICE.editReplyAtt(replyAtt);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DELETE
     * /   不支援刪除所有留言的附檔案
     * /*  查詢該留言的附檔案 測ok
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, new CoreBean(false, "不支援一次刪除留言的附檔案"));
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                boolean result = REPLYATT_SERVICE.removeReplyAttById(id);
                writeJsonBean(resp, new CoreBean(result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
