package web.member.follow.service.impl;

import java.util.List;

import web.member.follow.bean.Follow;
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
	public List<Follow> findAllByMemberNo(Integer memberNo) {
		if (memberNo == null) {
			return null;
		}
		return dao.selectByMemberNo(memberNo);
	}

	@Override
	public List<Follow> findAllByMemberFollowing(Integer memberFollowing) {
		if (memberFollowing == null) {
			return null;
		}
		return dao.selectByMemberFollowing(memberFollowing);
	}

	@Override
	public List<Follow> findAll() {
		return dao.selectAll();
	}

}
