package web.community.reply.controller;

import core.bean.CoreBean;
import web.community.reply.bean.Reply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.REPLY_SERVICE;

@WebServlet("/community/reply/*")
public class ReplyController extends HttpServlet {
    /**
     * GET
     * /  查詢所有回覆，後台用 測ok
     * /* 查詢特定文章的所有回覆 測ok
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, REPLY_SERVICE.findAllReply());
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                List<Reply> replys = REPLY_SERVICE.findAllReplyById(id);

                writeJsonBean(resp, replys);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * POST 新增一個回覆 測ok
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Reply reply = json2Bean(req, Reply.class);
            boolean result = REPLY_SERVICE.newOneReply(reply);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * PUT 修改回覆內容 測ok
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Reply reply = json2Bean(req, Reply.class);
            boolean result = REPLY_SERVICE.editReply(reply);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DELETE
     * /  不開放此功能 return false
     * /* 刪除特定回覆 FIXIT 有表情的話會刪不掉 測 NOT ok
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, new CoreBean(false, "不支援一次刪除所有回覆"));
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                boolean result = REPLY_SERVICE.removeReplyById(id);
                writeJsonBean(resp, new CoreBean(result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
