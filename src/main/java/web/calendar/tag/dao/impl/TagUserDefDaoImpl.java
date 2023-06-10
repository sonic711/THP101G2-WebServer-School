package web.calendar.tag.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.calendar.tag.bean.TagUserDefined;
import web.calendar.tag.dao.TagUserDefDao;

import static core.util.CommonUtil.getConnection;


public class TagUserDefDaoImpl implements TagUserDefDao {

	@Override
	public List<TagUserDefined> selectAll() {
		String sql = "select * from TAG_USER_DEFINED";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			List<TagUserDefined> list = new ArrayList<>();
			while (rs.next()) {
				TagUserDefined tud = new TagUserDefined();
				tud.setTagUserDefinedId(rs.getInt("TAG_USER_DEFINED_ID"));
				tud.setMemberNo(rs.getInt("MEMBER_NO"));
				tud.setTagId(rs.getInt("TAG_ID"));
				tud.setDefinedColname(rs.getString("DEFINED_COLNAME"));
				tud.setCreateAt(rs.getTimestamp("CREATE_AT"));
				tud.setColorHex(rs.getString("COLOR_HEX"));
				list.add(tud);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TagUserDefined> selectByMemberNo(Integer memberNo) {
		String sql = "select tud.*, tc.COLOR_HEX "
				+ "from TAG_USER_DEFINED tud "
				+ "join TAG_COLOR tc on tud.TAG_ID = tc.TAG_ID "
				+ "where tud.MEMBER_NO = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, memberNo);
			try (
				ResultSet rs = pstmt.executeQuery();
			) {
				List<TagUserDefined> list = new ArrayList<>();
				while (rs.next()) {
					TagUserDefined tud = new TagUserDefined();
					tud.setTagUserDefinedId(rs.getInt("TAG_USER_DEFINED_ID"));
					tud.setMemberNo(rs.getInt("MEMBER_NO"));
					tud.setTagId(rs.getInt("TAG_ID"));
					tud.setDefinedColname(rs.getString("DEFINED_COLNAME"));
					tud.setCreateAt(rs.getTimestamp("CREATE_AT"));
					tud.setColorHex(rs.getString("COLOR_HEX"));
					list.add(tud);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(TagUserDefined tud) {
		String sql = "insert into TAG_USER_DEFINED(MEMBER_NO, TAG_ID, DEFINED_COLNAME) "
				+ "values(?, ?, ?)";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, tud.getMemberNo());
			pstmt.setInt(2, tud.getTagId());
			pstmt.setString(3, tud.getDefinedColname());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(TagUserDefined tud) {
		String sql = "update TAG_USER_DEFINED set DEFINED_COLNAME = ? where TAG_USER_DEFINED_ID = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, tud.getDefinedColname());
			pstmt.setInt(2, tud.getTagUserDefinedId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteById(Integer tudId) {
		String sql = "delete from TAG_USER_DEFINED where TAG_USER_DEFINED_ID = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, tudId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public TagUserDefined selectByDefined(Integer tudId) {
		String sql = "select * from TAG_USER_DEFINED where TAG_USER_DEFINED_ID = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, tudId);
			try (
				ResultSet rs = pstmt.executeQuery();
			) {
				if (rs.next()) {
					TagUserDefined tud = new TagUserDefined();
					tud.setTagUserDefinedId(rs.getInt("TAG_USER_DEFINED_ID"));
					tud.setMemberNo(rs.getInt("MEMBER_NO"));
					tud.setTagId(rs.getInt("TAG_ID"));
					tud.setDefinedColname(rs.getString("DEFINED_COLNAME"));
					tud.setCreateAt(rs.getTimestamp("CREATE_AT"));
					return tud;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
