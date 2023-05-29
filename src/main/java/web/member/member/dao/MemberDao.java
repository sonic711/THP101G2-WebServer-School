package web.member.member.dao;

import java.util.List;

import web.member.member.bean.Member;

public interface MemberDao {
	
	Member selectByEmail(String email); // 查詢單一會員(service-login)
	
	Member selectByUserId(String userId);
	
	Member selectByPhone(String phone);
	
	List<Member> selectAll(); // 查詢所有會員(service-findAll)
	
	int insert(Member member); // 新增會員(service-register)
	
	int updateByMemberNo(Member member); // 更新會員資料(service-edit)
	
	
}
