package web.member.follow.service;

import java.util.List;

import web.member.follow.bean.Follow;

public interface FollowService {

	boolean add(Follow follow);
	
	boolean delete(Follow follow);
	
	List<Follow> findAllByMemberNo(Integer memberNo);
	
	List<Follow> findAllByMemberFollowing(Integer memberFollowing);
	
	List<Follow> findAll();
	
}
