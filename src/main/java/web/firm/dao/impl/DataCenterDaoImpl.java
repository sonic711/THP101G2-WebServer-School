package web.firm.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.firm.bean.DataCenter;
import web.firm.bean.FirmOrder;
import web.firm.dao.DataCenterDao;

public class DataCenterDaoImpl implements DataCenterDao {

	// 查全部
	@Override
	public List<DataCenter> selectAll() {
		final String SQL = "select FIRM_NO,SHOP_PRODUCT_ID, SHOP_PRODUCT_NAME, sum(SHOP_ORDER_COUNT) as allCount," 
				+ " sum(SHOP_PRODUCT_SALES) as sumSales"
				+ " from shop_order " 
				+ " group by" 
				+ " SHOP_PRODUCT_ID,SHOP_PRODUCT_NAME,FIRM_NO";
			// 要有東西才能夠抓，所以有要顯示的都要查詢
		List<DataCenter> dataList = new ArrayList<>();
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery()
			) {
			while (rs.next()) {
				DataCenter dataCenter = new DataCenter();
				dataCenter.setFirmNo(rs.getInt("FIRM_NO"));
				dataCenter.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
				dataCenter.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
				dataCenter.setShopProductSales(rs.getInt("sumSales"));
				dataCenter.setShopOrderCount(rs.getInt("allCount"));

				dataList.add(dataCenter);
			}
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DataCenter> selectByFirmNo(Integer firmNo) {
		final String SQL = "select FIRM_NO,SHOP_PRODUCT_ID,SHOP_PRODUCT_NAME, sum(SHOP_ORDER_COUNT) as allCount, sum(SHOP_PRODUCT_SALES) as sumSales"
				+ " from shop_order "
				+ " where FIRM_NO = ?"
				+ " group by SHOP_PRODUCT_ID, SHOP_PRODUCT_NAME" ;
				
		List<DataCenter> dataProductIdList = new ArrayList<>();
		try (
				Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(SQL)
			) {
			pstmt.setInt(1, firmNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					DataCenter dataProductIdCenter = new DataCenter();
					dataProductIdCenter.setShopProductId(rs.getInt("SHOP_PRODUCT_ID"));
					dataProductIdCenter.setShopProductName(rs.getString("SHOP_PRODUCT_NAME"));
					dataProductIdCenter.setShopProductSales(rs.getInt("sumSales"));
					dataProductIdCenter.setShopOrderCount(rs.getInt("allCount"));
					dataProductIdCenter.setFirmNo(rs.getInt("FIRM_NO"));

					dataProductIdList.add(dataProductIdCenter);
				}
				return dataProductIdList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
