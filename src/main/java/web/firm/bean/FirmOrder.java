package web.firm.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class FirmOrder {

	@Override
	public String toString() {
		return "FirmOrder [shopOrderId=" + shopOrderId + ", shopProductId=" + shopProductId + ", memberNo=" + memberNo
				+ ", shopAdress=" + shopAdress + ", shopRecipient=" + shopRecipient + ", shopPointDiscount="
				+ shopPointDiscount + ", shopOrderStatus=" + shopOrderStatus + ", shopOrdercreateTime="
				+ shopOrdercreateTime + ", shopOrderpayTime=" + shopOrderpayTime + ", shopProductName="
				+ shopProductName + ", shopProductPrice=" + shopProductPrice + ", shopProductSales=" + shopProductSales
				+ ", shopOrderCount=" + shopOrderCount + ", firmNo=" + firmNo + ", shopProductImg="
				+ Arrays.toString(shopProductImg) + "]";
	}

	Integer shopOrderId;
	Integer shopProductId;
	Integer memberNo;
	String shopAdress;
	String shopRecipient;
	Integer shopPointDiscount;
	Integer shopOrderStatus;
	Timestamp shopOrdercreateTime;
	Timestamp shopOrderpayTime;
	String shopProductName;
	Integer shopProductPrice;
	Integer shopProductSales;
	Integer shopOrderCount;
	Integer firmNo;
	byte[] shopProductImg;

	public Integer getShopOrderId() {
		return shopOrderId;
	}

	public void setShopOrderId(Integer shopOrderId) {
		this.shopOrderId = shopOrderId;
	}

	public Integer getShopProductId() {
		return shopProductId;
	}

	public void setShopProductId(Integer shopProductId) {
		this.shopProductId = shopProductId;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public String getShopAdress() {
		return shopAdress;
	}

	public void setShopAdress(String shopAdress) {
		this.shopAdress = shopAdress;
	}

	public String getShopRecipient() {
		return shopRecipient;
	}

	public void setShopRecipient(String shopRecipient) {
		this.shopRecipient = shopRecipient;
	}

	public Integer getShopPointDiscount() {
		return shopPointDiscount;
	}

	public void setShopPointDiscount(Integer shopPointDiscount) {
		this.shopPointDiscount = shopPointDiscount;
	}

	public Integer getShopOrderStatus() {
		return shopOrderStatus;
	}

	public void setShopOrderStatus(Integer shopOrderStatus) {
		this.shopOrderStatus = shopOrderStatus;
	}

	public Timestamp getShopOrdercreateTime() {
		return shopOrdercreateTime;
	}

	public void setShopOrdercreateTime(Timestamp shopOrdercreateTime) {
		this.shopOrdercreateTime = shopOrdercreateTime;
	}

	public Timestamp getShopOrderpayTime() {
		return shopOrderpayTime;
	}

	public void setShopOrderpayTime(Timestamp shopOrderpayTime) {
		this.shopOrderpayTime = shopOrderpayTime;
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

	public Integer getShopProductSales() {
		return shopProductSales;
	}

	public void setShopProductSales(Integer shopProductSales) {
		this.shopProductSales = shopProductSales;
	}

	public Integer getShopOrderCount() {
		return shopOrderCount;
	}

	public void setShopOrderCount(Integer shopOrderCount) {
		this.shopOrderCount = shopOrderCount;
	}

	public Integer getFirmNo() {
		return firmNo;
	}

	public void setFirmNo(Integer firmNo) {
		this.firmNo = firmNo;
	}

	public byte[] getShopProductImg() {
		return shopProductImg;
	}

	public void setShopProductImg(byte[] shopProductImg) {
		this.shopProductImg = shopProductImg;
	}

}
