package web.firm.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static core.util.CommonUtil.*;

import web.firm.bean.ShopProduct;
import web.firm.dao.ShopProductDao;

public class ShopProductDaoImpl implements ShopProductDao {



	
	/**
	 * 新增產品
	 */
	// 取消賣家名稱的新增，因為設定->賣家設定裡可以新增、修改賣家名稱，若產品可以新增編輯賣家名稱會大亂
	@Override
	public int insert(ShopProduct shopProductClass) {
		final String SQL = "insert into shop_product(SHOP_PRODUCT_ID, SHOP_PRODUCT_NAME, SHOP_PRODUCT_PRICE,SHOP_PRODUCT_SEARCH,SHOP_PRODUCT_CLASS,SHOP_PRODUCT_DESC,SHOP_PRODUCT_COUNT,FIRM_NO) " // 先取消SHOP_NAME,
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, shopProductClass.getShopProductId());
//			pstmt.setString(2, shopProductClass.getShopName());
			pstmt.setInt(2, shopProductClass.getShopProductPrice());
			pstmt.setString(3, shopProductClass.getShopProductSearch());
			pstmt.setString(4, shopProductClass.getShopProductClass());
			pstmt.setString(5, shopProductClass.getShopProductDesc());
			pstmt.setInt(6, shopProductClass.getShopProductCount());
			pstmt.setString(7, shopProductClass.getShopName());
			pstmt.setInt(8, shopProductClass.getFirmNo());
			pstmt.setBytes(9, shopProductClass.getShopProductImg());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 有問題待修改
	@Override
	public int update(ShopProduct shopProduct) {
		StringBuilder SQL = new StringBuilder("update shop_product set");
		Integer shopProductId = shopProduct.getShopProductId();
		String shopProductName = shopProduct.getShopName();
		String shopName = shopProduct.getShopName();
		Integer shopProductPrice = shopProduct.getShopProductPrice();
		String shopProductSearch = shopProduct.getShopProductSearch();
		String shopProductClass = shopProduct.getShopProductClass();
		String shopProductDesc = shopProduct.getShopProductDesc();
		



		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL.toString())
			) {
			
			int offset = 0;
			
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateByProductStatus(ShopProduct shopProductStatus) {
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
	public List<ShopProduct> selectAll() {
		final String SQL = "select * from shop_product"
						+ " join shop_product_img"
						+ " on shop_product.SHOP_PRODUCT_ID = shop_product_img.SHOP_PRODUCT_ID"
						+ " join firm"
						+ " on shop_product.FIRM_NO = firm.FIRM_NO";
		List<ShopProduct> resultList = new ArrayList<>();
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				ShopProduct shopProduct = new ShopProduct();
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
				
				shopProduct.setShopProductImg(rs.getBytes("SHOP_PRODUCT_IMG"));
			

				resultList.add(shopProduct);
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<ShopProduct> selectByProductFirmNo(Integer shopProductFirmNo) {
		final String SQL = "select * from shop_product"
				+ " join shop_product_img"
				+ " on shop_product.SHOP_PRODUCT_ID = shop_product_img.SHOP_PRODUCT_ID"
				+ " join firm"
				+ " on shop_product.FIRM_NO = firm.FIRM_NO"
				+ " where shop_product.FIRM_NO = ? and shop_product.SHOP_PRODUCT_STATUS = 2"
			;
		
		List<ShopProduct> resultList = new ArrayList<>();
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, shopProductFirmNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ShopProduct shopProduct = new ShopProduct();
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
					
					

					
					shopProduct.setShopProductImg(rs.getBytes("SHOP_PRODUCT_IMG"));

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
	public List<ShopProduct> selectByProductStatus(Integer shopProductStatus) {
		final String SQL = "select * from shop_product where SHOP_PRODUCT_STATUS = ?";
		List<ShopProduct> resultList = new ArrayList<>();
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, shopProductStatus);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ShopProduct shopProduct = new ShopProduct();
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
