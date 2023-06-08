package web.manage.courseapply.dao;

import java.util.List;
import web.manage.courseapply.bean.Courseapply;

public interface ManageDao {
	int insert (Courseapply courseapply);
	List<Courseapply> selectAllByKey(Integer id);
	List<Courseapply> selectAll();
	Courseapply selectByKey(Integer id);
//	List<Courseapply> selectAllByKey(Boolean check);
	int deleteByKey(Integer id);
	int update (Courseapply courseapply);
	


}
