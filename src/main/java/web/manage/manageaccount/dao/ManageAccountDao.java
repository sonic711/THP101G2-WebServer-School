package web.manage.manageaccount.dao;
import java.util.List;
import web.manage.manageaccount.bean.Manageaccount;

public interface ManageAccountDao {

	int insert (Manageaccount manageaccount);
	int update (Manageaccount manageaccount);
	List<Manageaccount> selectAllByKey(Integer id);
	List<Manageaccount> selectAll();
	Manageaccount selectByKey(Integer id);
	int deleteByKey(Integer id);

}
