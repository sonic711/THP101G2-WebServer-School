package web.community.post.bean;

public class PostLike {
    private Integer comPostLikeId;
    private Integer memberNo;
    private Integer comPostId;
    private Byte comPostEmotion;

    @Override
    public String toString() {
        return "PostLike{" +
               "comPostLikeId=" + comPostLikeId +
               ", memberNo=" + memberNo +
               ", comPostId=" + comPostId +
               ", comPostEmotion=" + comPostEmotion +
               '}';
    }

    public Integer getComPostLikeId() {
        return comPostLikeId;
    }

    public void setComPostLikeId(Integer comPostLikeId) {
        this.comPostLikeId = comPostLikeId;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getComPostId() {
        return comPostId;
    }

    public void setComPostId(Integer comPostId) {
        this.comPostId = comPostId;
    }

    public Byte getComPostEmotion() {
        return comPostEmotion;
    }

    public void setComPostEmotion(Byte comPostEmotion) {
        this.comPostEmotion = comPostEmotion;
    }
}
