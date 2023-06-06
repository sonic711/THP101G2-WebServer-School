package web.manage.managecomreport.service.impl;

import java.util.List;

import web.manage.managecomreport.bean.Managecomreport;
import web.manage.managecomreport.dao.ManageComReportDao;
import web.manage.managecomreport.dao.impl.ManageComReportDaoImpl;
import web.manage.managecomreport.service.ManageComReportService;

public class ManageComReportServiceImpl implements ManageComReportService {
    private ManageComReportDao dao;

    public ManageComReportServiceImpl() {
        dao = new ManageComReportDaoImpl();
    }
    
    @Override
	public boolean newOneManageComReport(Managecomreport managecomreport) {
		int result = dao.insert(managecomreport);
        return result > 0;
	}

    @Override
    public boolean editManageComReport(Managecomreport managecomreport) {
    	int result = dao.update(managecomreport);
        return result > 0;
	}

    @Override
    public Managecomreport findManageComReportById(Integer id) {
        return dao.selectByKey(id);
    }

	@Override
	public List<Managecomreport> findAllManageComReport() {
		return dao.selectAll();
	}

	@Override
	public List<Managecomreport> findAllManageComReportById(Integer id) {
		return dao.selectAllByKey(id);
	}
	
	@Override
	public boolean removeManageComReportById(Integer id) {
		int result = dao.deleteByKey(id);
        return result > 0;
	}
}