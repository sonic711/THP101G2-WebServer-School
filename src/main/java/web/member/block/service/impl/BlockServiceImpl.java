package web.member.block.service.impl;

import java.util.List;

import web.member.block.bean.Block;
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
	public List<Block> findAllByMemberNo(Integer memberNo) {
		if (memberNo == null) {
			return null;
		}
		return dao.selectAllByMemberNo(memberNo);
	}

	@Override
	public List<Block> findAll() {
		return dao.selectAll();
	}

}
