package web.firm.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static core.util.CommonUtil.*;

import web.firm.bean.ShopProduct;
import web.firm.dao.ShopProductDao;

public class ShopProductDaoImpl implements ShopProductDao {
	
	/**
	 * 新增產品
	 */
	@Override
	public int insert(ShopProduct shopProductClass) {
		final String SQL = "insert into shop_product( SHOP_PRODUCT_NAME, SHOP_PRODUCT_PRICE,SHOP_PRODUCT_SEARCH,SHOP_PRODUCT_CLASS,SHOP_PRODUCT_DESC,SHOP_PRODUCT_COUNT,SHOP_NAME,FIRM_NO,SHOP_PRODUCT_IMG) " // 先取消SHOP_NAME,
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		System.out.println(shopProductClass);
		
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
//			pstmt.setInt(1, shopProductClass.getShopProductIdD());
			pstmt.setString(1, shopProductClass.getShopProductName());
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

	
	@Override
	public int update(ShopProduct shopProduct) {
		StringBuilder SQL = new StringBuilder("update shop_product set SHOP_PRODUCT_NAME =? ,SHOP_PRODUCT_PRICE = ? ,SHOP_PRODUCT_SEARCH = ?, SHOP_PRODUCT_CLASS = ?,SHOP_PRODUCT_DESC = ?,SHOP_PRODUCT_COUNT = ?, SHOP_NAME = ?,SHOP_PRODUCT_IMG = ? where SHOP_PRODUCT_ID = ? ");
//		Integer shopProductId = shopProduct.getShopProductId();
//		String shopProductName = shopProduct.getShopProductName();
//		String shopName = shopProduct.getShopName();
//		Integer shopProductPrice = shopProduct.getShopProductPrice();
//		String shopProductSearch = shopProduct.getShopProductSearch();
//		String shopProductClass = shopProduct.getShopProductClass();
//		String shopProductDesc = shopProduct.getShopProductDesc();
//		byte[] shopProductImg = shopProduct.getShopProductImg();
//		Integer firmNo = shopProduct.getFirmNo();

		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL.toString())
			) {
			pstmt.setString(1,shopProduct.getShopProductName() );
			pstmt.setInt(2,shopProduct.getShopProductPrice() );
			pstmt.setString(3, shopProduct.getShopProductSearch());
			pstmt.setString(4, shopProduct.getShopProductClass());
			pstmt.setString(5, shopProduct.getShopProductDesc());
			pstmt.setInt(6, shopProduct.getShopProductCount());
			pstmt.setString(7, shopProduct.getShopName());
			pstmt.setBytes(8, shopProduct.getShopProductImg());
			pstmt.setInt(9, shopProduct.getShopProductId());
			
			System.out.println("shopProduct: " + shopProduct);
			return pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateByProductStatus(ShopProduct shopProductStatus) {
		final String SQL = "update shop_product set SHOP_PRODUCT_STATUS = 1 where SHOP_PRODUCT_ID =?";
		
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, shopProductStatus.getShopProductId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 後臺專用
	@Override
	public List<ShopProduct> selectAll() {
		final String SQL = "select * from shop_product";
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
				+ " where FIRM_NO = ? and SHOP_PRODUCT_STATUS = 2"
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
	public List<ShopProduct> selectByFirmNo(Integer firmNo) {
		final String SQL = "select * from shop_product where FIRM_NO = ?";
		List<ShopProduct> resultList = new ArrayList<>();
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, firmNo);
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
	public ShopProduct selectByProductId(Integer shopProductId) {
		final String SQL = "select * from shop_product where SHOP_PRODUCT_ID = ?";
		try(
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, shopProductId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ShopProduct shopProduct = new ShopProduct();
					shopProduct.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
					shopProduct.setShopProductStatus(rs.getInt("SHOP_PRODUCT_STATUS"));
					
					return shopProduct;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
