package web.community.post.dao.impl;

import web.community.post.bean.Post;
import web.community.post.dao.PostDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
                PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            pstmt.setInt(1, post.getMemberNo());
            pstmt.setInt(2, post.getComSecClassId());
            pstmt.setString(3, post.getComPostTitle());
            pstmt.setString(4, post.getComPostContent());
            pstmt.setBoolean(5, post.getComPostStatus());
            pstmt.executeUpdate();
            try(ResultSet rs = pstmt.getGeneratedKeys()){
                if (rs.next()){
                    return rs.getInt(1);
                }
            }
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
            pstmt.setBoolean(3, post.getComPostStatus());
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

    // TODO 做成SP
    @Override
    public List<Post> selectAll() {
        final String SQL = "select p.*, cs.COM_SECCLASS_NAME, l.*, m.USER_ID, m.NICKNAME, m.PROFILE_PHOTO from COM_POST p left join COM_SECCLASS CS on CS.COM_SECCLASS_ID = p.COM_SECCLASS_ID left join MEMBER m on p.MEMBER_NO = m.MEMBER_NO left join COM_LABEL l on l.COM_POST_ID = p.COM_POST_ID;";
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
                post.setUserId(rs.getString("USER_ID"));
                post.setNickName(rs.getString("NICKNAME"));
                post.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
                post.setComSecClassId(rs.getInt("COM_SECCLASS_ID"));
                post.setComSecClassName(rs.getString("COM_SECCLASS_NAME"));
                post.setComPostLabelId(rs.getInt("COM_LABEL_ID"));
                post.setComPostLabelName(rs.getString("COM_LABEL_NAME"));
                post.setComPostLabelTime(rs.getTimestamp("COM_LABEL_TIME"));
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
