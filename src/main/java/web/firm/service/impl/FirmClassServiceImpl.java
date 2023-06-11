package web.firm.service.impl;

import java.util.Base64;
import java.util.List;

import web.firm.bean.FirmClass;
import web.firm.dao.FirmDaoToGrace;
import web.firm.dao.impl.FirmDaoImplToGrace;
import web.firm.service.FirmClassService;

public class FirmClassServiceImpl implements FirmClassService{

	private FirmDaoToGrace dao;
	
	public FirmClassServiceImpl() {
		dao = new FirmDaoImplToGrace();
	}
	
    // 註冊
	@Override
	public boolean insert(FirmClass firmClass) {
		int result = dao.insert(firmClass);
		return result > 0;
	}
	// 更新賣場資料
	@Override
	public boolean editFirm(FirmClass firmClass) {
		String profilePhoto64 = firmClass.getProfilePhoto64();
		if (profilePhoto64 != null && !profilePhoto64.isEmpty()) {
			byte[] profilePhoto = Base64.getDecoder().decode(profilePhoto64);
			firmClass.setProfilePhoto(profilePhoto);
		}
		String coverPhoto64 = firmClass.getCoverPhoto64();
		if (coverPhoto64 != null && !coverPhoto64.isEmpty()) {
			byte[] coverPhoto= Base64.getDecoder().decode(coverPhoto64);
			firmClass.setCoverPhoto(coverPhoto);
		}
		
		int result = dao.update(firmClass);
		System.out.println(result);
		return result >= 1;
	}
	

	// 查詢user資料
	@Override
	public FirmClass selectByUserId(String userId) {
		return dao.selectByUserId(userId);
	}
	
	// 查詢某特定廠商資料
	@Override
	public FirmClass selectByFirmNo(Integer FirmNo) {
		return dao.selectByFirmNo(FirmNo);
	}

	// 查所有廠商
	@Override
	public List<FirmClass> selectAll() {
		return dao.selectAll();
	}

	@Override
	public FirmClass searchFirm(String email) {
		return dao.selectByEmail(email);
	}

	@Override
	public FirmClass login(FirmClass firm) {
		// 信箱: 不為空
		String email =  firm.getFirmEmail();
		if (email == null || email.isEmpty()) {
			return null;
		}
		
		// 密碼: 不為空
		String password = firm.getPassword();
		if (password == null || password.isEmpty()) {
			return null;
		}
		
		return dao.selectByEmailAndPassword(firm.getFirmEmail(), firm.getPassword());
	}






	

}
