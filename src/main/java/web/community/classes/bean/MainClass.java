package web.community.classes.bean;

public class MainClass {
    private Integer comMainClassId;
    private String comMainClassName;

    public int getComMainClassId() {
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

    @Override
    public String toString() {
        return "SecClass{" +
               "comMainClassId=" + comMainClassId +
               ", comMainClassName='" + comMainClassName + '\'' +
               '}';
    }
}
