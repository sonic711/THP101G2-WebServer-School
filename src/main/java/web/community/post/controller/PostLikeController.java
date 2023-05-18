package web.community.post.controller;

import core.bean.CoreBean;
import web.community.post.bean.PostLike;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.POSTLIKE_SERVICE;


@WebServlet("/community/postLike")
public class PostLikeController extends HttpServlet {
    // TODO ...

    /**
     * POST 新增一個文章的喜歡 測ok
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PostLike postLike = json2Bean(req, PostLike.class);
            boolean result = POSTLIKE_SERVICE.newOnePostLike(postLike);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * PUT 修改一個文章的喜歡 測ok
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PostLike postLike = json2Bean(req, PostLike.class);
            boolean result = POSTLIKE_SERVICE.editPostLike(postLike);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
