package web.member.follow.dao;

import java.util.List;

import web.member.follow.bean.Follow;
import web.member.follow.bean.Followers;

public interface FollowDao {
	
	int insert(Follow follow); // 新增追蹤對象
	
	int deleteById(Integer memberFollowingId); // 刪除追蹤資料
	
	List<Followers> selectByMemberNo(Integer memberNo); // 查詢該會員所有追蹤對象
	
	List<Followers> selectByMemberFollowing(Integer memberFollowing); // 查詢該會員所有粉絲
	
	List<Follow> selectAll(); // 查詢所有會員封鎖關係
}
