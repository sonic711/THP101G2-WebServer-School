package web.manage.manageper.service;

import java.util.List;
import web.manage.manageper.bean.Manageper;

public interface ManagePerService {
	 boolean editManagePer(Manageper manageper);
	    List<Manageper> findAllManagePerByMAId(Integer id);
}
