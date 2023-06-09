package web.member.block.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import web.member.block.bean.Block;
import web.member.block.bean.BlockedUser;
import web.member.block.dao.BlockDao;
import web.member.block.dao.impl.BlockDaoImpl;
import web.member.block.service.BlockService;

public class BlockServiceImpl implements BlockService {
	private BlockDao dao;
	
	public BlockServiceImpl() {
		dao = new BlockDaoImpl();
	}

	@Override
	public boolean add(Block block) {
		// MEMBER_NO, MEMBER_BLOCKIMG不為空
		Integer memberNo = block.getMemberNo();
		Integer memberBlocking = block.getMemberBlocking();
		
		if (memberNo == null || memberBlocking == null) {
			return false;
		}
		
		return dao.insertBlock(block) >= 1;
	}

	@Override
	public boolean delete(Block block) {
		Integer memberBlockingId = block.getMemberBlockingId();
		if (memberBlockingId == null) {
			return false;
		}
		return dao.deleteById(memberBlockingId) >= 1;
	}

	@Override
	public List<BlockedUser> findAllByMemberNo(Integer memberNo) {
		if (memberNo == null) {
			return null;
		}
		List<BlockedUser> list = dao.selectByMemberNo(memberNo);
		list.forEach(blockedUser -> {
			
			String profilePhoto64 = null;
			String coverPicture64 = null;
			
			if (blockedUser.getProfilePhoto() != null) {
				profilePhoto64 = Base64.getEncoder().encodeToString(blockedUser.getProfilePhoto());
			}
			
			if (blockedUser.getCoverPicture() != null) {
				coverPicture64 = Base64.getEncoder().encodeToString(blockedUser.getCoverPicture());
			}
			
			blockedUser.setProfilePhoto64(profilePhoto64);
			blockedUser.setProfilePhoto(null);
			
			blockedUser.setCoverPicture64(coverPicture64);
			blockedUser.setCoverPicture(null);
			
		});
		return list;
	}

	@Override
	public List<Block> findAll() {
		return dao.selectAll();
	}

}
