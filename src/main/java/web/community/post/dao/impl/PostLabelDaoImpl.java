package web.community.post.dao.impl;

import web.community.post.bean.PostLabel;
import web.community.post.dao.PostLabelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class PostLabelDaoImpl implements PostLabelDao {
    @Override
    public int insert(List<PostLabel> postLabelList, Integer id) {

        final String SQL = "insert into COM_LABEL(COM_POST_ID, COM_LABEL_NAME) "
                           + "values(?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            for (PostLabel postLabel : postLabelList) {
                pstmt.setInt(1, id);
                pstmt.setString(2, postLabel.getComLabelName());
                pstmt.addBatch();
            }
            // 取得每個insert成功筆數，Oracle要改用Statment.getUpdateCount()
            int[] counts = pstmt.executeBatch();
            int sum = 0;
            for (int count : counts) {
                sum += count;
            }
            return sum;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteByKey(Integer id) {
        final String SQL = "delete from COM_LABEL where COM_LABEL_ID = ?";
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
    public List<PostLabel> selectAll() {
        final String SQL = "select COM_LABEL_NAME from COM_LABEL group by COM_LABEL_NAME";
        List<PostLabel> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                PostLabel postLabel = new PostLabel();
                postLabel.setComLabelName(rs.getString("COM_LABEL_NAME"));
                resultList.add(postLabel);
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PostLabel> selectAllByKey(Integer id) {
        final String SQL = "select * from COM_LABEL where COM_POST_ID = ?";
        List<PostLabel> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PostLabel postLabel = new PostLabel();
                    postLabel.setComLabelId(rs.getInt("COM_LABEL_ID"));
                    postLabel.setComPostId(rs.getInt("COM_POST_ID"));
                    postLabel.setComLabelName(rs.getString("COM_LABEL_NAME"));
                    postLabel.setComLabelTime(rs.getTimestamp("COM_LABEL_TIME"));

                    resultList.add(postLabel);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
