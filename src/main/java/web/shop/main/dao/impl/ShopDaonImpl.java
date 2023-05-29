package web.shop.main.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import web.shop.main.bean.ShopProduct;
import web.shop.main.dao.ShopDao;

public class ShopDaonImpl implements ShopDao {
	
	public int insert(ShopProduct shopProduct) {
		final String SQL = "insert into shop_product(SHOP_PRODUCT_ID,SHOP_PRODUCT_NAME,SHOP_PRODUCT_PRICE,SHOP_PRODUCT_SEARCH,SHOP_PRODUCT_CLASS,SHOP_PRODUCT_DESC,SHOP_PRODUCT_STATUS,SHOP_PRODUCT_COUNT,SHOP_NAME,FIRM_NO)"+
							"values(?,?,?,?,?,?,?,?,?,?)";
		 try (
	                Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(SQL)
	        ) {
	            pstmt.setInt(1, shopProduct.getShopProductId());
	            pstmt.setString(2, shopProduct.getShopProductName());
	            pstmt.setInt(3, shopProduct.getShopProductPrice());
	            pstmt.setString(4, shopProduct.getShopProductSearch());
	            pstmt.setString(5, shopProduct.getShopProductClass());
	            pstmt.setString(6, shopProduct.getShopProductDesc());
	            pstmt.setInt(7, shopProduct.getShopProductStatus());
	            pstmt.setInt(8, shopProduct.getShopProductCount());
	            pstmt.setString(9, shopProduct.getShopName());
	            pstmt.setInt(10, shopProduct.getFirmNo());
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -1;
	    }

	
	@Override
	public List<ShopProduct> selectAllByKey(ShopProduct productid) {
		  final String SQL = "select * from shop_product";
	        List<ShopProduct> resultList = new ArrayList<>();
	        try (
	                Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(SQL);
	        ) {
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

	@Override
	public List<ShopProduct> selectMainProduct(ShopProduct productid) {
		 final String SQL = "SELECT SHOP_PRODUCT.SHOP_PRODUCT_ID, SHOP_PRODUCT.SHOP_PRODUCT_NAME, SHOP_PRODUCT.SHOP_PRODUCT_PRICE, SHOP_PRODUCT_IMG.SHOP_PRODUCT_IMG"
		 		+ " FROM SHOP_PRODUCT"
		 		+ " JOIN SHOP_PRODUCT_IMG ON SHOP_PRODUCT.SHOP_PRODUCT_ID = SHOP_PRODUCT_IMG.SHOP_PRODUCT_ID";
	        List<ShopProduct> resultList = new ArrayList<>();
	        try (
	                Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(SQL);
	        ) {
	            try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                	ShopProduct shopProduct = new ShopProduct();
	                	shopProduct.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
	                	shopProduct.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
	                	shopProduct.setShopProductPrice(rs.getInt("SHOP_PRODUCT_PRICE"));
	                	shopProduct.setShopProductSearch(rs.getString("SHOP_PRODUCT_IMG"));
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
