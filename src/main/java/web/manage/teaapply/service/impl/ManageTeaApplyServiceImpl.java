package web.manage.teaapply.service.impl;

import java.util.List;

import web.manage.teaapply.bean.Teaapply;
import web.manage.teaapply.dao.ManageTeaApplyDao;
import web.manage.teaapply.dao.impl.ManageTeaApplyDaoImpl;
import web.manage.teaapply.service.ManageTeaApplyService;

public class ManageTeaApplyServiceImpl implements ManageTeaApplyService {
    private ManageTeaApplyDao dao;

    public ManageTeaApplyServiceImpl() {
        dao = new ManageTeaApplyDaoImpl();
    }

    @Override
    public boolean editManageTeaApply(Teaapply teaapply) {
    	 int result = dao.update(teaapply);
         return result > 0;
    }

    @Override
    public List<Teaapply> findManageTeaApplyById(Integer id) {
        return dao.selectAllByKey(id);
    }

	@Override
	public List<Teaapply> findAllManageTeaApply() {
		return dao.selectAll();
	}
	public List<Teaapply> findSelectMember(Integer id) {
		return dao.selectmemberByKey(id);
	}


	@Override
	public Teaapply findManageTeapplyById(Integer id) {
		return dao.selectByKey(id);
	}

	@Override
	public boolean newOneManageTeaApply(Teaapply teaapply) {
		int result = dao.insert(teaapply);
        return result > 0;
	        }

	@Override
	public boolean removeManageTeaApplyById(Integer id) {
		int result = dao.deleteByKey(id);
        return result > 0;
	}
}