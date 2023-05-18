package web.community.reply.bean;

public class ReplyLike {
    private Integer comReplyLikeId;
    private Integer memberNo;
    private Integer comReplyId;
    private Boolean comReplyEmotion;

    @Override
    public String toString() {
        return "ReplyLike{" +
               "comReplyLikeId=" + comReplyLikeId +
               ", memberNo=" + memberNo +
               ", comReplyId=" + comReplyId +
               ", comReplyEmotion=" + comReplyEmotion +
               '}';
    }

    public Integer getComReplyLikeId() {
        return comReplyLikeId;
    }

    public void setComReplyLikeId(Integer comReplyLikeId) {
        this.comReplyLikeId = comReplyLikeId;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getComReplyId() {
        return comReplyId;
    }

    public void setComReplyId(Integer comReplyId) {
        this.comReplyId = comReplyId;
    }

    public Boolean getComReplyEmotion() {
        return comReplyEmotion;
    }

    public void setComReplyEmotion(Boolean comReplyEmotion) {
        this.comReplyEmotion = comReplyEmotion;
    }
}
