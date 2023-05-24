package web.member.notification.controller;

import core.bean.CoreBean;
import web.member.notification.bean.Notification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.member.util.MemberContains.NOTIFICATION_SERVICE;

@WebServlet("/member/notification/*")
public class NotificationController extends HttpServlet {
    /**
     * GET
     * /  不支援查詢所有通知
     * /* 查詢該會員所有通知 測ok
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, new CoreBean(false, "不支援查詢所有通知"));
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                writeJsonBean(resp, NOTIFICATION_SERVICE.findAllNotificationById(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * POST 新增通知 測ok
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Notification notification = json2Bean(req, Notification.class);
            boolean result = NOTIFICATION_SERVICE.newOneNotification(notification);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * PUT 更改通知狀態(更新已讀未讀狀態)
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Notification notification = json2Bean(req, Notification.class);
            boolean result = NOTIFICATION_SERVICE.editNotification(notification);
            writeJsonBean(resp, new CoreBean(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DELETE
     * /  不支援刪除所有通知
     * /* 刪除該筆通知 測
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || Objects.equals(pathInfo, "/")) {
            writeJsonBean(resp, new CoreBean(false, "不支援刪除所有通知"));
        } else {
            try {
                pathInfo = pathInfo.substring(1);
                String[] pathVariables = pathInfo.split("/");
                Integer id = Integer.parseInt(pathVariables[0]);
                boolean result = NOTIFICATION_SERVICE.deleteNotificationById(id);
                writeJsonBean(resp, new CoreBean(result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
