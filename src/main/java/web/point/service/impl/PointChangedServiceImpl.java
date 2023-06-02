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
	public boolean insert(PointChanged pointchanged) {
		pointChangedDaoImpl PCD = new pointChangedDaoImpl();
		return   PCD.insert(pointchanged) != 0;
	}

	@Override
	public List<PointChanged>  selectAll(Integer id) {
		// TODO Auto-generated method stub 
		return dao.selectAll(id);
	}
	
	
	
	
	
	
	

}
