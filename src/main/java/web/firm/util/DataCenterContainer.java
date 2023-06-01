package web.firm.util;

import web.firm.service.DataCenterService;
import web.firm.service.impl.DataCenterServiceImpl;

public class DataCenterContainer {

	public static final DataCenterService SALEDATA_SERVICE = new DataCenterServiceImpl();
	
	public static final DataCenterService ALLSALEDATA_SERVICE = new DataCenterServiceImpl();
	
	
}
