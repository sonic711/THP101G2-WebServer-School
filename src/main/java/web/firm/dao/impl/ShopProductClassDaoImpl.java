package web.firm.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static core.util.CommonUtil.*;

import web.firm.bean.ShopProductClass;
import web.firm.dao.ShopProductClassDao;

public class ShopProductClassDaoImpl implements ShopProductClassDao {

	@Override
	public int insert(ShopProductClass shopProductClass) {
		final String SQL = "insert into shop_product(SHOP_PRODUCT_ID, SHOP_PRODUCT_NAME, SHOP_PRODUCT_PRICE,SHOP_PRODUCT_SEARCH,SHOP_PRODUCT_CLASS,SHOP_PRODUCT_DESC,SHOP_PRODUCT_COUNT,SHOP_NAME,FIRM_NO) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, shopProductClass.getShopProductId());
			pstmt.setString(2, shopProductClass.getShopName());
			pstmt.setInt(3, shopProductClass.getShopProductPrice());
			pstmt.setString(4, shopProductClass.getShopProductSearch());
			pstmt.setString(5, shopProductClass.getShopProductClass());
			pstmt.setString(6, shopProductClass.getShopProductDesc());
			pstmt.setInt(7, shopProductClass.getShopProductCount());
			pstmt.setString(8, shopProductClass.getShopName());
			pstmt.setInt(9, shopProductClass.getFirmNo());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 有問題待修改
	@Override
	public int update(ShopProductClass shopProduct) {
		String SQL = "update shop_product set";
		Integer SHOP_PRODUCT_ID = shopProduct.getShopProductId();
		String SHOP_PRODUCT_NAME = shopProduct.getShopName();
		Integer SHOP_PRODUCT_PRICE = shopProduct.getShopProductPrice();
		String SHOP_PRODUCT_SEARCH = shopProduct.getShopProductSearch();
		String SHOP_PRODUCT_CLASS = shopProduct.getShopProductClass();
		String SHOP_PRODUCT_DESC = shopProduct.getShopProductDesc();

		if (SHOP_PRODUCT_ID != null) {

			SQL += "SHOP_PRODUCT_NAME = ? ,SHOP_PRODUCT_PRICE = ?,SHOP_PRODUCT_SEARCH  =?,"
					+ "SHOP_PRODUCT_CLASS = ?,SHOP_PRODUCT_DESC =?,SHOP_PRODUCT_STATUS =? where SHOP_PRODUCT_ID = ?";
		}

		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			
			int offset = 0;
			if (SHOP_PRODUCT_NAME != null && !SHOP_PRODUCT_NAME.isEmpty()) {
				pstmt.setString(1, SHOP_PRODUCT_NAME);
				offset++;
			}
			if (SHOP_PRODUCT_PRICE != null) {
				pstmt.setInt(2, SHOP_PRODUCT_PRICE);
				offset++;
			}
			if (SHOP_PRODUCT_SEARCH != null && !SHOP_PRODUCT_NAME.isEmpty()) {
				pstmt.setString(3, SHOP_PRODUCT_SEARCH);
				offset++;
			}
			if (SHOP_PRODUCT_CLASS != null && !SHOP_PRODUCT_CLASS.isEmpty()) {
				pstmt.setString(4, SHOP_PRODUCT_CLASS);
				offset++;
			}
			if (SHOP_PRODUCT_DESC != null && !SHOP_PRODUCT_DESC.isEmpty()) {
				pstmt.setString(5, SHOP_PRODUCT_DESC);
				offset++;
			}

			pstmt.setString(1 + offset, shopProduct.getShopProductName());
			pstmt.setInt(2 + offset, shopProduct.getShopProductPrice());
			pstmt.setString(3 + offset, shopProduct.getShopProductSearch());
			pstmt.setString(4 + offset, shopProduct.getShopProductClass());
			pstmt.setString(5 + offset, shopProduct.getShopProductDesc());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateByProductStatus(ShopProductClass shopProductStatus) {
		final String SQL = "update shop_product set SHOP_PRODUCT_STATUS = ? where SHOP_PRODUCT_ID =?";
		
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, shopProductStatus.getShopProductStatus());
			pstmt.setInt(2, shopProductStatus.getShopProductId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 後臺專用
	@Override
	public List<ShopProductClass> selectAll() {
		final String SQL = "select * from shop_product";
		List<ShopProductClass> resultList = new ArrayList<>();
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				ShopProductClass shopProduct = new ShopProductClass();
				shopProduct.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
				shopProduct.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
				shopProduct.setShopProductPrice(rs.getInt("SHOP_PRODUCT_PRICE"));
				shopProduct.setShopProductSearch(rs.getString("SHOP_PRODUCT_SEARCH"));
				shopProduct.setShopProductClass(rs.getString("SHOP_PRODUCT_CLASS"));
				shopProduct.setShopProductDesc(rs.getString("SHOP_PRODUCT_DESC"));
				shopProduct.setShopProductStatus(rs.getInt("SHOP_PRODUCT_STATUS"));
				shopProduct.setShopProductCount(rs.getInt("SHOP_PRODUCT_COUNT"));
				shopProduct.setShopName(rs.getString("SHOP_NAME"));
				shopProduct.setFirmNo(rs.getInt("FIRM_NO"));

				resultList.add(shopProduct);
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteByStatus(Integer shopProductStatusD) {
		final String SQL = "delete from SHOP_PRODUCT where from SHOP_PRODUCT_STATUS = 1 or SHOP_PRODUCT_STATUS =0";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			) {
			pstmt.setInt(1, shopProductStatusD);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<ShopProductClass> selectByProductFirmNo(Integer shopProductFirmNo) {
		final String SQL = "select * from shop_product where FIRM_NO = ?";
		List<ShopProductClass> resultList = new ArrayList<>();
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, shopProductFirmNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ShopProductClass shopProduct = new ShopProductClass();
					shopProduct.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
					shopProduct.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
					shopProduct.setShopProductPrice(rs.getInt("SHOP_PRODUCT_PRICE"));
					shopProduct.setShopProductSearch(rs.getString("SHOP_PRODUCT_SEARCH"));
					shopProduct.setShopProductClass(rs.getString("SHOP_PRODUCT_CLASS"));
					shopProduct.setShopProductDesc(rs.getString("SHOP_PRODUCT_DESC"));
					shopProduct.setShopProductStatus(rs.getInt("SHOP_PRODUCT_STATUS"));
					shopProduct.setShopProductCount(rs.getInt("SHOP_PRODUCT_COUNT"));
					shopProduct.setShopName(rs.getString("SHOP_NAME"));
					shopProduct.setFirmNo(rs.getInt("FIRM_NO"));

					resultList.add(shopProduct);
				}
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ShopProductClass> selectByProductStatus(Integer shopProductStatus) {
		final String SQL = "select * from shop_product where SHOP_PRODUCT_STATUS = ?";
		List<ShopProductClass> resultList = new ArrayList<>();
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, shopProductStatus);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ShopProductClass shopProduct = new ShopProductClass();
					shopProduct.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
					shopProduct.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
					shopProduct.setShopProductPrice(rs.getInt("SHOP_PRODUCT_PRICE"));
					shopProduct.setShopProductSearch(rs.getString("SHOP_PRODUCT_SEARCH"));
					shopProduct.setShopProductClass(rs.getString("SHOP_PRODUCT_CLASS"));
					shopProduct.setShopProductDesc(rs.getString("SHOP_PRODUCT_DESC"));
					shopProduct.setShopProductStatus(rs.getInt("SHOP_PRODUCT_STATUS"));
					shopProduct.setShopProductCount(rs.getInt("SHOP_PRODUCT_COUNT"));
					shopProduct.setShopName(rs.getString("SHOP_NAME"));
					shopProduct.setFirmNo(rs.getInt("FIRM_NO"));

					resultList.add(shopProduct);
				}
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
