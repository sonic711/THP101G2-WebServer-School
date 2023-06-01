package web.firm.service.impl;

import java.util.List;

import web.firm.bean.FirmClass;
import web.firm.dao.FirmClassDao;
import web.firm.dao.impl.FirmClassDaoImpl;
import web.firm.service.FirmService;

public class FirmServiceImpl implements FirmService{
	private FirmClassDao dao;
	
	public FirmServiceImpl() {
		dao = new FirmClassDaoImpl();
	}
	
	@Override
	public boolean register(FirmClass firm) {
		// 使用者id: 不重複，⻑度5~15
		String userId = firm.getUserId();
		if (dao.selectByUserId(userId) != null
			|| userId.length() < 5 || userId.length() > 15) {
			System.out.println("userid");
			return false;
		}
		
		String password = firm.getPassword();
		if (password.length() < 6 || password.length() > 12) {
			System.out.println("pw");
			return false;
		}
		
		String shopName = firm.getShopName();
		if (shopName != null
			&& shopName.length() < 1 || shopName.length() > 20) {
			System.out.println("shop");
			return false;
		}
		
		String email =  firm.getFirmEmail();
		if (dao.selectByEmail(email) != null
			|| email == null || email.isEmpty()) {
			System.out.println("email");
			return false;
		}
		
		String phone =  firm.getPhoneNumber();
		if (dao.selectByPhone(phone) != null
			|| phone.length() != 10) {
			System.out.println("phone");
			return false;
		}
		
		return dao.insert(firm) >= 1;
	}

	@Override
	public FirmClass login(FirmClass firm) {
		String email =  firm.getFirmEmail();
		if (email == null || email.isEmpty()) {
			return null;
		}
		
		String password = firm.getPassword();
		if (password == null || password.isEmpty()) {
			return null;
		}
		
		return dao.selectByEmailAndPassword(firm.getFirmEmail(), firm.getPassword());
	}

	@Override
	public List<FirmClass> findAll() {
		return dao.selectAll();
	}

}
