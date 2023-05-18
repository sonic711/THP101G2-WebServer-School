package web.member.notification.controller;

import core.bean.CoreBean;
import web.member.notification.bean.Notification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static core.util.CommonUtil.json2Bean;
import static core.util.CommonUtil.writeJsonBean;
import static web.member.util.MemberContains.NOTIFICATION_SERVICE;

@WebServlet("/member/notification")
public class NotificationController extends HttpServlet {

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
     * PUT 更改通知狀態(已讀未讀)
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
}
