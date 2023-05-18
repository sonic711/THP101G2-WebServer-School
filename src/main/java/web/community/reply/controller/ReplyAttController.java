package web.community.reply.controller;

import core.bean.CoreBean;
import web.community.reply.bean.ReplyAtt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.REPLYATT_SERVICE;

@WebServlet("/community/replyAtt")
public class ReplyAttController extends HttpServlet {
    /**
     * Post 新增一個回覆附檔案 測ok
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
     * PUT 修改一個回覆附檔案 測ok
     * */
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
}
