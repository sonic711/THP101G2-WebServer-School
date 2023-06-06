package web.manage.manageallow.service;

import java.util.List;


import web.manage.manageallow.bean.Manageallow;

public interface ManageAllowService {
	 List<Manageallow> findAllManageAllowByMAId(Integer id);
	 boolean checkManageAllow(Manageallow  manageallow);
}
