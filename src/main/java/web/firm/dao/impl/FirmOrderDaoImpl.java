package web.firm.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.firm.bean.FirmOrder;
import web.firm.dao.FirmOrderDao;

public class FirmOrderDaoImpl implements FirmOrderDao {

	@Override
	public List<FirmOrder> selectByFirmNo(Integer firmNo) {
		final String SQL = "select so.SHOP_ORDER_ID, so.SHOP_PRODUCT_ID ,so.MEMBER_NO,so.SHOP_ORDERCREATE_TIME ,so.SHOP_ORDERPAY_TIME, so.SHOP_ADDRESS,so.SHOP_RECIPIENT,so.SHOP_POINT_DISCOUNT,so.SHOP_ORDER_STATUS, sp.SHOP_PRODUCT_NAME , sp.FIRM_NO , sd.SHOP_PRODUCT_SALES ,sd.SHOP_ORDER_COUNT,spi.SHOP_PRODUCT_IMG "
				+ " from shop_order so"
				
				+ " join shop_order_desc sd"
				+ " on so.SHOP_ORDER_ID = sd.SHOP_ORDER_ID"
				
				+ " join SHOP_PRODUCT sp"
				+ " on so.SHOP_PRODUCT_ID = sp.SHOP_PRODUCT_ID"
				
				+ " join SHOP_PRODUCT_IMG spi"
				+ " on so.SHOP_PRODUCT_ID = spi.SHOP_PRODUCT_ID"
				+ " where sp.FIRM_NO = ?";
		List<FirmOrder> orderStatusList = new ArrayList<>();
		try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(SQL)
			){
			pstmt.setInt(1,firmNo );
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					FirmOrder firmOrder = new FirmOrder();
					firmOrder.setShopOrderId(rs.getInt("SHOP_ORDER_ID"));
					firmOrder.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
					firmOrder.setMemberNo(rs.getInt("MEMBER_NO"));
					firmOrder.setShopAdress(rs.getString("SHOP_ADDRESS"));
					firmOrder.setShopRecipient(rs.getString("SHOP_RECIPIENT"));
					firmOrder.setShopPointDiscount(rs.getInt("SHOP_POINT_DISCOUNT"));
					firmOrder.setShopOrderStatus(rs.getInt("SHOP_ORDER_STATUS"));
					firmOrder.setShopOrdercreateTime(rs.getTimestamp("SHOP_ORDERCREATE_TIME"));
					firmOrder.setShopOrderpayTime(rs.getTimestamp("SHOP_ORDERPAY_TIME"));
					firmOrder.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
					firmOrder.setShopProductSales(rs.getInt("SHOP_PRODUCT_SALES"));
					firmOrder.setShopOrderCount(rs.getInt("SHOP_ORDER_COUNT"));
					firmOrder.setFirmNo(rs.getInt("FIRM_NO"));
					firmOrder.setShopProductImg(rs.getBytes("SHOP_PRODUCT_IMG"));
					
					orderStatusList.add(firmOrder);
				}
				return orderStatusList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<FirmOrder> selectAll() {
		final String SQL = "select so.SHOP_ORDER_ID, so.SHOP_PRODUCT_ID ,so.MEMBER_NO,so.SHOP_ORDERCREATE_TIME ,so.SHOP_ORDERPAY_TIME, so.SHOP_ADDRESS,so.SHOP_RECIPIENT,so.SHOP_POINT_DISCOUNT,so.SHOP_ORDER_STATUS, sp.SHOP_PRODUCT_NAME , sp.FIRM_NO , sd.SHOP_PRODUCT_SALES ,sd.SHOP_ORDER_COUNT "
				+ " from shop_order so"
				+ " join shop_order_desc sd"
				+ " on so.SHOP_ORDER_ID = sd.SHOP_ORDER_ID"
				+ " join SHOP_PRODUCT sp"
				+ " on so.SHOP_PRODUCT_ID = sp.SHOP_PRODUCT_ID";
		List<FirmOrder> resultOrderList = new ArrayList<>();
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery()
			){
			while (rs.next()) {
				FirmOrder firmOrder = new FirmOrder();
				
				firmOrder.setShopOrderId(rs.getInt("SHOP_ORDER_ID"));//
				firmOrder.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));//
				firmOrder.setMemberNo(rs.getInt("MEMBER_NO"));//
				firmOrder.setShopAdress(rs.getString("SHOP_ADDRESS"));//
				firmOrder.setShopRecipient(rs.getString("SHOP_RECIPIENT"));//
				firmOrder.setShopPointDiscount(rs.getInt("SHOP_POINT_DISCOUNT"));//
				firmOrder.setShopOrderStatus(rs.getInt("SHOP_ORDER_STATUS"));//
				firmOrder.setShopOrdercreateTime(rs.getTimestamp("SHOP_ORDERCREATE_TIME"));//
				firmOrder.setShopOrderpayTime(rs.getTimestamp("SHOP_ORDERPAY_TIME"));//
				firmOrder.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));//
				firmOrder.setShopProductSales(rs.getInt("SHOP_PRODUCT_SALES"));//
				firmOrder.setShopOrderCount(rs.getInt("SHOP_ORDER_COUNT"));//
				firmOrder.setFirmNo(rs.getInt("FIRM_NO"));//
				//
				resultOrderList.add(firmOrder);
			}
			return resultOrderList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
