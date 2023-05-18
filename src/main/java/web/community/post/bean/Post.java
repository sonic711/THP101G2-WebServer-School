package web.community.post.bean;

import java.sql.Timestamp;

public class Post {
    private Integer comPostId;
    private Integer memberNo;
    private Integer comSecClassId;
    private String comPostTitle;
    private String comPostContent;
    private Timestamp comPostTime;
    private Boolean comPostStatus;
    private Boolean comPostAccessSetting;
    @Override
    public String toString() {
        return "Post{" +
               "comPostId=" + comPostId +
               ", memberNo=" + memberNo +
               ", comSecClassId=" + comSecClassId +
               ", comPostTitle='" + comPostTitle + '\'' +
               ", comPostContent='" + comPostContent + '\'' +
               ", comPostTime=" + comPostTime +
               ", comPostStatus=" + comPostStatus +
               ", comPostAccessSetting=" + comPostAccessSetting +
               '}';
    }

    public Integer getComPostId() {
        return comPostId;
    }

    public void setComPostId(Integer comPostId) {
        this.comPostId = comPostId;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getComSecClassId() {
        return comSecClassId;
    }

    public void setComSecClassId(Integer comSecClassId) {
        this.comSecClassId = comSecClassId;
    }

    public String getComPostTitle() {
        return comPostTitle;
    }

    public void setComPostTitle(String comPostTitle) {
        this.comPostTitle = comPostTitle;
    }

    public String getComPostContent() {
        return comPostContent;
    }

    public void setComPostContent(String comPostContent) {
        this.comPostContent = comPostContent;
    }

    public Timestamp getComPostTime() {
        return comPostTime;
    }

    public void setComPostTime(Timestamp comPostTime) {
        this.comPostTime = comPostTime;
    }

    public boolean isComPostStatus() {
        return comPostStatus;
    }

    public void setComPostStatus(Boolean comPostStatus) {
        this.comPostStatus = comPostStatus;
    }

    public boolean isComPostAccessSetting() {
        return comPostAccessSetting;
    }

    public void setComPostAccessSetting(Boolean comPostAccessSetting) {
        this.comPostAccessSetting = comPostAccessSetting;
    }
}
