package web.manage.teaapply.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.manage.teaapply.bean.Teaapply;
import web.manage.teaapply.dao.ManageTeaApplyDao;



public class ManageTeaApplyDaoImpl implements ManageTeaApplyDao {
	
	public int insert(Teaapply teaapply) {
        final String SQL = "insert into TEA_APPLY(TEA_ID, MEMBER_NO, MANAGE_ID,"
        		+ "TEA_APPLY_TIME, MANAGE_PTIME, TEA_CHECK, TEA_RESULT) "
                           + "values(?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, teaapply.getTeaId());
            pstmt.setInt(2, teaapply.getMemberNo());
            pstmt.setInt(3, teaapply.getManageId());
            pstmt.setTimestamp(4, teaapply.getTeaApplyTime());
            pstmt.setTimestamp(5, teaapply.getManagePtime());
            pstmt.setString(6, teaapply.getTeaCheck());
            pstmt.setBoolean(7, teaapply.getTeaResult());
            

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
	public int update(Teaapply teaapply) {
        final String SQL = "update TEA_APPLY set "
                           + "MANAGE_PTIME = ?, TEA_CHECK = ?, TEA_RESULT = ?"
                           + "where TEA_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setTimestamp(1, teaapply.getManagePtime());
            pstmt.setString(2, teaapply.getTeaCheck());
            pstmt.setBoolean(3, teaapply.getTeaResult());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;//還沒改
	}
	
	public List<Teaapply> selectAll() {
		final String SQL = "select * From TEA_APPLY";
		List<Teaapply> resultList = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Teaapply teaapply = new Teaapply();
				teaapply.setTeaId(rs.getInt("TEA_ID"));
            	teaapply.setMemberNo(rs.getInt("MEMBER_NO"));
            	teaapply.setManageId(rs.getInt("MANAGE_ID"));
            	teaapply.setTeaApplyTime(rs.getTimestamp("TEA_APPLY_TIME"));
            	teaapply.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
            	teaapply.setTeaCheck(rs.getString("TEA_CHECK"));
            	teaapply.setTeaResult(rs.getBoolean("TEA_RESULT"));
				resultList.add(teaapply);
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
        
        public List<Teaapply> selectAllByKey(Integer id) {
            final String SQL = "select * from TEA_APPLY where TEA_ID  = ?";
            List<Teaapply> resultList = new ArrayList<>();
            try (
                    Connection conn = getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(SQL);
            ) {
                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                    	Teaapply teaapply = new Teaapply();
                    	teaapply.setTeaId(rs.getInt("TEA_ID"));
                    	teaapply.setMemberNo(rs.getInt("MEMBER_NO"));
                    	teaapply.setManageId(rs.getInt("MANAGE_ID"));
                    	teaapply.setTeaApplyTime(rs.getTimestamp("TEA_APPLY_TIME"));
                    	teaapply.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
                    	teaapply.setTeaCheck(rs.getString("TEA_CHECK"));
                    	teaapply.setTeaResult(rs.getBoolean("TEA_RESULT"));
                    	
                        resultList.add(teaapply);
                    }
                    
                }
                return resultList;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        
        @Override
    	public Teaapply selectByKey(Integer id) {
    		final String SQL = "select * from TEA_APLLY where TEA_ID = ?";
    		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
    			pstmt.setInt(1, id);
    			try (ResultSet rs = pstmt.executeQuery()) {
    				if (rs.next()) {
    					Teaapply teaapply  = new Teaapply();
    					teaapply.setTeaId(rs.getInt("TEA_ID"));
    	            	teaapply.setMemberNo(rs.getInt("MEMBER_NO"));
    	            	teaapply.setManageId(rs.getInt("MANAGE_ID"));
    	            	teaapply.setTeaApplyTime(rs.getTimestamp("TEA_APPLY_TIME"));
    	            	teaapply.setManagePtime(rs.getTimestamp("MANAGE_PTIME"));
    	            	teaapply.setTeaCheck(rs.getString("TEA_CHECK"));
    	            	teaapply.setTeaResult(rs.getBoolean("TEA_RESULT"));
    					return teaapply;
    				}
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return null;
    	}

    	@Override
    	public int deleteByKey(Integer id) {
    		final String SQL = "delete from TEA_APLLY where TEA_ID = ?";
    		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
    			pstmt.setInt(1, id);
    			return pstmt.executeUpdate();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return -1;
    	}

    }


