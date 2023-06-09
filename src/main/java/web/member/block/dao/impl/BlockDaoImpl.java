package web.member.block.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.member.block.bean.Block;
import web.member.block.bean.BlockedUser;
import web.member.block.dao.BlockDao;

import static core.util.CommonUtil.getConnection;

public class BlockDaoImpl implements BlockDao {

	@Override
	public int insertBlock(Block block) {
		String sql = "insert into MEMBER_BLOCKING(MEMBER_NO, MEMBER_BLOCKING) values(?,?)";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, block.getMemberNo());
			pstmt.setInt(2, block.getMemberBlocking());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteById(Integer memberBlockingId) {
		String sql = "delete from MEMBER_BLOCKING where MEMBER_BLOCKING_ID = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, memberBlockingId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<BlockedUser> selectByMemberNo(Integer memberNo) {
		String sql = "select "
				+ "mb.MEMBER_BLOCKING_ID, "
				+ "mb.MEMBER_NO, "
				+ "mb.MEMBER_BLOCKING, "
				+ "m.USER_ID, "
				+ "m.NICKNAME, "
				+ "m.MEMBER_IDENTITY, "
				+ "m.PROFILE_PHOTO, "
				+ "m.COVER_PICTURE, "
				+ "m.MEMBER_STATUS, "
				+ "m.INTRODUCTION, "
				+ "mb.BLOCK_TIME "
				+ "from MEMBER_BLOCKING mb "
				+ "join MEMBER m on mb.MEMBER_BLOCKING = m.MEMBER_NO "
				+ "where mb.MEMBER_NO = ?";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) { 
			pstmt.setInt(1, memberNo);
			try(
				ResultSet rs = pstmt.executeQuery();
			) {
				List<BlockedUser> list = new ArrayList<>();
				while (rs.next()) {
					BlockedUser blockedUser = new BlockedUser();
					blockedUser.setMemberBlockingId(rs.getInt("MEMBER_BLOCKING_ID"));
					blockedUser.setMemberNo(rs.getInt("MEMBER_NO"));
					blockedUser.setMemberBlocking(rs.getInt("MEMBER_BLOCKING"));
					blockedUser.setUserId(rs.getString("USER_ID"));
					blockedUser.setNickname(rs.getString("NICKNAME"));
					blockedUser.setMemberIdentity(rs.getString("MEMBER_IDENTITY"));
					blockedUser.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					blockedUser.setCoverPicture(rs.getBytes("COVER_PICTURE"));
					blockedUser.setMemberStatus(rs.getInt("MEMBER_STATUS"));
					blockedUser.setIntroduction(rs.getString("INTRODUCTION"));
					blockedUser.setBlockTime(rs.getTimestamp("BLOCK_TIME"));
					list.add(blockedUser);
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
	public List<Block> selectAll() {
		String sql = "select * from MEMBER_BLOCKING";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			) { 
				List<Block> list = new ArrayList<>();
				while (rs.next()) {
					Block block = new Block();
					block.setMemberBlockingId(rs.getInt("MEMBER_BLOCKING_ID"));
					block.setMemberNo(rs.getInt("MEMBER_NO"));
					block.setMemberBlocking(rs.getInt("MEMBER_BLOCKING"));
					block.setBlockTime(rs.getTimestamp("BLOCK_TIME"));
					block.setCreateAt(rs.getTimestamp("CREATE_AT"));
					list.add(block);
				}
				return list;
			}
			catch (Exception e) {
			e.printStackTrace();
			}
		return null;
	}

}
