package web.point.service;

import java.util.List;

import web.point.bean.PointChanged;

public interface PointChangedService {
	boolean insertForSC();
		
	boolean insertForCMT();
		
	boolean insertForMLR(int MId);
		
	boolean insertForSO();
	
	
	List<PointChanged> selectAllByMId (Integer id);
}
