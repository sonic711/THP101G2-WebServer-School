package web.manage.util;


import web.manage.courseapply.service.ManageService;
import web.manage.courseapply.service.impl.ManageServiceImpl;
import web.manage.coursereport.service.ManageCourseReportService;
import web.manage.coursereport.service.impl.ManageCourseReportServiceImpl;
import web.manage.manageaccount.service.ManageAccountService;
import web.manage.manageaccount.service.impl.ManageAccountServiceImpl;
import web.manage.manageallow.service.ManageAllowService;
import web.manage.manageallow.service.impl.ManageAllowServiceImpl;
import web.manage.managecomreport.service.ManageComReportService;
import web.manage.managecomreport.service.impl.ManageComReportServiceImpl;
import web.manage.manageper.service.ManagePerService;
import web.manage.manageper.service.impl.ManagePerServiceImpl;
import web.manage.teaapply.service.ManageTeaApplyService;
import web.manage.teaapply.service.impl.ManageTeaApplyServiceImpl;

public class ManageContains {
	public static final ManageService MANAGE_SERVICE = new ManageServiceImpl();
	public static final ManageCourseReportService MANAGE_COURSE_REPORT_SERVICE = new ManageCourseReportServiceImpl();
    public static final ManageAllowService MANAGE_ALLOW_SERVICE = new ManageAllowServiceImpl();
    public static final ManageComReportService MANAGE_COM_REPORT_SERVICE = new ManageComReportServiceImpl();
    public static final ManagePerService MANAGE_PER_SERVICE = new ManagePerServiceImpl();
    public static final ManageTeaApplyService MANAGE_TEA_APPLY_SERVICE = new ManageTeaApplyServiceImpl();
    public static final ManageAccountService MANAGE_ACCOUNT_SERVICE = new ManageAccountServiceImpl();
   
}
