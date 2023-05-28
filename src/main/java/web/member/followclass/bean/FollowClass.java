package web.member.followclass.bean;

public class FollowClass {
    private Integer memberFollowBoardId;
    private Integer memberNo;
    private Integer comSecClassId;

    @Override
    public String toString() {
        return "FollowClass{" +
               "memberFollowBoardId=" + memberFollowBoardId +
               ", memberNo=" + memberNo +
               ", comSecClassId=" + comSecClassId +
               '}';
    }

    public Integer getMemberFollowBoardId() {
        return memberFollowBoardId;
    }

    public void setMemberFollowBoardId(Integer memberFollowBoardId) {
        this.memberFollowBoardId = memberFollowBoardId;
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
}
