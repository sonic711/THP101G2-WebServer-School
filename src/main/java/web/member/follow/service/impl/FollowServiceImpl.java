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
			String coverPicture64 = null;
			if (followers.getProfilePhoto() != null) {
				profilePhoto64 = Base64.getEncoder().encodeToString(followers.getProfilePhoto());
			}
			if (followers.getCoverPicture() != null) {
				coverPicture64 = Base64.getEncoder().encodeToString(followers.getCoverPicture());
			}
			followers.setProfilePhoto64(profilePhoto64);
			followers.setCoverPicture64(coverPicture64);
			newList.add(followers);
		});
		return newList;
	}

	@Override
	public List<Follower> findAllByMemberFollowing(Integer memberFollowing) {
		if (memberFollowing == null) {
			return null;
		}
		return dao.selectByMemberFollowing(memberFollowing);
	}

	@Override
	public List<Follow> findAll() {
		return dao.selectAll();
	}

	@Override
	public boolean unfollow(Follow follow) {
		Integer memberNo = follow.getMemberNo();
		Integer memberFollowing = follow.getMemberFollowing();
		
		if (memberNo == null) {
			return false;
		}
		if (memberFollowing == null) {
			return false;
		}

		return dao.deleteByTwoMember(memberNo, memberFollowing) >= 1;
	}

	@Override
	public List<Follower> FollowBackList(Integer memberNo) {
		if (memberNo == null) {
			return null;
		}		
		return dao.selectFollowEachOther(memberNo);
	}

}
