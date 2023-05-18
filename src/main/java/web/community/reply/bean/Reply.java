package web.community.reply.bean;

import java.sql.Timestamp;

public class Reply {
    private Integer comReplyId;
    private Integer memberNo;
    private Integer comReplyTo;
    private String comReplyContent;
    private Timestamp comReplyTime;
    private Boolean comReplyAccessSetting;

    @Override
    public String toString() {
        return "Reply{" +
               "comReplyId=" + comReplyId +
               ", memberNo=" + memberNo +
               ", comReplyTo=" + comReplyTo +
               ", comReplyContent='" + comReplyContent + '\'' +
               ", comReplyTime=" + comReplyTime +
               ", comReplyAccessSetting=" + comReplyAccessSetting +
               '}';
    }

    public Integer getComReplyId() {
        return comReplyId;
    }

    public void setComReplyId(Integer comReplyId) {
        this.comReplyId = comReplyId;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getComReplyTo() {
        return comReplyTo;
    }

    public void setComReplyTo(Integer comReplyTo) {
        this.comReplyTo = comReplyTo;
    }

    public String getComReplyContent() {
        return comReplyContent;
    }

    public void setComReplyContent(String comReplyContent) {
        this.comReplyContent = comReplyContent;
    }

    public Timestamp getComReplyTime() {
        return comReplyTime;
    }

    public void setComReplyTime(Timestamp comReplyTime) {
        this.comReplyTime = comReplyTime;
    }

    public Boolean getComReplyAccessSetting() {
        return comReplyAccessSetting;
    }

    public void setComReplyAccessSetting(Boolean comReplyAccessSetting) {
        this.comReplyAccessSetting = comReplyAccessSetting;
    }
}
