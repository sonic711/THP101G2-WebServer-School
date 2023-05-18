package web.member.notification.bean;

import java.sql.Timestamp;

public class Notification {
    private Integer notificationId;
    private Integer memberNo;
    private String notificationContent;
    private Boolean notificationStatus;
    private Timestamp notificationTime;

    @Override
    public String toString() {
        return "Notification{" +
               "notificationId=" + notificationId +
               ", memberNo=" + memberNo +
               ", notificationContent='" + notificationContent + '\'' +
               ", notificationStatus=" + notificationStatus +
               ", notificationTime=" + notificationTime +
               '}';
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public Boolean getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(Boolean notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public Timestamp getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(Timestamp notificationTime) {
        this.notificationTime = notificationTime;
    }
}
