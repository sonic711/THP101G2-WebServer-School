package web.community.post.controller;

import com.google.gson.reflect.TypeToken;
import core.bean.CoreBean;
import web.community.post.bean.PostLabel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import static core.util.CommonUtil.json2Beans;
import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.POSTLABEL_SERVICE;

@WebServlet("/community/postLabel/*")
public class PostLabelController extends HttpServlet {
    /**
     * GET 取得所有不重複的標籤 & 取得特定文章標籤 測ok
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, POSTLABEL_SERVICE.findAllPostLabel());
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp, POSTLABEL_SERVICE.findAllPostLabelById(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * POST 一次新增多筆標籤 測ok
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Type listType = new TypeToken<List<PostLabel>>() {
            }.getType();
            List<PostLabel> postLabelList = json2Beans(req, listType);
            boolean result = POSTLABEL_SERVICE.newPostLabel(postLabelList, 99);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DELETE 刪除標籤 測ok
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();

        try {
            pathInfo = pathInfo.substring(1);
            String[] pathVariables = pathInfo.split("/");
            Integer id = Integer.parseInt(pathVariables[0]);
            boolean result = POSTLABEL_SERVICE.removePostAttById(id);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
