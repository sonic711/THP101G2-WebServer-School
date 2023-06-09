package web.member.follow.service;

import java.util.List;

import web.member.follow.bean.Follow;
import web.member.follow.bean.Follower;

public interface FollowService {

	boolean add(Follow follow);
	
	boolean delete(Follow follow);
	
	boolean unfollow(Follow follow);
	
	List<Follower> findAllByMemberNo(Integer memberNo);
	
	List<Follower> findAllByMemberFollowing(Integer memberFollowing);
	
	List<Follower> FollowBackList(Integer memberNo);
	
	List<Follow> findAll();
	
}
