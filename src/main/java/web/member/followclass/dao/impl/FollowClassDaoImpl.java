package web.member.followclass.dao.impl;

import web.member.followclass.bean.FollowClass;
import web.member.followclass.dao.FollowClassDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class FollowClassDaoImpl implements FollowClassDao {
    @Override
    public int insert(FollowClass followClass) {
        final String SQL = "insert into MEMBER_FOLLOW_BOARD(MEMBER_NO, COM_SECCLASS_ID) "
                           + "values(?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, followClass.getMemberNo());
            pstmt.setInt(2, followClass.getComSecClassId());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteById(Integer id, Integer classId) {
        final String SQL = "delete from MEMBER_FOLLOW_BOARD WHERE MEMBER_NO = ? and COM_SECCLASS_ID =?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, classId);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<FollowClass> findAllById(Integer id) {
        final String SQL = "select * from MEMBER_FOLLOW_BOARD where MEMBER_NO = ?";
        List<FollowClass> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    FollowClass followClass = new FollowClass();
                    followClass.setMemberFollowBoardId(rs.getInt("MEMBER_FOLLOW_BOARD_ID"));
                    followClass.setMemberNo(rs.getInt("MEMBER_NO"));
                    followClass.setComSecClassId(rs.getInt("COM_SECCLASS_ID"));

                    resultList.add(followClass);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
