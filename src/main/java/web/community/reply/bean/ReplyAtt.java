package web.community.reply.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class ReplyAtt {
    private Integer comReplyAttId;
    private Integer comReplyId;
    private byte[] comReplyAtt;
    private Timestamp comReplyUploadTime;

    @Override
    public String toString() {
        return "ReplyAtt{" +
               "comReplyAttId=" + comReplyAttId +
               ", comReplyId=" + comReplyId +
               ", comReplyAtt=" + Arrays.toString(comReplyAtt) +
               ", comReplyUploadTime=" + comReplyUploadTime +
               '}';
    }

    public Integer getComReplyAttId() {
        return comReplyAttId;
    }

    public void setComReplyAttId(Integer comReplyAttId) {
        this.comReplyAttId = comReplyAttId;
    }

    public Integer getComReplyId() {
        return comReplyId;
    }

    public void setComReplyId(Integer comReplyId) {
        this.comReplyId = comReplyId;
    }

    public byte[] getComReplyAtt() {
        return comReplyAtt;
    }

    public void setComReplyAtt(byte[] comReplyAtt) {
        this.comReplyAtt = comReplyAtt;
    }

    public Timestamp getComReplyUploadTime() {
        return comReplyUploadTime;
    }

    public void setComReplyUploadTime(Timestamp comReplyUploadTime) {
        this.comReplyUploadTime = comReplyUploadTime;
    }
}
