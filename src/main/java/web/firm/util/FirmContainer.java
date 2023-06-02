package web.firm.util;

import web.firm.service.FirmService;
import web.firm.service.impl.FirmServiceImpl;

public class FirmContainer {
	public static final FirmService FIRM_SERVICE = new FirmServiceImpl();
}
