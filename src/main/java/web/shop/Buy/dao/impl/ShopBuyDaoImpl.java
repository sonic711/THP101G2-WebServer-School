package web.shop.Buy.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.shop.Buy.bean.ShopBuy;
import web.shop.Buy.dao.ShopBuyDao;

public class ShopBuyDaoImpl implements ShopBuyDao {

	public int insert(ShopBuy shopBuy) {
		String SQL = "INSERT INTO SHOP_ORDER (SHOP_PRODUCT_ID, MEMBER_NO, SHOP_ADDRESS, SHOP_RECIPIENT, SHOP_ORDER_PHONE, SHOP_POINT_DISCOUNT, SHOP_PRODUCT_SALES, SHOP_PRODUCT_NAME,FIRM_NO,SHOP_ORDER_COUNT,SHOP_ORDER_IMG) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?,?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL);) {
			pstmt.setInt(1, shopBuy.getShopProductId());
			pstmt.setInt(2, shopBuy.getMemberNo());
			pstmt.setString(3, shopBuy.getShopAddress());
			pstmt.setString(4, shopBuy.getShopRecipient());
			pstmt.setString(5, shopBuy.getShopOrderPhone());
			pstmt.setInt(6,shopBuy.getShopPointDiscount());
			pstmt.setInt(7,shopBuy.getShopProductSales());
			pstmt.setString(8,shopBuy.getShopProductName());
			pstmt.setInt(9, shopBuy.getFirmNo());
			pstmt.setInt(10, shopBuy.getShopOrderCount());
			pstmt.setBytes(11, shopBuy.getShopOrderImage());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	// 查询数据
	public List<ShopBuy> selectAll() {
		String SQL = "SELECT so.SHOP_ORDER_ID,"
				+ "fp.SHOP_NAME,"
				+ "so.SHOP_PRODUCT_ID,"
				+ "so.MEMBER_NO,"
				+ "so.SHOP_ADDRESS,"
				+ "so.SHOP_RECIPIENT,"
				+ "so.SHOP_ORDER_PHONE,"
				+ "so.SHOP_POINT_DISCOUNT,"
				+ "so.SHOP_ORDER_STATUS,"
				+ "so.SHOP_PRODUCT_SALES,"
				+ "so.SHOP_PRODUCT_NAME,"
				+ "so.SHOP_ORDERCREATE_TIME,"
				+ "so.SHOP_ORDER_IMG "
				+ "FROM "
				+ "SHOP_ORDER so "
				+ "JOIN "
				+ "FIRM fp ON so.FIRM_NO = fp.FIRM_NO;";
		List<ShopBuy> shopBuyList = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL);

		) {
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ShopBuy shopBuy = new ShopBuy();
					shopBuy.setShopOrederImage(rs.getBytes("SHOP_ORDER_IMG"));
					shopBuy.setShopOrderId(rs.getInt("SHOP_ORDER_ID"));
					shopBuy.setShopName(rs.getString("SHOP_NAME"));
					shopBuy.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
					shopBuy.setMemberNo(rs.getInt("MEMBER_NO"));
					shopBuy.setShopAddress(rs.getString("SHOP_ADDRESS"));
					shopBuy.setShopRecipient(rs.getString("SHOP_RECIPIENT"));
					shopBuy.setShopOrderPhone(rs.getString("SHOP_ORDER_PHONE"));
					shopBuy.setShopPointDiscount(rs.getInt("SHOP_POINT_DISCOUNT"));
					shopBuy.setShopOrderStatus(rs.getInt("SHOP_ORDER_STATUS"));
					shopBuy.setShopProductSales(rs.getInt("SHOP_PRODUCT_SALES"));
					shopBuy.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
					shopBuy.setShopOrdercreateTime(rs.getTimestamp("SHOP_ORDERCREATE_TIME"));
					shopBuyList.add(shopBuy);
				}
			}
			return shopBuyList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// 更新数据
	public int update(ShopBuy shopBuy) {
		String SQL = "UPDATE SHOP_PRODUCT SET SHOP_PRODUCT_COUNT = ? "
					 + "WHERE SHOP_PRODUCT_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL);

		) {
			pstmt.setInt(1, shopBuy.getShopProductCount());
			pstmt.setInt(2, shopBuy.getShopProductId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 删除数据
	@Override
	public int delete(Integer id) {
		String SQL = "DELETE FROM SHOP_SHOPPING_CART WHERE SHOP_PRODUCT_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updatepoint(ShopBuy shopBuy) {
		String SQL = "UPDATE MEMBER SET REWARD_POINTS = ? "
				 + "WHERE MEMBER_NO = ?";
	try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL);

	) {
		pstmt.setInt(1, shopBuy.getRewardPoints());
		pstmt.setInt(2, shopBuy.getMemberNo());
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return -1;
	}
}
