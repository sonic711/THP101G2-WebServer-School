package web.community.post.controller;

import core.bean.CoreBean;
import web.community.post.bean.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static web.community.util.CommunityContains.POST_SERVICE;
import static core.util.CommonUtil.writeJsonBean;

@WebServlet("/community/mempost/*")
public class PostForMemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            writeJsonBean(resp, new CoreBean(false, "不支援此方法"));
        } else {
            pathInfo = pathInfo.substring(1);
            String[] pathVariables = pathInfo.split("/");
            Integer id = Integer.parseInt(pathVariables[0]);
            List<Post> list = POST_SERVICE.findAllPostByMemId(id);
            writeJsonBean(resp, list);
        }
    }
}
