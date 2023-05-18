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

import static core.util.CommonUtil.*;
import static web.community.util.CommunityContains.POSTLABEL_SERVICE;

@WebServlet("/community/postLabel")
public class PostLabelController extends HttpServlet {
    /**
    * POST 一次新增多筆標籤 測ok
    */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Type listType = new TypeToken<List<PostLabel>>() {}.getType();
            List<PostLabel> postLabelList = json2Beans(req, listType);
            boolean result = POSTLABEL_SERVICE.newPostLabel(postLabelList);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * GET 取得所有標籤 測ok
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            writeJsonBean(resp, POSTLABEL_SERVICE.findAllPostLabel());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
