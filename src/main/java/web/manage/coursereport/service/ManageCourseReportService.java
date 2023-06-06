package web.manage.coursereport.service;

import java.util.List;
import web.manage.coursereport.bean.Coursereport;

public interface ManageCourseReportService {
	boolean newManageCourseReport(Coursereport coursereport);
	Coursereport findManageCourseReportById(Integer id);
	List<Coursereport> findAllManageCourseReport();
	List<Coursereport> findAllByManageCourseReportId(Integer id);
	boolean removeManageCourseReportById(Integer id);
	boolean editCourseReport(Coursereport coursereport);
	
	
	
	
}
