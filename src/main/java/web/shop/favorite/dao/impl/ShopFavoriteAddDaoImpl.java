package web.shop.favorite.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static core.util.CommonUtil.getConnection;

import web.community.post.bean.PostLabel;
import web.shop.favorite.bean.ShopFavoriteAdd;
import web.shop.favorite.dao.ShopFavoriteAddDao;

public class ShopFavoriteAddDaoImpl  implements ShopFavoriteAddDao{

	@Override
	public int insert(ShopFavoriteAdd shopfavoriteadd) {
		final String SQL = "INSERT INTO SHOP_MYFAVOURIRE(SHOP_MYFAVOURIRE_ID, MEMBER_NO, SHOP_PRODUCT_ID) VALUES (?, ?, ?)";
	    	try (
	    		Connection conn = getConnection();
	    		PreparedStatement pstmt = conn.prepareStatement(SQL);
	    		) {
	    		pstmt.setInt(1, shopfavoriteadd.getShopFavoriteId());
				pstmt.setInt(2, shopfavoriteadd.getMemberNo());
				pstmt.setInt(3, shopfavoriteadd.getShopProductId());
				return pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}


	@Override
	public List<ShopFavoriteAdd> selectFavoriteProduct(Integer favoriteproductid) {
		final String SQL = "SELECT sp.SHOP_PRODUCT_IMG,sp.SHOP_PRODUCT_ID, sp.SHOP_PRODUCT_NAME, sp.SHOP_NAME "
				+ "FROM SHOP_MYFAVOURIRE sm "
				+ "JOIN SHOP_PRODUCT sp ON sm.SHOP_PRODUCT_ID = sp.SHOP_PRODUCT_ID "
				+ "WHERE sp.SHOP_PRODUCT_ID = ? ";
        List<ShopFavoriteAdd> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
        	pstmt.setInt(1,favoriteproductid);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {	
                	ShopFavoriteAdd shopFavoriteProduct = new ShopFavoriteAdd();
                	shopFavoriteProduct.setShopProductImage(rs.getBytes("SHOP_PRODUCT_IMG"));
                	shopFavoriteProduct.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
                	shopFavoriteProduct.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
                	shopFavoriteProduct.setShopName(rs.getString("SHOP_NAME"));
                    resultList.add(shopFavoriteProduct);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public List<ShopFavoriteAdd> selectAllFavoriteProducts() {
	    final String SQL = "SELECT sp.SHOP_PRODUCT_IMG,sp.SHOP_PRODUCT_ID, sp.SHOP_PRODUCT_NAME, sp.SHOP_NAME "
	    		+ "FROM SHOP_MYFAVOURIRE sm "
	    		+ "JOIN SHOP_PRODUCT sp ON sm.SHOP_PRODUCT_ID = sp.SHOP_PRODUCT_ID ";
	    List<ShopFavoriteAdd> resultList = new ArrayList<>();
	    try (
	            Connection conn = getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(SQL);
	    ) {
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                ShopFavoriteAdd shopFavoriteProduct = new ShopFavoriteAdd();
	                shopFavoriteProduct.setShopProductImage(rs.getBytes("SHOP_PRODUCT_IMG"));
	                shopFavoriteProduct.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
	                shopFavoriteProduct.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
	                shopFavoriteProduct.setShopName(rs.getString("SHOP_NAME"));
	                resultList.add(shopFavoriteProduct);
	            }
	        }
	        return resultList;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}


	@Override
	public int deleteByKey(Integer id) {
		 final String SQL = "delete from SHOP_MYFAVOURIRE where SHOP_PRODUCT_ID = ?";
	        try (
	                Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(SQL)
	        ) {
	            pstmt.setInt(1, id);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -1;
	}
	
}


