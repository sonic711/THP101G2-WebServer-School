package web.calendar.tag.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.calendar.tag.bean.TagColor;
import web.calendar.tag.dao.TagColorDao;

public class TagColorDaoImpl implements TagColorDao{

	@Override
	public List<TagColor> selectAllTags() {
		String sql = "select * from TAG_COLOR";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			List<TagColor> list = new ArrayList<>();
			while (rs.next()) {
				TagColor tagColor = new TagColor();
				tagColor.setTagId(rs.getInt("TAG_ID"));
				tagColor.setColorHex(rs.getString("COLOR_HEX"));
				tagColor.setColorName(rs.getString("COLOR_NAME"));
				tagColor.setCreateAt(rs.getTimestamp("CREATE_AT"));
				list.add(tagColor);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TagColor selectTag(Integer tagId) {
		String sql = "select * from TAG_COLOR where TAG_ID = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setInt(1, tagId);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					TagColor tagColor = new TagColor();
					tagColor.setTagId(rs.getInt("TAG_ID"));
					tagColor.setColorHex(rs.getString("COLOR_HEX"));
					tagColor.setColorName(rs.getString("COLOR_NAME"));
					tagColor.setCreateAt(rs.getTimestamp("CREATE_AT"));
					return tagColor;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
