package web.manage.teaapply.dao;

import java.util.List;


import web.manage.teaapply.bean.Teaapply;

public interface ManageTeaApplyDao {
	 int insert(Teaapply teaapply);
	 int update(Teaapply teaapply);
	 Teaapply selectByKey(Integer id);
	 List<Teaapply> selectAllByKey(Integer id);
	 List<Teaapply> selectAll();
	 int deleteByKey(Integer id);
}


