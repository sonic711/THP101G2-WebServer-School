package web.community.reply.controller;

import core.bean.CoreBean;
import web.community.reply.bean.ReplyLike;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.REPLYLIKE_SERVICE;

@WebServlet("/community/replyLike/*")
public class ReplyLikeController extends HttpServlet {
    /**
     * GET
     * /  不支援查詢所有回覆的表情
     * /* 查詢該回覆所有喜歡的表情 測ok
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, new CoreBean(false, "不支援查詢所有回覆的表情"));
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp, REPLYLIKE_SERVICE.findAllReplyLikeById(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * POST 新增喜歡的表情 測ok
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ReplyLike replyLike = json2Bean(req, ReplyLike.class);
            boolean result = REPLYLIKE_SERVICE.newOneReplyLike(replyLike);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * PUT 更改喜歡的表情 測ok
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ReplyLike replyLike = json2Bean(req, ReplyLike.class);
            boolean result = REPLYLIKE_SERVICE.editReplyLike(replyLike);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DELETE
     * /  不支援一次刪除所有喜歡
     * /* 刪除該篇回覆的喜歡 測ok
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, new CoreBean(false, "不支援一次刪除所有喜歡"));
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                boolean result = REPLYLIKE_SERVICE.removeReplyLikeById(id);
                writeJsonBean(resp, new CoreBean(result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
