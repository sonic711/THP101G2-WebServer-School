package web.manage.manageper.dao;

import java.util.List;

import web.manage.manageper.bean.Manageper;

public interface ManagePerDao {
	
	 int insert(Manageper manageper);

	 int update(Manageper manageper);
	    
	 List<Manageper> selectAllByKey(Integer id);
}
