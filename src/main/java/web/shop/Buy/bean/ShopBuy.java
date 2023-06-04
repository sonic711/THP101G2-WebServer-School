package web.shop.Buy.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class ShopBuy {
	
	private Integer shopProductId;
	private String shopProductName;
	private String shopAddress;
	private String shopRecipient;
	private Integer shopProductPrice;
	private String shopProductSearch;
	private String shopProductClass;
	private Integer shopPointDisCount;
	private Integer shopOrderStatus;
	private String shopProductDesc;
	private Integer shopProductStatus;
	private Integer shopProductCount;
	private String shopName;
	private Integer firmNo;
	private Integer memberNo;
	private Integer shopFavoriteId;
	private Integer shopProductSales;
	private byte[] shopProductImage;
	public Integer getShopProductId() {
		return shopProductId;
	}
	public void setShopProductId(Integer shopProductId) {
		this.shopProductId = shopProductId;
	}
	public String getShopProductName() {
		return shopProductName;
	}
	public void setShopProductName(String shopProductName) {
		this.shopProductName = shopProductName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopRecipient() {
		return shopRecipient;
	}
	public void setShopRecipient(String shopRecipient) {
		this.shopRecipient = shopRecipient;
	}
	public Integer getShopProductPrice() {
		return shopProductPrice;
	}
	public void setShopProductPrice(Integer shopProductPrice) {
		this.shopProductPrice = shopProductPrice;
	}
	public String getShopProductSearch() {
		return shopProductSearch;
	}
	public void setShopProductSearch(String shopProductSearch) {
		this.shopProductSearch = shopProductSearch;
	}
	public String getShopProductClass() {
		return shopProductClass;
	}
	public void setShopProductClass(String shopProductClass) {
		this.shopProductClass = shopProductClass;
	}
	public Integer getShopPointDisCount() {
		return shopPointDisCount;
	}
	public void setShopPointDisCount(Integer shopPointDisCount) {
		this.shopPointDisCount = shopPointDisCount;
	}
	public Integer getShopOrderStatus() {
		return shopOrderStatus;
	}
	public void setShopOrderStatus(Integer shopOrderStatus) {
		this.shopOrderStatus = shopOrderStatus;
	}
	public String getShopProductDesc() {
		return shopProductDesc;
	}
	public void setShopProductDesc(String shopProductDesc) {
		this.shopProductDesc = shopProductDesc;
	}
	public Integer getShopProductStatus() {
		return shopProductStatus;
	}
	public void setShopProductStatus(Integer shopProductStatus) {
		this.shopProductStatus = shopProductStatus;
	}
	public Integer getShopProductCount() {
		return shopProductCount;
	}
	public void setShopProductCount(Integer shopProductCount) {
		this.shopProductCount = shopProductCount;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getFirmNo() {
		return firmNo;
	}
	public void setFirmNo(Integer firmNo) {
		this.firmNo = firmNo;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public Integer getShopFavoriteId() {
		return shopFavoriteId;
	}
	public void setShopFavoriteId(Integer shopFavoriteId) {
		this.shopFavoriteId = shopFavoriteId;
	}
	public Integer getShopProductSales() {
		return shopProductSales;
	}
	public void setShopProductSales(Integer shopProductSales) {
		this.shopProductSales = shopProductSales;
	}
	public byte[] getShopProductImage() {
		return shopProductImage;
	}
	public void setShopProductImage(byte[] shopProductImage) {
		this.shopProductImage = shopProductImage;
	}
	@Override
	public String toString() {
		return "ShopBuy [shopProductId=" + shopProductId + ", shopProductName=" + shopProductName + ", shopAddress="
				+ shopAddress + ", shopRecipient=" + shopRecipient + ", shopProductPrice=" + shopProductPrice
				+ ", shopProductSearch=" + shopProductSearch + ", shopProductClass=" + shopProductClass
				+ ", shopPointDisCount=" + shopPointDisCount + ", shopOrderStatus=" + shopOrderStatus
				+ ", shopProductDesc=" + shopProductDesc + ", shopProductStatus=" + shopProductStatus
				+ ", shopProductCount=" + shopProductCount + ", shopName=" + shopName + ", firmNo=" + firmNo
				+ ", memberNo=" + memberNo + ", shopFavoriteId=" + shopFavoriteId + ", shopProductSales="
				+ shopProductSales + ", shopProductImage=" + Arrays.toString(shopProductImage) + "]";
	}
	
	

}
