package web.community.post.controller;

import core.bean.CoreBean;
import web.community.post.bean.PostLike;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.POSTLIKE_SERVICE;


@WebServlet("/community/postLike/*")
public class PostLikeController extends HttpServlet {
    // TODO ...

    /**
     * GET 查詢該篇文章的所有喜歡，不支援查詢所有喜歡 測ok
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, new CoreBean(false));
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp, POSTLIKE_SERVICE.findAllPostLikeByPostId(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * POST 新增該個文章的喜歡 測ok
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
     * PUT 修改該個文章的喜歡 測ok
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

    /**
     * DELETE 刪除該個文章的喜歡 測ok
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();

        try {
            pathInfo = pathInfo.substring(1);
            String[] pathVariables = pathInfo.split("/");
            Integer id = Integer.parseInt(pathVariables[0]);
            boolean result = POSTLIKE_SERVICE.removePostLikeById(id);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
