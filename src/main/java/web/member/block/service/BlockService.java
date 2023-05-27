package web.member.block.service;

import java.util.List;

import web.member.block.bean.Block;

public interface BlockService {
	boolean add(Block block); // 新增
	
	boolean delete(Block block); // 刪除
	
	List<Block> findAllByMemberNo(Integer memberNo); // 查詢該會員所有封鎖對象
	
	List<Block> findAll(); // 後台
}
