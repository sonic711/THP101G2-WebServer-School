package web.community.classes.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static core.util.CommonUtil.writeJsonBean;
import static web.community.util.CommunityContains.CLASS_SERVICE;

/**
* 查詢所有主分類跟子分類
* */
@WebServlet("/community/class/*")
public class FindAllClassController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            writeJsonBean(resp, CLASS_SERVICE.findAllClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
