package web.community.post.dao.impl;

import web.community.post.bean.Post;
import web.community.post.dao.PostDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static core.util.CommonUtil.getConnection;

public class PostDaoImpl implements PostDao {
    @Override
    public int insert(Post post) {
        final String SQL = "insert into COM_POST(MEMBER_NO, COM_SECCLASS_ID, COM_POST_TITLE, COM_POST_CONTENT, COM_POST_STATUS) "
                           + "values(?, ?, ?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, post.getMemberNo());
            pstmt.setInt(2, post.getComSecClassId());
            pstmt.setString(3, post.getComPostTitle());
            pstmt.setString(4, post.getComPostContent());
            pstmt.setBoolean(5, post.isComPostStatus());
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(Post post) {
        final String SQL = "update COM_POST set "
                           + "COM_POST_TITLE = ?,"
                           + "COM_POST_CONTENT = ?,"
                           + "COM_POST_STATUS = ? "
                           + "where COM_POST_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setString(1, post.getComPostTitle());
            pstmt.setString(2, post.getComPostContent());
            pstmt.setBoolean(3, post.isComPostStatus());
            pstmt.setInt(4, post.getComPostId());
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Post selectByKey(Integer id) {
        final String SQL = "select * from COM_POST where COM_POST_ID = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL)
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Post post = new Post();
                    post.setComPostId(rs.getInt("COM_POST_ID"));
                    post.setMemberNo(rs.getInt("MEMBER_NO"));
                    post.setComSecClassId(rs.getInt("COM_SECCLASS_ID"));
                    post.setComPostTitle(rs.getString("COM_POST_TITLE"));
                    post.setComPostContent(rs.getString("COM_POST_CONTENT"));
                    post.setComPostTime(rs.getTimestamp("COM_POST_TIME"));
                    post.setComPostStatus(rs.getBoolean("COM_POST_STATUS"));
                    post.setComPostAccessSetting(rs.getBoolean("COM_POST_ACCESS_SETTING"));
                    return post;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteByKey(Integer id) {
        final String SQL = "delete from COM_POST where COM_POST_ID = ?";
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
    public List<Post> selectAll() {
        final String SQL = "select * from COM_POST";
        List<Post> resultList = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                Post post = new Post();
                post.setComPostId(rs.getInt("COM_POST_ID"));
                post.setMemberNo(rs.getInt("MEMBER_NO"));
                post.setComSecClassId(rs.getInt("COM_SECCLASS_ID"));
                post.setComPostTitle(rs.getString("COM_POST_TITLE"));
                post.setComPostContent(rs.getString("COM_POST_CONTENT"));
                post.setComPostTime(rs.getTimestamp("COM_POST_TIME"));
                post.setComPostStatus(rs.getBoolean("COM_POST_STATUS"));
                post.setComPostAccessSetting(rs.getBoolean("COM_POST_ACCESS_SETTING"));

                resultList.add(post);
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
