package web.point.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static core.util.CommonUtil.*;
import web.point.bean.memberLoginRecord;
import web.point.dao.memberLoginRecordDao;

public class memberLoginRecordDaoImpl implements memberLoginRecordDao {

	@Override
	public int insert(memberLoginRecord mLR) {
		String sql = "insert into MEMBER_LOGIN_RECORD(MEMBER_NO,LOGIN_TIME,CREAT_AT) values(?,now(),now())";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			pstmt.setInt(1, mLR.getMemberNo());
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -6;
	}

	@Override
	public List<memberLoginRecord> selectAllbyMNo(Integer MNo) {
		String sql = "select * from MEMBER_LOGIN_RECORD where MEMBER_NO = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			pstmt.setInt(1, MNo);
			try (ResultSet rs = pstmt.executeQuery();) {
				List<memberLoginRecord> list = new ArrayList<>();
				while (rs.next()) {
					memberLoginRecord mLgR = new memberLoginRecord();
					mLgR.setLoginRecordId(rs.getInt("LOGIN_RECORD_ID"));
					mLgR.setMemberNo(rs.getInt("MEMBER_NO"));
					mLgR.setLoginTime(rs.getTimestamp("LOGIN_TIME"));
					mLgR.setCreatAt(rs.getTimestamp("CREATE_AT"));
					list.add(mLgR);

				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
