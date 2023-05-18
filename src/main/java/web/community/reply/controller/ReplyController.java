package web.community.reply.controller;

import core.bean.CoreBean;
import web.community.reply.bean.Reply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static core.util.Constants.GSON;
import static core.util.Constants.JSON_MIME_TYPE;
import static web.community.util.CommunityContains.REPLY_SERVICE;

@WebServlet("/community/reply")
public class ReplyController extends HttpServlet {
    /**
     *  查詢所有回覆，後台用
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            writeJsonBean(resp, REPLY_SERVICE.findAllReply());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *  新增一個回覆
     * */
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
     *  修改回覆內容
     * */
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

    private void writeJson(HttpServletResponse resp, Reply reply) {
        resp.setContentType(JSON_MIME_TYPE);
        try (PrintWriter pw = resp.getWriter()) {
            pw.print(GSON.toJson(reply));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
