package web.firm.service;

import java.util.List;

import web.firm.bean.FirmClass;
import web.member.member.bean.Member;

public interface FirmClassService {
		//新增賣場資料
		boolean insert(FirmClass firmClass);
		
		//更改賣場資料
		boolean editFirm(FirmClass firmClass);
		
		FirmClass selectByUserId(String userId);
		
		List<FirmClass> selectAll();
		
		FirmClass selectByFirmNo(Integer FirmNo);
		

		FirmClass searchFirm(String email);
		
}
