package web.manage.manageallow.dao;
import java.util.List;
import web.manage.manageallow.bean.Manageallow;
public interface ManageAllowDao {
	int insert(Manageallow manageallow);
	List<Manageallow> selectAllByKey(Integer id);
}
