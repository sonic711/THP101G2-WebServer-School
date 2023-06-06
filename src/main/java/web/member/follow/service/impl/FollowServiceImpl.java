package web.member.follow.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import web.member.follow.bean.Follow;
import web.member.follow.bean.Follower;
import web.member.follow.dao.FollowDao;
import web.member.follow.dao.impl.FollowDaoImpl;
import web.member.follow.service.FollowService;

public class FollowServiceImpl implements FollowService{
	private FollowDao dao;
	
	public FollowServiceImpl() {
		dao = new FollowDaoImpl();
	}

	@Override
	public boolean add(Follow follow) {
		// MEMBER_NO, MEMBER_FOLLOWING不為空
		Integer memberNo = follow.getMemberNo();
		Integer memberFollowing = follow.getMemberFollowing();
		
		if (memberNo == null || memberFollowing == null) {
			return false;
		}
		
		return dao.insert(follow) >= 1;
	}

	@Override
	public boolean delete(Follow follow) {
		Integer memberFollowingId = follow.getMemberFollowingId();
		
		if (memberFollowingId == null) {
			return false;
		}
		
		return dao.deleteById(memberFollowingId) >= 1;
	}

	@Override
	public List<Follower> findAllByMemberNo(Integer memberNo) {
		if (memberNo == null) {
			return null;
		}
		List<Follower> list = dao.selectByMemberNo(memberNo);
		List<Follower> newList = new ArrayList<>();
		list.forEach(followers -> {
			String profilePhoto64 = null;
			if (followers.getProfilePhoto() != null) {
				profilePhoto64 = Base64.getEncoder().encodeToString(followers.getProfilePhoto());
			}
			followers.setProfilePhoto64(profilePhoto64);
			newList.add(followers);
		});
		return newList;
	}

	@Override
	public List<Follower> findAllByMemberFollowing(Integer memberFollowing) {
		if (memberFollowing == null) {
			return null;
		}
		List<Follower> list = dao.selectByMemberFollowing(memberFollowing);
		List<Follower> newList = new ArrayList<>();
		list.forEach(followers -> {
			String profilePhoto64 = null;
			if (followers.getProfilePhoto() != null) {
				profilePhoto64 = Base64.getEncoder().encodeToString(followers.getProfilePhoto());
			}
			followers.setProfilePhoto64(profilePhoto64);
			newList.add(followers);
		});
		return newList;
	}

	@Override
	public List<Follow> findAll() {
		return dao.selectAll();
	}

}
