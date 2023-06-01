package web.shop.favorite.bean;

import java.util.Arrays;

public class ShopFavoriteAdd {
	
	private Integer shopProductId;
	private String shopProductName;
	private Integer shopProductPrice;
	private String shopProductSearch;
	private String shopProductClass;
	private String shopProductDesc;
	private Integer shopProductStatus;
	private Integer shopProductCount;
	private String shopName;
	private Integer firmNo;
	private Integer memberNo;
	private Integer shopFavoriteId;
	private byte[] shopProductImage;
	
	
	@Override
	public String toString() {
		return "ShopFavoriteAdd [shopProductId=" + shopProductId + ", shopProductName=" + shopProductName
				+ ", shopProductPrice=" + shopProductPrice + ", shopProductSearch=" + shopProductSearch
				+ ", shopProductClass=" + shopProductClass + ", shopProductDesc=" + shopProductDesc
				+ ", shopProductStatus=" + shopProductStatus + ", shopProductCount=" + shopProductCount + ", shopName="
				+ shopName + ", firmNo=" + firmNo + ", memberNo=" + memberNo + ", shopFavoriteId=" + shopFavoriteId
				+ ", shopProductImage=" + Arrays.toString(shopProductImage) + "]";
	}
	
	
	public Integer getShopFavoriteId() {
		return shopFavoriteId;
	}


	public void setShopFavoriteId(Integer shopFavoriteId) {
		this.shopFavoriteId = shopFavoriteId;
	}


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
	public byte[] getShopProductImage() {
		return shopProductImage;
	}
	public void setShopProductImage(byte[] shopProductImage) {
		this.shopProductImage = shopProductImage;
	}
	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
}
