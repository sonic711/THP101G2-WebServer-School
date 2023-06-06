package web.manage.managecomreport.service;

import java.util.List;

import web.course.course.bean.Course;
import web.manage.managecomreport.bean.Managecomreport;

public interface ManageComReportService {
	boolean newOneManageComReport(Managecomreport managecomreport);
	Managecomreport findManageComReportById(Integer id);
	boolean editManageComReport(Managecomreport managecomreport);
	List<Managecomreport> findAllManageComReport();
	List<Managecomreport> findAllManageComReportById(Integer id);
	boolean removeManageComReportById(Integer id);
	

	
}
