package web.community.post.bean;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class Post {
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

    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Integer getComSecClassId() {
        return comSecClassId;
    }

    public void setComSecClassId(Integer comSecClassId) {
        this.comSecClassId = comSecClassId;
    }

    public String getComSecClassName() {
        return comSecClassName;
    }

    public void setComSecClassName(String comSecClassName) {
        this.comSecClassName = comSecClassName;
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

    public Integer getComPostLabelId() {
        return comPostLabelId;
    }

    public void setComPostLabelId(Integer comPostLabelId) {
        this.comPostLabelId = comPostLabelId;
    }

    public Timestamp getComPostLabelTime() {
        return comPostLabelTime;
    }

    public void setComPostLabelTime(Timestamp comPostLabelTime) {
        this.comPostLabelTime = comPostLabelTime;
    }

    public String getComPostLabelName() {
        return comPostLabelName;
    }

    public void setComPostLabelName(String comPostLabelName) {
        this.comPostLabelName = comPostLabelName;
    }

    public Timestamp getComPostTime() {
        return comPostTime;
    }

    public void setComPostTime(Timestamp comPostTime) {
        this.comPostTime = comPostTime;
    }

    public Boolean getComPostStatus() {
        return comPostStatus;
    }

    public void setComPostStatus(Boolean comPostStatus) {
        this.comPostStatus = comPostStatus;
    }

    public Boolean getComPostAccessSetting() {
        return comPostAccessSetting;
    }

    public void setComPostAccessSetting(Boolean comPostAccessSetting) {
        this.comPostAccessSetting = comPostAccessSetting;
    }

    public List<PostLabel> getLabelList() {
        return labels;
    }

    public void setLabelList(List<PostLabel> labelList) {
        this.labels = labelList;
    }

    @Override
    public String toString() {
        return "Post{" +
               "comPostId=" + comPostId +
               ", memberNo=" + memberNo +
               ", userId='" + userId + '\'' +
               ", nickName='" + nickName + '\'' +
               ", profilePhoto=" + Arrays.toString(profilePhoto) +
               ", comSecClassId=" + comSecClassId +
               ", comSecClassName='" + comSecClassName + '\'' +
               ", comPostTitle='" + comPostTitle + '\'' +
               ", comPostContent='" + comPostContent + '\'' +
               ", comPostLabelId=" + comPostLabelId +
               ", comPostLabelTime=" + comPostLabelTime +
               ", comPostLabelName='" + comPostLabelName + '\'' +
               ", comPostTime=" + comPostTime +
               ", comPostStatus=" + comPostStatus +
               ", comPostAccessSetting=" + comPostAccessSetting +
               ", labelList=" + labels+
               '}';
    }

    private Integer comPostId;
    private Integer memberNo;
    private String userId;
    private String nickName;
    private byte[] profilePhoto;
    private Integer comSecClassId;
    private String comSecClassName;
    private String comPostTitle;
    private String comPostContent;
    private Integer comPostLabelId;
    private Timestamp comPostLabelTime;
    private String comPostLabelName;
    private Timestamp comPostTime;
    private Boolean comPostStatus;
    private Boolean comPostAccessSetting;
    private List<PostLabel> labels;


}
