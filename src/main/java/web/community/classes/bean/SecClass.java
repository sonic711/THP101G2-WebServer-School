package web.community.classes.bean;

public class SecClass extends CommunityClass{
    private Integer comSecClassId;
    private String comSecClassName;
    private Integer comMainClassId;

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

    public Integer getComMainClassId() {
        return comMainClassId;
    }

    public void setComMainClassId(Integer comMainClassId) {
        this.comMainClassId = comMainClassId;
    }

    @Override
    public String toString() {
        return "SecClass{" +
               "comSecClassId=" + comSecClassId +
               ", comSecClassName='" + comSecClassName + '\'' +
               ", comMainClassId=" + comMainClassId +
               '}';
    }
}
