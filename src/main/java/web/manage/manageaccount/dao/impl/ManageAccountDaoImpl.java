package web.manage.manageaccount.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.course.course.bean.Course;
import web.manage.manageaccount.bean.Manageaccount;
import web.manage.manageaccount.dao.ManageAccountDao;

public class ManageAccountDaoImpl implements ManageAccountDao{
	
	public int insert(Manageaccount manageaccount) {
		final String SQL ="insert into MANAGE_ACCOUNT(MANAGE_ID, MANAGE_AC, MANAGE_PASS, MANAGE_NAME)"
				+ "values(?, ?, ?, ?)";
		try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
		) {
            pstmt.setInt(1, manageaccount.getManageId());
            pstmt.setInt(2, manageaccount.getManageAc());
            pstmt.setInt(3, manageaccount.getManagePass());
            pstmt.setString(4, manageaccount.getManageName());
            
            
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
	}

	@Override
	public int update(Manageaccount manageaccount) {
		final String SQL ="update MANAGE_ACCOUNT set"
						+ "MANAGE_PASS = ?,"
						+ "MANAGE_NAME = ? WHERE MANAGE_ID = ?";
		try (
				    Connection conn = getConnection();
				    PreparedStatement pstmt = conn.prepareStatement(SQL)
			 ) {
				
			pstmt.setInt(1, manageaccount.getManagePass());
            pstmt.setString(2, manageaccount.getManageName());
            
	            
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return 0;
	}
	
	public List<Manageaccount> selectAllByKey(Integer id) {
		final String SQL = "select * from MANAGE_ACCOUNT where MANAGE_ID = ?";
		List<Manageaccount> resultList = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Manageaccount manageaccount = new Manageaccount();
					manageaccount.setManageId(rs.getInt("COURSE_ID"));
					manageaccount.setManageAc(rs.getInt("COURSE_NAME"));
					manageaccount.setManagePass(rs.getInt("MEMBER_NO"));
					 manageaccount.setManageName(rs.getString("SUMMARY"));
				    resultList.add(manageaccount);
                }
            }
            return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public List<Manageaccount> selectAll() {
	    final String SQL = "SELECT MA.MANAGE_ID, MA.MANAGE_AC, MA.MANAGE_PASS, MA.MANAGE_NAME,\r\n"
	    		+ "MAL.MANAGE_APPLY_ID, MP.MANAGE_COM, MP.MANAGE_FIRM, MP.MANAGE_COURSE,\r\n"
	    		+ "MP.MANAGE_MEMBER, MP.MANAGE_REPORT\r\n"
	    		+ "FROM MANAGE_ACCOUNT MA\r\n"
	    		+ "JOIN MANAGE_ALLOW MAL ON MA.MANAGE_ID = MAL.MANAGE_ID\r\n"
	    		+ "JOIN MANAGE_PER MP ON MAL.MANAGE_APPLY_ID = MP.MANAGE_APPLY_ID;";
	    List<Manageaccount> resultList = new ArrayList<>();
	    try (
	        Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(SQL);
	    	ResultSet rs = pstmt.executeQuery();
	    ) {
	         {
	            while (rs.next()) {
	            	Manageaccount manageaccount = new Manageaccount();
	            	manageaccount.setManageId(rs.getInt("MANAGE_ID"));
	            	manageaccount.setManageAc(rs.getInt("MANAGE_AC"));
	            	manageaccount.setManagePass(rs.getInt("MANAGE_PASS"));
	            	manageaccount.setManageName(rs.getString("MANAGE_NAME"));
	            	manageaccount.setManageName(rs.getString("MANAGE_APPLY_ID"));
	            	manageaccount.setManageCom(rs.getBoolean("MANAGE_COM"));
	            	manageaccount.setManageFirm(rs.getBoolean("MANAGE_FIRM"));
	            	manageaccount.setManageCourse(rs.getBoolean("MANAGE_COURSE"));
	            	manageaccount.setManageMember(rs.getBoolean("MANAGE_MEMBER"));
	            	manageaccount.setManageReport(rs.getBoolean("MANAGE_REPORT"));
	            	
	                resultList.add(manageaccount);
	            }
	            return resultList;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public Manageaccount selectByKey(Integer id) {
		final String SQL = "select * from MANAGE_ACCOUNT where MANAGE_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Manageaccount manageaccount = new Manageaccount();
					manageaccount.setManageId(rs.getInt("COURSE_ID"));
					manageaccount.setManageAc(rs.getInt("COURSE_NAME"));
					manageaccount.setManagePass(rs.getInt("MEMBER_NO"));
					 manageaccount.setManageName(rs.getString("SUMMARY"));
					return manageaccount;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int deleteByKey(Integer id) {
		final String SQL = "delete from MANAGE_ACCOUNT where MANAGE_ID = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
} 
	