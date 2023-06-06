package web.manage.coursereport.dao;
import java.util.List;
import web.manage.coursereport.bean.Coursereport;

public interface ManageCourseReportDao {
	int insert(Coursereport coursereport);
	int update(Coursereport coursereport);
	 List<Coursereport> selectAllByKey(Integer id);
	 List<Coursereport> selectAll();	
	 Coursereport selectByKey(Integer id);
	 int deleteByKey(Integer id);
	
	 
}
