package web.member.member.service.impl;

import java.util.Base64;
import java.util.List;

import web.member.member.bean.Member;
import web.member.member.dao.MemberDao;
import web.member.member.dao.impl.MemberDaoImpl;
import web.member.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberDao dao;
	
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
	}

	@Override
	public boolean register(Member member) {
		// 使用者id: 不重複，⻑度5~15
		String userId = member.getUserId();
		if (dao.selectByUserId(userId) != null
			|| userId.length() < 5 || userId.length() > 15) {
			return false;
		}
		
		// 密碼: 不為空
		String password = member.getPassword();
		if (password == null || password.isEmpty()) {
			return false;
		}
		
		// 暱稱: ⻑度1~10
		String nickname = member.getNickname();
		if (nickname.length() < 1 || nickname.length() > 10) {
			return false;
		}
		
		// 信箱: 不重複，不為空
		String email =  member.getMemberEmail();
		if (dao.selectByEmail(email) != null
			|| email == null || email.isEmpty()) {
			return false;
		}
		
		// 手機: 不重複，10位數
		String phone =  member.getPhoneNumber();
		if (dao.selectByPhone(phone) != null
			|| phone.length() != 10) {
			return false;
		}
		
		System.out.println(member);
		return dao.insert(member) >= 1;
	}

	@Override
	public boolean editMember(Member member) {
		// 暱稱: 不為空，長度1-10
		String nickname = member.getNickname();
		if (nickname != null 
			&& !nickname.isEmpty() 
			&& (nickname.length() < 1 || nickname.length() > 10)) {
			return false;
		}
		String memberIdentity = member.getMemberIdentity();
		if (memberIdentity != null 
			&& !memberIdentity.isEmpty() 
			&& (memberIdentity == "教師" || memberIdentity == "學生")) {
			return false;
		}
		Integer memberStatus = member.getMemberStatus();
		if (memberStatus != null
			&& (memberStatus < 0 || memberStatus > 1)) {
			return false;
		}
		String profilePhoto64 = member.getProfilePhoto64();
		if (profilePhoto64 != null && !profilePhoto64.isEmpty()) {
			byte[] profilePhoto = Base64.getDecoder().decode(profilePhoto64);
			member.setProfilePhoto(profilePhoto);
		}
		String coverPicture64 = member.getCoverPicture64();
		if (coverPicture64 != null && !coverPicture64.isEmpty()) {
			byte[] coverPicture = Base64.getDecoder().decode(coverPicture64);
			member.setCoverPicture(coverPicture);
		}
		
		System.out.println(dao);
		return dao.updateByMemberNo(member) >= 1;
	}

	@Override
	public Member login(Member member) {
		// 信箱: 不為空
		String email =  member.getMemberEmail();
		if (email == null || email.isEmpty()) {
			return null;
		}
				
		// 密碼: 不為空
		String password = member.getPassword();
		if (password == null || password.isEmpty()) {
			return null;
		}
		return dao.selectByEmailAndPassword(member.getMemberEmail(), member.getPassword());
	}

	@Override
	public List<Member> findAll() {
		return dao.selectAll();
	}

	@Override
	public Member searchMember(String email) {
		return dao.selectByEmail(email);
	}

	@Override
	public String getPW(String email) {
		if (dao.selectByEmail(email) == null
			|| email == null || email.isEmpty()) {
			return null;
		}
		return dao.selectPasswordByEmail(email);
	}

	@Override
	public String getPhone(String email) {
		if (dao.selectByEmail(email) == null
			|| email == null || email.isEmpty()) {
			return null;
		}
		Member member = dao.selectByEmail(email);
		return member.getPhoneNumber();
	}

}
