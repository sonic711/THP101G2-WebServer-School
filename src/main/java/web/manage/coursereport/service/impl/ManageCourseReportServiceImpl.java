package web.manage.coursereport.service.impl;

import java.util.List;

import web.manage.coursereport.bean.Coursereport;
import web.manage.coursereport.dao.ManageCourseReportDao;
import web.manage.coursereport.dao.impl.ManageCourseReportDaoImpl;
import web.manage.coursereport.service.ManageCourseReportService;

public class ManageCourseReportServiceImpl implements ManageCourseReportService {
    private ManageCourseReportDao dao;
    
    public ManageCourseReportServiceImpl() {
        dao = new ManageCourseReportDaoImpl();
    }

    @Override
    public boolean newManageCourseReport(Coursereport coursereport) {
		int result = dao.insert(coursereport);
        return result > 0;
	        }
    
    @Override
    public boolean editCourseReport(Coursereport coursereport) {
        int result = dao.update(coursereport);
        return result > 0;
    }
    
    @Override
	public Coursereport findManageCourseReportById(Integer id) {
		return dao.selectByKey(id);
	}
    
    @Override
    public List<Coursereport> findAllManageCourseReport() {
		return dao.selectAll();
	}
    
    @Override
    public List<Coursereport> findAllByManageCourseReportId(Integer id) {
    	return dao.selectAllByKey(id);
    }
    
	@Override
	public boolean removeManageCourseReportById(Integer id) {
		int result = dao.deleteByKey(id);
        return result > 0;
	}
	
	 
}