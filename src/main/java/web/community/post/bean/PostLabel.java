package web.community.post.bean;

import java.sql.Timestamp;

public class PostLabel {
    private Integer comLabelId;
    private Integer comPostId;
    private String comLabelName;
    private Timestamp comLabelTime;

    @Override
    public String toString() {
        return "PostLabel{" +
               "comLabelId=" + comLabelId +
               ", comPostId=" + comPostId +
               ", comLabelName='" + comLabelName + '\'' +
               ", comLabelTime=" + comLabelTime +
               '}';
    }

    public Integer getComLabelId() {
        return comLabelId;
    }

    public void setComLabelId(Integer comLabelId) {
        this.comLabelId = comLabelId;
    }

    public Integer getComPostId() {
        return comPostId;
    }

    public void setComPostId(Integer comPostId) {
        this.comPostId = comPostId;
    }

    public String getComLabelName() {
        return comLabelName;
    }

    public void setComLabelName(String comLabelName) {
        this.comLabelName = comLabelName;
    }

    public Timestamp getComLabelTime() {
        return comLabelTime;
    }

    public void setComLabelTime(Timestamp comLabelTime) {
        this.comLabelTime = comLabelTime;
    }
}
