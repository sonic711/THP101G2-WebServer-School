package web.manage.teaapply.service;

import java.util.List;

import web.manage.manageaccount.bean.Manageaccount;
import web.manage.teaapply.bean.Teaapply;

public interface ManageTeaApplyService {
	boolean editManageTeaApply(Teaapply teaapply);
    List<Teaapply> findAllManageTeaApply();
    List<Teaapply> findManageTeaApplyById(Integer id);
    Teaapply findManageTeapplyById(Integer id);
	boolean newOneManageTeaApply(Teaapply teaapply);
	boolean removeManageTeaApplyById(Integer id);
	List<Teaapply> findSelectMember(Integer id);
	

}
