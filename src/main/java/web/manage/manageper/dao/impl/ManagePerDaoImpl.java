package web.manage.manageper.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import web.manage.manageper.bean.Manageper;
import web.manage.manageper.dao.ManagePerDao;

public class ManagePerDaoImpl implements ManagePerDao {
	public int insert(Manageper manageper) {
        final String SQL = "insert into MANAGE_PER(MANAGE_COM, MANAGE_FIRM, MANAGE_COURSE, MANAGE_MEMBER, MANAGE_REPORT) "
                           + "values(?, ?, ?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setBoolean(1,  manageper.getManageCom());
            pstmt.setBoolean(2, manageper.getManageFirm());
            pstmt.setBoolean(3,manageper.getManageCourse());
            pstmt.setBoolean(4, manageper.getManageMember());
            pstmt.setBoolean(5,manageper.getManageReport());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
	
	 public int update(Manageper manageper) {
	        final String SQL = "update MANAGE_PER set "
	                           + "MANAGE_COM = ?, MANAGE_FIRM = ?, MANAGE_COURSE = ?, MANAGE_MEMBER = ?, MANAGE_REPORT = ? "
	                           ;
	        try (
	                Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(SQL)
	        ) {
	        	 pstmt.setBoolean(1,  manageper.getManageCom());
	             pstmt.setBoolean(2, manageper.getManageFirm());
	             pstmt.setBoolean(3,manageper.getManageCourse());
	             pstmt.setBoolean(4, manageper.getManageMember());
	             pstmt.setBoolean(5,manageper.getManageReport());

	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -1;
	    }
	 
	 public List<Manageper> selectAllByKey(Integer id) {
	        final String SQL = "select * from MANAGE_PER";
	        List<Manageper> resultList = new ArrayList<>();
	        try (
	                Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(SQL);
	        ) {
	            pstmt.setInt(1, id);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                	Manageper manageper = new Manageper();
	                	manageper.setManageCom(rs.getBoolean("MANAGE_COM"));
	                	manageper.setManageFirm(rs.getBoolean("MANAGE_FIRM"));
	                	manageper.setManageCourse(rs.getBoolean("MANAGE_COURSE"));
	                	manageper.setManageMember(rs.getBoolean("MANAGE_MEMBER"));
	                	manageper.setManageReport(rs.getBoolean("MANAGE_REPORT"));

	                    resultList.add(manageper);
	                }
	            }
	            return resultList;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	}
