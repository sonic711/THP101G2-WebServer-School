package web.point.service;

import java.util.List;

import web.point.bean.PointChanged;

public interface PointChangedService {
	boolean insert(PointChanged pointchanged);
	
	List<PointChanged> selectAll (Integer id);
}
