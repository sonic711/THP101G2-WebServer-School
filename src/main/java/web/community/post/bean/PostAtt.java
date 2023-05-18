package web.community.post.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class PostAtt {
    private Integer comPostAttId;
    private Integer comPostId;
    private byte[] comPostAtt;
    private Timestamp comPostUploadTime;

    @Override
    public String toString() {
        return "PostAtt{" +
               "comPostAttId=" + comPostAttId +
               ", comPostId=" + comPostId +
               ", comPostAtt=" + Arrays.toString(comPostAtt) +
               ", comPostUploadTime=" + comPostUploadTime +
               '}';
    }

    public Integer getComPostAttId() {
        return comPostAttId;
    }

    public void setComPostAttId(Integer comPostAttId) {
        this.comPostAttId = comPostAttId;
    }

    public Integer getComPostId() {
        return comPostId;
    }

    public void setComPostId(Integer comPostId) {
        this.comPostId = comPostId;
    }

    public byte[] getComPostAtt() {
        return comPostAtt;
    }

    public void setComPostAtt(byte[] comPostAtt) {
        this.comPostAtt = comPostAtt;
    }

    public Timestamp getComPostUploadTime() {
        return comPostUploadTime;
    }

    public void setComPostUploadTime(Timestamp comPostUploadTime) {
        this.comPostUploadTime = comPostUploadTime;
    }
}
