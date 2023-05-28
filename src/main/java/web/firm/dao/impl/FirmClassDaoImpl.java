package web.firm.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

import web.firm.bean.FirmClass;
import web.firm.dao.FirmClassDao;

public class FirmClassDaoImpl implements FirmClassDao{

	@Override
	public int insert(FirmClass firmClass) {
		final String SQL = "insert into firm(FIRM_NO,"
				+ " USER_ID,"
				+ " PASSWORD,"
				+ "SHOP_NAME,"
				+ "PHONE_NUMBER,"
				+ "FIRM_EMAIL,"
				+ "PROFILE_PHOTO,"
				+ "COVER_PHOTO,"
				+ "SHOP_INFO) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, firmClass.getFirmNo());
			pstmt.setString(2, firmClass.getUserId());
			pstmt.setString(3, firmClass.getPassword());
			pstmt.setString(4, firmClass.getShopName());
			pstmt.setInt(5, firmClass.getPhoneNumber());
			pstmt.setString(6, firmClass.getFirmEmail());
			pstmt.setBytes(7, firmClass.getProfilePhoto());
			pstmt.setBytes(8, firmClass.getCoverPhoto());
			pstmt.setString(9, firmClass.getShopInfo());

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

	
}
