package web.member.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.member.member.bean.Member;
import web.member.member.dao.MemberDao;

import static core.util.CommonUtil.getConnection;

public class MemberDaoImpl implements MemberDao {

	@Override
	public Member selectByEmail(String email) {
		String sql = "select * from MEMBER where MEMBER_EMAIL = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setString(1, email);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					Member member = new Member();
					member.setMemberNo(rs.getInt("MEMBER_NO"));
					member.setUserId(rs.getString("USER_ID"));
					member.setPassword(rs.getString("PASSWORD"));
					member.setNickname(rs.getString("NICKNAME"));
					member.setMemberIdentity(rs.getString("MEMBER_IDENTITY"));
					member.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
					member.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					member.setCoverPicture(rs.getBytes("COVER_PICTURE"));
					member.setMemberStatus(rs.getInt("MEMBER_STATUS"));
					member.setIntroduction(rs.getString("INTRODUCTION"));
					member.setRewardPoints(rs.getInt("REWARD_POINTS"));
					member.setCreateAt(rs.getTimestamp("CREATE_AT"));
					return member;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Member> selectAll() {
		String sql = "select * from MEMBER";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			) { 
				List<Member> list = new ArrayList<>();
				while (rs.next()) {
					Member member = new Member();
					member.setMemberNo(rs.getInt("MEMBER_NO"));
					member.setUserId(rs.getString("USER_ID"));
					member.setPassword(rs.getString("PASSWORD"));
					member.setNickname(rs.getString("NICKNAME"));
					member.setMemberIdentity(rs.getString("MEMBER_IDENTITY"));
					member.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
					member.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					member.setCoverPicture(rs.getBytes("COVER_PICTURE"));
					member.setMemberStatus(rs.getInt("MEMBER_STATUS"));
					member.setIntroduction(rs.getString("INTRODUCTION"));
					member.setRewardPoints(rs.getInt("REWARD_POINTS"));
					member.setCreateAt(rs.getTimestamp("CREATE_AT"));
					list.add(member);
				}
				return list;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public int insert(Member member) {
		String sql = "insert into MEMBER(USER_ID, PASSWORD, NICKNAME, MEMBER_IDENTITY, PHONE_NUMBER, MEMBER_EMAIL) values(?,?,?,?,?,?)";
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getNickname());
			pstmt.setString(4, "學生");
			pstmt.setString(5, member.getPhoneNumber());
			pstmt.setString(6, member.getMemberEmail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateByMemberNo(Member member) {
		StringBuilder sql = new StringBuilder("update MEMBER set ");
		String password = member.getPassword();
		String nickname = member.getNickname();
		String memberIdentity = member.getMemberIdentity();
		byte[] profilePhoto = member.getProfilePhoto();
		byte[] coverPicture = member.getCoverPicture();
		Integer memberStatus = member.getMemberStatus();
		String introduction = member.getIntroduction();
		Integer rewardPoints = member.getRewardPoints();
		if (password != null && !password.isEmpty()) {
			sql.append("PASSWORD = ?, ");
		}
		if (nickname != null && !nickname.isEmpty()) {
			sql.append("NICKNAME = ?, ");
		}
		if (memberIdentity != null && !memberIdentity.isEmpty()) {
			sql.append("MEMBER_IDENTITY = ?, ");
		}
		if (profilePhoto != null) {
			sql.append("PROFILE_PHOTO = ?, ");
		}
		if (coverPicture != null) {
			sql.append("COVER_PICTURE = ?, ");
		}
		if (memberStatus != null) {
			sql.append("MEMBER_STATUS = ?, ");
		}
		if (introduction != null && !introduction.isEmpty()) {
			sql.append("INTRODUCTION = ?, ");
		}
		if (rewardPoints != null) {
			sql.append("REWARD_POINTS = ?, ");
		}
		sql.deleteCharAt(sql.length()-2);
		sql.append(" where MEMBER_NO = ?");
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			int offset = 0;
			if (password != null && !password.isEmpty()) {
				offset ++;
				pstmt.setString(offset, member.getPassword());
			}
			if (nickname != null && !nickname.isEmpty()) {
				offset ++;
				pstmt.setString(offset, member.getNickname());
			}
			if (memberIdentity != null && !memberIdentity.isEmpty()) {
				offset ++;
				pstmt.setString(offset, member.getMemberIdentity());
			}
			if (profilePhoto != null) {
				offset ++;
				pstmt.setBytes(offset, member.getProfilePhoto());
			}
			if (coverPicture != null) {
				offset ++;
				pstmt.setBytes(offset, member.getCoverPicture());
			}
			if (memberStatus != null) {
				offset ++;
				pstmt.setInt(offset, member.getMemberStatus());
			}
			if (introduction != null && !introduction.isEmpty()) {
				offset ++;
				pstmt.setString(offset, member.getIntroduction());
			}
			if (rewardPoints != null) {
				offset ++;
				pstmt.setInt(offset, member.getRewardPoints());
			}
			System.out.println(sql.toString());
			offset ++;
			
			pstmt.setInt(offset, member.getMemberNo());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Member selectByUserId(String userId) {
		String sql = "select * from MEMBER where USER_ID = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setString(1, userId);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					Member member = new Member();
					member.setMemberNo(rs.getInt("MEMBER_NO"));
					member.setUserId(rs.getString("USER_ID"));
					member.setPassword(rs.getString("PASSWORD"));
					member.setNickname(rs.getString("NICKNAME"));
					member.setMemberIdentity(rs.getString("MEMBER_IDENTITY"));
					member.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
					member.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					member.setCoverPicture(rs.getBytes("COVER_PICTURE"));
					member.setMemberStatus(rs.getInt("MEMBER_STATUS"));
					member.setIntroduction(rs.getString("INTRODUCTION"));
					member.setRewardPoints(rs.getInt("REWARD_POINTS"));
					member.setCreateAt(rs.getTimestamp("CREATE_AT"));
					return member;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member selectByPhone(String phone) {
		String sql = "select * from MEMBER where PHONE_NUMBER = ?";
		
		try(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		) { 
			pstmt.setString(1, phone);
			try (
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()) {
					Member member = new Member();
					member.setMemberNo(rs.getInt("MEMBER_NO"));
					member.setUserId(rs.getString("USER_ID"));
					member.setPassword(rs.getString("PASSWORD"));
					member.setNickname(rs.getString("NICKNAME"));
					member.setMemberIdentity(rs.getString("MEMBER_IDENTITY"));
					member.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
					member.setProfilePhoto(rs.getBytes("PROFILE_PHOTO"));
					member.setCoverPicture(rs.getBytes("COVER_PICTURE"));
					member.setMemberStatus(rs.getInt("MEMBER_STATUS"));
					member.setIntroduction(rs.getString("INTRODUCTION"));
					member.setRewardPoints(rs.getInt("REWARD_POINTS"));
					member.setCreateAt(rs.getTimestamp("CREATE_AT"));
					return member;
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
