package web.shop.shoppingcart.bean;

import java.util.Arrays;

public class ShoppingCart {
	
	private String shopProductName;
	private Integer shopProductPrice;
	private String shopProductSearch;
	private String shopProductClass;
	private String shopProductDesc;
	private Integer shopProductStatus;
	private Integer shopProductCount;
	private Integer shopOrderCount;
	private String shopName;
	private Integer firmNo;
	private Integer memberNo;
	private Integer rewardPoints;
	private Integer shoppingCartId;
	private Integer shopProductId;
	private byte[] shopProductImage;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "ShoppingCart [shopProductName=" + shopProductName + ", shopProductPrice=" + shopProductPrice
				+ ", shopProductSearch=" + shopProductSearch + ", shopProductClass=" + shopProductClass
				+ ", shopProductDesc=" + shopProductDesc + ", shopProductStatus=" + shopProductStatus
				+ ", shopProductCount=" + shopProductCount + ", shopOrderCount=" + shopOrderCount + ", shopName="
				+ shopName + ", firmNo=" + firmNo + ", memberNo=" + memberNo + ", rewardPoints=" + rewardPoints
				+ ", shoppingCartId=" + shoppingCartId + ", shopProductId=" + shopProductId + ", shopProductImage="
				+ Arrays.toString(shopProductImage) + "]";
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
	public String getShopProductSearch() {
		return shopProductSearch;
	}
	public Integer getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
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
	public Integer getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(Integer shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public Integer getShopProductId() {
		return shopProductId;
	}
	public void setShopProductId(Integer shopProductId) {
		this.shopProductId = shopProductId;
	}
	public byte[] getShopProductImage() {
		return shopProductImage;
	}
	public void setShopProductImage(byte[] shopProductImage) {
		this.shopProductImage = shopProductImage;
	}
	
	
	
	
	
	
	
}
