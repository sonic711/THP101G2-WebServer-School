package web.community.post.controller;

import core.bean.CoreBean;
import web.community.post.bean.PostAtt;

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
import static web.community.util.CommunityContains.POSTATT_SERVICE;


@WebServlet("/community/postAtt")
public class PostAttController extends HttpServlet {
    /**
     *  查詢所有
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO
    }

    /**
     * POST 新增一個附檔 測ok
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PostAtt postAtt = json2Bean(req, PostAtt.class);
            boolean result = POSTATT_SERVICE.newOnePostAtt(postAtt);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * PUT 更新附檔 測ok
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PostAtt postAtt = json2Bean(req, PostAtt.class);
            boolean result = POSTATT_SERVICE.editPostAtt(postAtt);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeJson(HttpServletResponse resp, PostAtt postAtt) {
        resp.setContentType(JSON_MIME_TYPE);
        try (PrintWriter pw = resp.getWriter()) {
            pw.print(GSON.toJson(postAtt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
