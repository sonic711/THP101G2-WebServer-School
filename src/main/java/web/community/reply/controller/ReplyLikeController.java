package web.community.reply.controller;

import core.bean.CoreBean;
import web.community.reply.bean.ReplyLike;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.REPLYLIKE_SERVICE;

@WebServlet("/community/replyLike")
public class ReplyLikeController extends HttpServlet {
    /**
     * POST 新增喜歡的表情 測ok
     * */
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
     * */
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
}
