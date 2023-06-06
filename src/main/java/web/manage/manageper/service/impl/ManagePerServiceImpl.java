package web.manage.manageper.service.impl;

import java.util.List;

import web.manage.manageper.bean.Manageper;
import web.manage.manageper.dao.ManagePerDao;
import web.manage.manageper.dao.impl.ManagePerDaoImpl;
import web.manage.manageper.service.ManagePerService;

public class ManagePerServiceImpl implements ManagePerService {
    private ManagePerDao dao;

    public ManagePerServiceImpl() {
        dao = new ManagePerDaoImpl();
    }

    @Override
    public boolean editManagePer(Manageper manageper) {
        return dao.update(manageper) > 0;
    }

    @Override
    public List<Manageper> findAllManagePerByMAId(Integer id) {
        return dao.selectAllByKey(id);
    }
}