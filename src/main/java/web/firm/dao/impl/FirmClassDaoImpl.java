package web.firm.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.firm.bean.FirmClass;
import web.firm.dao.FirmClassDao;

public class FirmClassDaoImpl implements FirmClassDao{

	@Override
	public int insert(FirmClass firmClass) {
		final String SQL = "insert into FIRM(FIRM_NO, "
				+ "USER_ID, "
				+ "PASSWORD, "
				+ "SHOP_NAME, "
				+ "PHONE_NUMBER, "
				+ "FIRM_EMAIL)"
				+ "values(?, ?, ?, ?, ?, ?)";
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, firmClass.getFirmNo());
			pstmt.setString(2, firmClass.getUserId());
			pstmt.setString(3, firmClass.getPassword());
			pstmt.setString(4, firmClass.getShopName());
			pstmt.setString(5, firmClass.getPhoneNumber());
			pstmt.setString(6, firmClass.getFirmEmail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	

	@Override
	public int update(FirmClass firmClass) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public FirmClass selectByEmail(String email) {
		String sql = "select * from FIRM where FIRM_EMAIL = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setString(1, email);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					FirmClass firm = new FirmClass();
					firm.setFirmNo(rs.getInt("FIRM_NO"));
					firm.setUserId(rs.getString("USER_ID"));
					firm.setPassword(rs.getString("PASSWORD"));
					firm.setShopName(rs.getString("SHOP_NAME"));
					firm.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					firm.setFirmEmail(rs.getString("FIRM_EMAIL"));
					firm.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					firm.setCoverPhoto(rs.getBytes("COVER_PHOTO"));
					firm.setFirmStatus(rs.getInt("FIRM_STATUS"));
					firm.setCreateAt(rs.getTimestamp("CREATE_AT"));
					firm.setShopInfo(rs.getString("SHOP_INFO"));
					return firm;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<FirmClass> selectAll() {
		String sql = "select * from FIRM";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			) { 
				List<FirmClass> list = new ArrayList<>();
				while (rs.next()) {
					FirmClass firm = new FirmClass();
					firm.setFirmNo(rs.getInt("FIRM_NO"));
					firm.setUserId(rs.getString("USER_ID"));
					firm.setPassword(rs.getString("PASSWORD"));
					firm.setShopName(rs.getString("SHOP_NAME"));
					firm.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					firm.setFirmEmail(rs.getString("FIRM_EMAIL"));
					firm.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					firm.setCoverPhoto(rs.getBytes("COVER_PHOTO"));
					firm.setFirmStatus(rs.getInt("FIRM_STATUS"));
					firm.setCreateAt(rs.getTimestamp("CREATE_AT"));
					firm.setShopInfo(rs.getString("SHOP_INFO"));
					list.add(firm);
				}
				return list;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}


	@Override
	public FirmClass selectByUserId(String userId) {
String sql = "select * from FIRM where USER_ID = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setString(1, userId);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					FirmClass firm = new FirmClass();
					firm.setFirmNo(rs.getInt("FIRM_NO"));
					firm.setUserId(rs.getString("USER_ID"));
					firm.setPassword(rs.getString("PASSWORD"));
					firm.setShopName(rs.getString("SHOP_NAME"));
					firm.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					firm.setFirmEmail(rs.getString("FIRM_EMAIL"));
					firm.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					firm.setCoverPhoto(rs.getBytes("COVER_PHOTO"));
					firm.setFirmStatus(rs.getInt("FIRM_STATUS"));
					firm.setCreateAt(rs.getTimestamp("CREATE_AT"));
					firm.setShopInfo(rs.getString("SHOP_INFO"));
					return firm;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public FirmClass selectByPhone(String phone) {
		String sql = "select * from FIRM where PHONE_NUMBER = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setString(1, phone);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					FirmClass firm = new FirmClass();
					firm.setFirmNo(rs.getInt("FIRM_NO"));
					firm.setPassword(rs.getString("PASSWORD"));
					firm.setUserId(rs.getString("USER_ID"));
					
					firm.setShopName(rs.getString("SHOP_NAME"));
					firm.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					firm.setFirmEmail(rs.getString("FIRM_EMAIL"));
					firm.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					firm.setCoverPhoto(rs.getBytes("COVER_PHOTO"));
					firm.setFirmStatus(rs.getInt("FIRM_STATUS"));
					firm.setCreateAt(rs.getTimestamp("CREATE_AT"));
					firm.setShopInfo(rs.getString("SHOP_INFO"));
					return firm;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public FirmClass selectByEmailAndPassword(String email, String password) {
		String sql = "select * from FIRM where FIRM_EMAIL = ? and PASSWORD = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					FirmClass firm = new FirmClass();
					firm.setFirmNo(rs.getInt("FIRM_NO"));
					firm.setUserId(rs.getString("USER_ID"));
					firm.setPassword(rs.getString("PASSWORD"));
					firm.setShopName(rs.getString("SHOP_NAME"));
					firm.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					firm.setFirmEmail(rs.getString("FIRM_EMAIL"));
					firm.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					firm.setCoverPhoto(rs.getBytes("COVER_PHOTO"));
					firm.setFirmStatus(rs.getInt("FIRM_STATUS"));
					firm.setCreateAt(rs.getTimestamp("CREATE_AT"));
					firm.setShopInfo(rs.getString("SHOP_INFO"));
					return firm;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
