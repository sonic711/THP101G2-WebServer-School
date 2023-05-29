package web.firm.service.impl;

import java.util.List;

import web.firm.bean.DataCenter;
import web.firm.dao.DataCenterDao;
import web.firm.dao.impl.DataCenterDaoImpl;
import web.firm.service.DataCenterService;

public class DataCenterServiceImpl implements DataCenterService {
	
	private DataCenterDao dao;

    public DataCenterServiceImpl() {
    	dao = new DataCenterDaoImpl();
    }

	@Override
	public List<DataCenter> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<DataCenter> selectByFirmNo(Integer firmNo) {
		return dao.selectByFirmNo(firmNo);
	}


}
