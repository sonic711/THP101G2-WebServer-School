package web.member.block.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.member.block.bean.Block;
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
	public List<Block> selectAllByMemberNo(Integer memberNo) {
		String sql = "select * from MEMBER_BLOCKING where MEMBER_NO = ?";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) { 
			pstmt.setInt(1, memberNo);
			try(
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
