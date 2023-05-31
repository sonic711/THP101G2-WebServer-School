package web.community.post.controller;

import core.bean.CoreBean;
import web.community.post.bean.Post;
import web.member.member.bean.Member;

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
import static web.community.util.CommunityContains.POST_SERVICE;

@WebServlet("/community/post/*")
public class PostController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * GET 查詢所有文章 & 單篇文章 測ok
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, POST_SERVICE.findAllPost());
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                Post post = POST_SERVICE.findPostById(id);
                writeJsonBean(resp, post);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * PUT 修改單篇文章標題、內容、開放狀態 測ok
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Post post = json2Bean(req, Post.class);
            System.out.println(post);
            boolean result = POST_SERVICE.editPost(post);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * POST 新增單篇文章 測ok
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Post post = json2Bean(req, Post.class);
            Integer result = POST_SERVICE.newOnePost(post);
            writeJsonBean(resp, new CoreBean(true, result.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Member member = json2Bean(req, Member.class);
            List<Post> result = POST_SERVICE.findAllPostByQuery(member.getMemberNo());
            writeJsonBean(resp, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
