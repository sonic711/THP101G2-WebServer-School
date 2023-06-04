package web.member.follow.service;

import java.util.List;

import web.member.follow.bean.Follow;
import web.member.follow.bean.Followers;

public interface FollowService {

	boolean add(Follow follow);
	
	boolean delete(Follow follow);
	
	List<Followers> findAllByMemberNo(Integer memberNo);
	
	List<Followers> findAllByMemberFollowing(Integer memberFollowing);
	
	List<Follow> findAll();
	
}
