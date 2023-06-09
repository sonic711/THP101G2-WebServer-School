package web.member.block.service;

import java.util.List;

import web.member.block.bean.Block;
import web.member.block.bean.BlockedUser;

public interface BlockService {
	boolean add(Block block); // 新增
	
	boolean delete(Block block); // 刪除
	
	List<BlockedUser> findAllByMemberNo(Integer memberNo); // 查詢該會員所有封鎖對象
	
	List<Block> findAll(); // 後台
}
