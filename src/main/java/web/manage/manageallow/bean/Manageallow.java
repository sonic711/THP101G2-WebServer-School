package web.manage.manageallow.bean;

public class Manageallow {
	private Integer manageAllowId;
	private Integer	manageApplyId; 
	private Integer manageId ;
	
	public Integer getManageAllowId() {
		return manageAllowId;
	}
	public void setManageAllowId(Integer manageAllowId) {
		this.manageAllowId = manageAllowId;
	}
	public Integer getManageApplyId() {
		return manageApplyId;
	}
	public void setManageApplyId(Integer manageApplyId) {
		this.manageApplyId = manageApplyId;
	}
	public Integer getManageId() {
		return manageId;
	}
	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}
	@Override
	public String toString() {
		return "Manageallow [manageAllowId=" + manageAllowId + ", manageApplyId=" + manageApplyId + ", manageId="
				+ manageId + "]";
	}
	
	
}
