package web.manage.manageallow.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import web.manage.manageallow.bean.Manageallow;
import web.manage.manageallow.dao.ManageAllowDao;

public class ManageAllowDaoImpl implements ManageAllowDao{
	 public int insert(Manageallow manageallow) {
	        final String SQL = "insert into MANAGE_ALLOW(ALLOW_ID, APPLY_ID, MANAGE_ID) "
	                           + "values(?, ?, ?)";
	        try (
	                Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(SQL)
	        ) {
	        	pstmt.setInt(1, manageallow.getManageAllowId());
	            pstmt.setInt(2, manageallow.getManageApplyId());
	            pstmt.setInt(3, manageallow.getManageId());
	            

	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -1;
	    }
	 
	 
	 public List<Manageallow> selectAllByKey(Integer id) {
	        final String SQL = "select * from  MANAGE_ALLOW where ALLOW_ID = ?";
	        List<Manageallow> resultList = new ArrayList<>();
	        try (
	                Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(SQL);
	        ) {
	            pstmt.setInt(1, id);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                	Manageallow manageallow = new Manageallow();
	                	manageallow.setManageAllowId(rs.getInt("ALLOW_ID"));
	                	manageallow.setManageApplyId(rs.getInt("APPLY_ID"));
	                	manageallow.setManageId(rs.getInt("MEMBER_ID"));
	                

	                    resultList.add(manageallow);
	                }
	            }
	            return resultList;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	

}
