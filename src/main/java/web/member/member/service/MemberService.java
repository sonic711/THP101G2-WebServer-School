package web.member.member.service;

import java.util.List;

import web.member.member.bean.Member;

public interface MemberService {
	boolean register(Member member); // 註冊
	
	boolean editMember(Member member); // 編輯
	
	Member login(Member member); // 登入
	
	List<Member> findAll(); // 後台
	
}
