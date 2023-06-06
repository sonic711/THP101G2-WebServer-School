package web.point.service.impl;

import java.util.List;

import web.point.bean.PointChanged;
import web.point.dao.pointChangedDao;
import web.point.dao.impl.pointChangedDaoImpl;
import web.point.service.PointChangedService;

public class PointChangedServiceImpl implements PointChangedService {
	private pointChangedDao dao;
	
	public PointChangedServiceImpl() {
		dao = new pointChangedDaoImpl();
	}
	
	
	
	@Override
	public boolean insertForSC() {
		return   dao.insertForSC() > 0;
	}

	



	@Override
	public boolean insertForCMT() {
		
		return dao.insertForCMT() > 0;
	}



	@Override
	public boolean insertForMLR(int MId) {
		
		return dao.insertForMLR(MId) > 0;
	}



	@Override
	public boolean insertForSO() {
		
		return dao.insertForSO() > 0;
	}
	
	@Override
	public List<PointChanged>  selectAllByMId(Integer id) {
		
		return dao.selectAllByMId(id);
	}
	
	
	
	
	

}
