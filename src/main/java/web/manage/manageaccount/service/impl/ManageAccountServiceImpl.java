package web.manage.manageaccount.service.impl;

import java.util.List;
import web.manage.manageaccount.bean.Manageaccount;
import web.manage.manageaccount.dao.ManageAccountDao;
import web.manage.manageaccount.dao.impl.ManageAccountDaoImpl;
import web.manage.manageaccount.service.ManageAccountService;

public class ManageAccountServiceImpl implements ManageAccountService {
private ManageAccountDao dao;
	
	public ManageAccountServiceImpl() {
		dao = new ManageAccountDaoImpl();
	}
	@Override
	public boolean editManageAccount(Manageaccount manageaccount) {
		int result = dao.update(manageaccount);
        return result > 0;
	}
	@Override
	public List<Manageaccount> findManageAccountById(Integer id) {
		return dao.selectAllByKey(id);
	}
	@Override
	public boolean newOneManageAccount(Manageaccount manageaccount) {
		int result = dao.insert(manageaccount);
        return result > 0;
	        }
	@Override
	public Manageaccount findManageAcountById(Integer id) {
		return dao.selectByKey(id);
	}
	@Override
	public List<Manageaccount> findAllManageAccount() {
		return dao.selectAll();
	}
	@Override
	public boolean removeManageAccountById(Integer id) {
		int result = dao.deleteByKey(id);
        return result > 0;
	}
	
	@Override
	public Manageaccount login(Manageaccount manageaccount) {
		Integer ac = manageaccount.getManageAc();
		if (ac == null) {
			return null;
		}
		
		Integer password = manageaccount.getManagePass();
		if (password == null) {
			return null;
		}
		
		return dao.selectByACandPassword(ac, password);
	}
	
}



