package web.firm.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class FirmClass {

	private Integer firmNo;
	private String userId;
	private String password;
	private String shopName;
	private String phoneNumber;
	private String firmEmail;
	private byte[] profilePhoto;
	private String profilePhoto64;
	private byte[] coverPhoto;
	private String coverPhoto64;
	private Integer firmStatus;
	private String shopInfo;
	private Timestamp createAt;

	@Override
	public String toString() {
		return "FirmClass [firmNo=" + firmNo + ", userId=" + userId + ", password=" + password + ", shopName="
				+ shopName + ", phoneNumber=" + phoneNumber + ", firmEmail=" + firmEmail + ", profilePhoto="
				+ Arrays.toString(profilePhoto) + ", profilePhoto64=" + profilePhoto64 + ", coverPhoto="
				+ Arrays.toString(coverPhoto) + ", coverPhoto64=" + coverPhoto64 + ", firmStatus=" + firmStatus
				+ ", shopInfo=" + shopInfo + ", createAt=" + createAt + "]";
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
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

	public String getProfilePhoto64() {
		return profilePhoto64;
	}

	public void setProfilePhoto64(String profilePhoto64) {
		this.profilePhoto64 = profilePhoto64;
	}

	public byte[] getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(byte[] coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public String getCoverPhoto64() {
		return coverPhoto64;
	}

	public void setCoverPhoto64(String coverPhoto64) {
		this.coverPhoto64 = coverPhoto64;
	}

	public Integer getFirmStatus() {
		return firmStatus;
	}

	public void setFirmStatus(Integer firmStatus) {
		this.firmStatus = firmStatus;
	}

	public String getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(String shopInfo) {
		this.shopInfo = shopInfo;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

}
