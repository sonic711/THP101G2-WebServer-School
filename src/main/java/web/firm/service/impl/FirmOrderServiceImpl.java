package web.firm.service.impl;

import java.util.List;

import web.firm.bean.FirmOrder;
import web.firm.dao.FirmOrderDao;
import web.firm.dao.impl.FirmOrderDaoImpl;
import web.firm.service.FirmOrderService;

public class FirmOrderServiceImpl implements FirmOrderService {
	 
	private FirmOrderDao dao;

	public FirmOrderServiceImpl() {
	      dao = new FirmOrderDaoImpl();
	}

	@Override
	public List<FirmOrder> selectByFirmNo(Integer firmNo) {
		return dao.selectByFirmNo(firmNo);
	}

	@Override
	public List<FirmOrder> selectAll() {
		return dao.selectAll();
	}







}
