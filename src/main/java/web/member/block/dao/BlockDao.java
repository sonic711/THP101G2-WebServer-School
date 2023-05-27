package web.member.block.dao;

import java.util.List;

import web.member.block.bean.Block;

public interface BlockDao {
	int insertBlock(Block block); // 新增封鎖對象
	
	int deleteById(Integer memberBlockingId); // 刪除封鎖資料
	
	List<Block> selectAllByMemberNo(Integer memberNo); // 查詢該會員所有封鎖對象
	
	List<Block> selectAll(); // 查詢所有會員封鎖關係
	
}
