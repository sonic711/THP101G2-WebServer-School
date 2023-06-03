package web.shop.shoppingcart.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.shop.favorite.bean.ShopFavoriteAdd;
import web.shop.shoppingcart.bean.ShoppingCart;
import web.shop.shoppingcart.dao.ShoppingCartDao;

public class ShoppingCartDaoImpl implements ShoppingCartDao{
	@Override
	public int insert(ShoppingCart shoppingcartadd) {
		final String SQL = "INSERT INTO SHOP_SHOPPING_CART(SHOP_SHOPPING_CART_ID, MEMBER_NO, SHOP_PRODUCT_ID,SHOP_ORDER_COUNT) VALUES (?, ?, ?, ?)";
	    	try (
	    		Connection conn = getConnection();
	    		PreparedStatement pstmt = conn.prepareStatement(SQL);
	    		) {
	    		pstmt.setInt(1, shoppingcartadd.getShoppingCartId());
				pstmt.setInt(2, shoppingcartadd.getMemberNo());
				pstmt.setInt(3, shoppingcartadd.getShopProductId());
				pstmt.setInt(4, shoppingcartadd.getShopOrderCount());
				return pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}

	@Override
	public int deleteByKey(Integer id) {
		final String SQL = "delete from SHOP_SHOPPING_CART where SHOP_PRODUCT_ID = ?";
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

	@Override
	public List<ShoppingCart> selectAllCartProducts() {
		final String SQL = "SELECT DISTINCT "
	    		+ "sp.SHOP_PRODUCT_ID,"
	    		+ "sp.SHOP_PRODUCT_NAME,"
	    		+ "sp.SHOP_NAME,"
	    		+ "sp.SHOP_PRODUCT_COUNT,"
	    		+ "sp.SHOP_PRODUCT_PRICE,"
	    		+ "spi.SHOP_PRODUCT_IMG "
	    		+ "FROM SHOP_SHOPPING_CART sc "
	    		+ "JOIN SHOP_PRODUCT sp ON sc.SHOP_PRODUCT_ID = sp.SHOP_PRODUCT_ID "
	    		+ "JOIN SHOP_PRODUCT_IMG spi ON sp.SHOP_PRODUCT_ID = spi.SHOP_PRODUCT_ID ";
        List<ShoppingCart> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	ShoppingCart shoppingCartProduct = new ShoppingCart();
                	shoppingCartProduct.setShopProductImage(rs.getBytes("SHOP_PRODUCT_IMG"));
                	shoppingCartProduct.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
                	shoppingCartProduct.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
                	shoppingCartProduct.setShopName(rs.getString("SHOP_NAME"));
                	shoppingCartProduct.setShopProductCount(rs.getInt("SHOP_PRODUCT_COUNT"));
                	shoppingCartProduct.setShopProductPrice(rs.getInt("SHOP_PRODUCT_PRICE")); 
                    resultList.add(shoppingCartProduct);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<ShoppingCart> selectCartProduct(Integer id) {
		final String SQL = "SELECT "
	    		+ "sp.SHOP_PRODUCT_ID,"
	    		+ "sp.SHOP_PRODUCT_NAME,"
	    		+ "sp.SHOP_NAME,"
	    		+ "sp.SHOP_PRODUCT_COUNT,"
	    		+ "sp.SHOP_PRODUCT_PRICE,"
	    		+ "spi.SHOP_PRODUCT_IMG "
	    		+ "FROM SHOP_SHOPPING_CART sc "
	    		+ "JOIN SHOP_PRODUCT sp ON sc.SHOP_PRODUCT_ID = sp.SHOP_PRODUCT_ID "
	    		+ "JOIN SHOP_PRODUCT_IMG spi ON sp.SHOP_PRODUCT_ID = spi.SHOP_PRODUCT_ID WHERE spi.SHOP_PRODUCT_ID = ?";
        List<ShoppingCart> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
        	pstmt.setInt(1,id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                	ShoppingCart shoppingCartProduct = new ShoppingCart();
                	shoppingCartProduct.setShopProductImage(rs.getBytes("SHOP_PRODUCT_IMG"));
                	shoppingCartProduct.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
                	shoppingCartProduct.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
                	shoppingCartProduct.setShopName(rs.getString("SHOP_NAME"));
                	shoppingCartProduct.setShopProductCount(rs.getInt("SHOP_PRODUCT_COUNT"));
                	shoppingCartProduct.setShopProductPrice(rs.getInt("SHOP_PRODUCT_PRICE")); 
                    resultList.add(shoppingCartProduct);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
