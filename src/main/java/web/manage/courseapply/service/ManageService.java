package web.manage.courseapply.service;

import java.util.List;
import web.manage.courseapply.bean.Courseapply;

public interface ManageService {
	boolean newManageCourseApply(Courseapply courseapply);
	Courseapply findManageCourseApplyById(Integer id);
	List<Courseapply> findAllCourseApply();
	List<Courseapply> findCourseApplyById(Integer id);
//	List<Courseapply> findCourseapply(Boolean check);
	boolean removeManageCourseApplyById(Integer id);
	boolean editPost(Courseapply courseapply);

	
	
	
}
