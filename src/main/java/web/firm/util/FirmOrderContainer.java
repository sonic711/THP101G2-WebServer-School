package web.firm.util;

import web.firm.service.FirmOrderService;
import web.firm.service.impl.FirmOrderServiceImpl;

public class FirmOrderContainer {

	 public static final FirmOrderService ORDERPOSTALL_SERVICE = new FirmOrderServiceImpl();
	 
	 public static final FirmOrderService ORDERSTATUS_SERVICE = new FirmOrderServiceImpl();
}
