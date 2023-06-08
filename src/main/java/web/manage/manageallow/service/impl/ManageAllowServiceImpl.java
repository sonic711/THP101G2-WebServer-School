package web.manage.manageallow.service.impl;

import java.util.List;

import web.manage.manageallow.bean.Manageallow;
import web.manage.manageallow.dao.ManageAllowDao;
import web.manage.manageallow.dao.impl.ManageAllowDaoImpl;
import web.manage.manageallow.service.ManageAllowService;

public class ManageAllowServiceImpl implements ManageAllowService {
    private ManageAllowDao dao;
    
    public ManageAllowServiceImpl() {
        dao = new ManageAllowDaoImpl();
    }
    
    @Override
    public List<Manageallow> findAllManageAllowByMAId(Integer id) {
        return dao.selectAllByKey(null);
    }
    
    @Override
    public boolean checkManageAllow(Manageallow manageallow) {
    	int result = dao.insert(manageallow);
        return result > 0;
    }
}
