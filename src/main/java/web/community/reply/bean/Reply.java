package web.community.reply.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class Reply {
    private Integer comReplyId;
    private Integer memberNo;
    private byte[] profilePhoto;
    private String userId;
    private String nickName;
    private Integer comReplyTo;
    private String comReplyContent;
    private Timestamp comReplyTime;
    private Boolean comReplyAccessSetting;

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

    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    @Override
    public String toString() {
        return "Reply{" +
               "comReplyId=" + comReplyId +
               ", memberNo=" + memberNo +
               ", profilePhoto=" + Arrays.toString(profilePhoto) +
               ", userId=" + userId +
               ", nickName='" + nickName + '\'' +
               ", comReplyTo=" + comReplyTo +
               ", comReplyContent='" + comReplyContent + '\'' +
               ", comReplyTime=" + comReplyTime +
               ", comReplyAccessSetting=" + comReplyAccessSetting +
               '}';
    }

}
