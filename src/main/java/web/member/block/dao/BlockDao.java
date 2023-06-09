package web.member.block.dao;

import java.util.List;

import web.member.block.bean.Block;
import web.member.block.bean.BlockedUser;

public interface BlockDao {
	int insertBlock(Block block); // 新增封鎖對象
	
	int deleteById(Integer memberBlockingId); // 刪除封鎖資料
	
	List<BlockedUser> selectByMemberNo(Integer memberNo); // 查詢該會員所有封鎖對象
	
	List<Block> selectAll(); // 查詢所有會員封鎖關係
	
}
