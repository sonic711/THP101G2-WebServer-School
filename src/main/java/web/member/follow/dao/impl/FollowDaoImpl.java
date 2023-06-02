package web.member.follow.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.member.follow.bean.Follow;
import web.member.follow.dao.FollowDao;

public class FollowDaoImpl implements FollowDao{

	@Override
	public int insert(Follow follow) {
		String sql = "insert into MEMBER_FOLLOWING(MEMBER_NO, MEMBER_FOLLOWING) values(?,?)";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, follow.getMemberNo());
			pstmt.setInt(2, follow.getMemberFollowing());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteById(Integer memberFollowingId) {
		String sql = "delete from MEMBER_FOLLOWING where MEMBER_FOLLOWING_ID = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, memberFollowingId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Follow> selectByMemberNo(Integer memberNo) {
		String sql = "select * from MEMBER_FOLLOWING where MEMBER_NO = ?";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) { 
			pstmt.setInt(1, memberNo);
			try(
				ResultSet rs = pstmt.executeQuery();
			) {
				List<Follow> list = new ArrayList<>();
				while (rs.next()) {
					Follow follow = new Follow();
					follow.setMemberFollowingId(rs.getInt("MEMBER_FOLLOWING_ID"));
					follow.setMemberNo(rs.getInt("MEMBER_NO"));
					follow.setMemberFollowing(rs.getInt("MEMBER_FOLLOWING"));
					follow.setFollowTime(rs.getTimestamp("FOLLOW_TIME"));
					follow.setCreateAt(rs.getTimestamp("CREATE_AT"));
					list.add(follow);
				}
			return list;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Follow> selectByMemberFollowing(Integer memberFollowing) {
		String sql = "select * from MEMBER_FOLLOWING where MEMBER_FOLLOWING = ?";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) { 
			pstmt.setInt(1, memberFollowing);
			try(
				ResultSet rs = pstmt.executeQuery();
			) {
				List<Follow> list = new ArrayList<>();
				while (rs.next()) {
					Follow follow = new Follow();
					follow.setMemberFollowingId(rs.getInt("MEMBER_FOLLOWING_ID"));
					follow.setMemberNo(rs.getInt("MEMBER_NO"));
					follow.setMemberFollowing(rs.getInt("MEMBER_FOLLOWING"));
					follow.setFollowTime(rs.getTimestamp("FOLLOW_TIME"));
					follow.setCreateAt(rs.getTimestamp("CREATE_AT"));
					list.add(follow);
				}
			return list;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Follow> selectAll() {
		String sql = "select * from MEMBER_FOLLOWING";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			List<Follow> list = new ArrayList<>();
			while (rs.next()) {
				Follow follow = new Follow();
				follow.setMemberFollowingId(rs.getInt("MEMBER_FOLLOWING_ID"));
				follow.setMemberNo(rs.getInt("MEMBER_NO"));
				follow.setMemberFollowing(rs.getInt("MEMBER_FOLLOWING"));
				follow.setFollowTime(rs.getTimestamp("FOLLOW_TIME"));
				follow.setCreateAt(rs.getTimestamp("CREATE_AT"));
				list.add(follow);
			}
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
