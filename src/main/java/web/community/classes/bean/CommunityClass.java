package web.community.classes.bean;

public class CommunityClass {
    private Integer comMainClassId;
    private String comMainClassName;
    private Integer comSecClassId;
    private String comSecClassName;

    @Override
    public String toString() {
        return "CommunityClass{" +
               "comMainClassId=" + comMainClassId +
               ", comMainClassName='" + comMainClassName + '\'' +
               ", comSecClassId=" + comSecClassId +
               ", comSecClassName='" + comSecClassName + '\'' +
               '}';
    }

    public Integer getComMainClassId() {
        return comMainClassId;
    }

    public void setComMainClassId(Integer comMainClassId) {
        this.comMainClassId = comMainClassId;
    }

    public String getComMainClassName() {
        return comMainClassName;
    }

    public void setComMainClassName(String comMainClassName) {
        this.comMainClassName = comMainClassName;
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

}
