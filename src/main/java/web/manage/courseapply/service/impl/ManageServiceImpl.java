package web.manage.courseapply.service.impl;

import java.util.List;

import web.manage.courseapply.bean.Courseapply;
import web.manage.courseapply.dao.ManageDao;
import web.manage.courseapply.dao.impl.ManageDaoImpl;
import web.manage.courseapply.service.ManageService;

public class ManageServiceImpl implements ManageService {
	private ManageDao dao;
	
	public ManageServiceImpl() {
		dao = new ManageDaoImpl();
	}

	@Override
	public boolean newManageCourseApply(Courseapply courseapply) {
		int result = dao.insert(courseapply);
        return result > 0;
	}
	@Override
	public Courseapply findManageCourseApplyById(Integer id) {
		return dao.selectByKey(id);
	}
	@Override
	public List<Courseapply> findAllCourseApply() {
		return dao.selectAll();
	}

//	@Override
//	public List<Courseapply> findCourseapply(Boolean check) {
//		  return dao.selectAllByKey(check);
//	}
	@Override
	public List<Courseapply> findCourseApplyById(Integer id) {
		  return dao.selectAllByKey(id);
	}
	@Override
	public boolean removeManageCourseApplyById(Integer id) {
		int result = dao.deleteByKey(id);
        return result > 0;
	}
	@Override
	public boolean editPost(Courseapply courseapply) {
		 int result = dao.update(courseapply);
         return result > 0;
	}
}
