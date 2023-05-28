package web.firm.bean;

import java.sql.Timestamp;

public class DataCenter {

	@Override
	public String toString() {
		return "DataCenter [shopOrderDescId=" + shopOrderDescId + ", shopOrderId=" + shopOrderId + ", shopOrderCount="
				+ shopOrderCount + ", shopProductName=" + shopProductName + ", shopProductPrice=" + shopProductPrice
				+ ", shopProductId=" + shopProductId + ", firmNo=" + firmNo + "]";
	}

	Integer shopOrderDescId;
	Integer shopOrderId;
	Integer shopOrderCount;
	String shopProductName;
	Integer shopProductPrice;
	Integer shopProductId;
	Integer firmNo;

	public Integer getShopOrderDescId() {
		return shopOrderDescId;
	}

	public void setShopOrderDescId(Integer shopOrderDescId) {
		this.shopOrderDescId = shopOrderDescId;
	}

	public Integer getShopOrderId() {
		return shopOrderId;
	}

	public void setShopOrderId(Integer shopOrderId) {
		this.shopOrderId = shopOrderId;
	}

	public Integer getShopOrderCount() {
		return shopOrderCount;
	}

	public void setShopOrderCount(Integer shopOrderCount) {
		this.shopOrderCount = shopOrderCount;
	}

	public String getShopProductName() {
		return shopProductName;
	}

	public void setShopProductName(String shopProductName) {
		this.shopProductName = shopProductName;
	}

	public Integer getShopProductPrice() {
		return shopProductPrice;
	}

	public void setShopProductPrice(Integer shopProductPrice) {
		this.shopProductPrice = shopProductPrice;
	}

	public Integer getShopProductId() {
		return shopProductId;
	}

	public void setShopProductId(Integer shopProductId) {
		this.shopProductId = shopProductId;
	}

	public Integer getFirmNo() {
		return firmNo;
	}

	public void setFirmNo(Integer firmNo) {
		this.firmNo = firmNo;
	}

}
