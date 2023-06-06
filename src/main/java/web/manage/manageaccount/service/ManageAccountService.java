package web.manage.manageaccount.service;

import java.util.List;

import web.course.course.bean.Course;
import web.manage.manageaccount.bean.Manageaccount;

public interface ManageAccountService {
	boolean newOneManageAccount(Manageaccount manageaccount);
	Manageaccount findManageAcountById(Integer id);
	boolean editManageAccount(Manageaccount manageaccount);
    List<Manageaccount> findManageAccountById(Integer id);
    List<Manageaccount> findAllManageAccount();
	boolean removeManageAccountById(Integer id);
	
    
    
}
