package web.firm.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class FirmClass {

	@Override
	public String toString() {
		return "FirmClass [firmNo=" + firmNo + ", userId=" + userId + ", password=" + password + ", shopName="
				+ shopName + ", phoneNumber=" + phoneNumber + ", firmEmail=" + firmEmail + ", profilePhoto="
				+ Arrays.toString(profilePhoto) + ", coverPhoto=" + Arrays.toString(coverPhoto) + ", firmStatus="
				+ firmStatus + ", createAt=" + createAt + ", shopInfo=" + shopInfo + "]";
	}
	private Integer firmNo;
	private String  userId;
	private String  password;
	private String  shopName;
	private Integer phoneNumber;
	private String  firmEmail;
	private byte[]  profilePhoto;
	private byte[]  coverPhoto;
	private Integer firmStatus;
	private Timestamp createAt;
	private String  shopInfo;
	
	
	public Integer getFirmNo() {
		return firmNo;
	}
	public void setFirmNo(Integer firmNo) {
		this.firmNo = firmNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFirmEmail() {
		return firmEmail;
	}
	public void setFirmEmail(String firmEmail) {
		this.firmEmail = firmEmail;
	}
	public byte[] getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public byte[] getCoverPhoto() {
		return coverPhoto;
	}
	public void setCoverPhoto(byte[] coverPhoto) {
		this.coverPhoto = coverPhoto;
	}
	public Integer getFirmStatus() {
		return firmStatus;
	}
	public void setFirmStatus(Integer firmStatus) {
		this.firmStatus = firmStatus;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	public String getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(String shopInfo) {
		this.shopInfo = shopInfo;
	}
	
	

}
