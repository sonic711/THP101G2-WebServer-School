package web.firm.service.impl;

import java.util.List;

import web.firm.bean.FirmClass;
import web.firm.dao.FirmDaoToGrace;
import web.firm.dao.impl.FirmDaoImplToGrace;
import web.firm.service.FirmClassService;

public class FirmClassServiceImpl implements FirmClassService{

	private FirmDaoToGrace dao;
	
	public FirmClassServiceImpl() {
		dao = new FirmDaoImplToGrace();
	}
	
    // 註冊
	@Override
	public int insert(FirmClass firmClass) {
		return dao.insert(firmClass);
	}
	// 更新賣場資料
	@Override
	public int update(FirmClass firmClass) {
		return dao.update(firmClass);
	}

	// 查詢user資料
	@Override
	public FirmClass selectByUserId(String userId) {
		return dao.selectByUserId(userId);
	}
	// 查所有廠商
	@Override
	public List<FirmClass> selectAll() {
		return dao.selectAll();
	}

	@Override
	public FirmClass selectByFirmNo(Integer FirmNo) {
		return dao.selectByFirmNo(FirmNo);
	}





	

}
