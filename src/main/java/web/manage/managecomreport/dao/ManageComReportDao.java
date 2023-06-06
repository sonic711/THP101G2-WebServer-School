package web.manage.managecomreport.dao;

import java.util.List;
import web.manage.managecomreport.bean.Managecomreport;

public interface ManageComReportDao {
	
	 	int insert(Managecomreport managecomreport);
	    int update(Managecomreport managecomreport);
	    List<Managecomreport> selectAllByKey(Integer id);
		List<Managecomreport> selectAll();
		Managecomreport selectByKey(Integer id);
		int deleteByKey(Integer id);
}
