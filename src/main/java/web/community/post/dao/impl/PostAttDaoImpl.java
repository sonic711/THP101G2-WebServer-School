package web.community.post.dao.impl;

import web.community.post.bean.PostAtt;
import web.community.post.dao.PostAttDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class PostAttDaoImpl implements PostAttDao {
    @Override
    public int insert(PostAtt postAtt) {
        final String SQL = "insert into COM_POST_ATT(COM_POST_ID, COM_POST_ATT) "
                           + "values(?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, postAtt.getComPostId());
            pstmt.setBytes(2, postAtt.getComPostAtt());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(PostAtt postAtt) {
        final String SQL = "update COM_POST_ATT set "
                           + "COM_POST_ATT = ? "
                           + "where COM_POST_ATT_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setBytes(1, postAtt.getComPostAtt());
            pstmt.setInt(2, postAtt.getComPostAttId());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public PostAtt selectByKey(Integer id) {
        final String SQL = "select * from COM_POST_ATT where COM_POST_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    PostAtt postAtt = new PostAtt();
                    postAtt.setComPostAtt(rs.getBytes("COM_POST_ATT"));

                    return postAtt;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteByKey(Integer id) {
        final String SQL = "delete from COM_POST_ATT where COM_POST_ATT_ID = ?";
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
    public List<PostAtt> selectAllByKey(Integer id) {
        final String SQL = "select * from COM_POST_ATT where COM_POST_ID = ?";
        List<PostAtt> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            pstmt.setInt(1, id);
            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    PostAtt postAtt = new PostAtt();
                    postAtt.setComPostId(rs.getInt("COM_POST_ID"));
                    postAtt.setComPostAttId(rs.getInt("COM_POST_ATT_ID"));
                    postAtt.setComPostAtt(rs.getBytes("COM_POST_ATT"));
                    postAtt.setComPostUploadTime(rs.getTimestamp("COM_POST_UPLOAD_TIME"));
                    resultList.add(postAtt);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
