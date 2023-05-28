package web.firm.bean;

public class ShopProductClass {

	
	@Override
	public String toString() {
		return "ShopProductClass [shopProductId=" + shopProductId + ", shopProductName=" + shopProductName
				+ ", shopProductPrice=" + shopProductPrice + ", shopProductSearch=" + shopProductSearch
				+ ", shopProductClass=" + shopProductClass + ", shopProductDesc=" + shopProductDesc
				+ ", shopProductStatus=" + shopProductStatus + ", shopProductCount=" + shopProductCount + ", shopName="
				+ shopName + ", firmNo=" + firmNo + "]";
	}
	private Integer shopProductId;
	private String  shopProductName;
	private Integer shopProductPrice;
	private String  shopProductSearch;
	private String  shopProductClass;
	private String  shopProductDesc;
	private Integer shopProductStatus;
	private Integer shopProductCount;
	private String  shopName;
	private Integer firmNo;
	
	
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


}
