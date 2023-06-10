package web.calendar.tag.service.impl;

import java.util.List;

import web.calendar.tag.bean.TagUserDefined;
import web.calendar.tag.dao.TagColorDao;
import web.calendar.tag.dao.TagDefaultDao;
import web.calendar.tag.dao.TagUserDefDao;
import web.calendar.tag.dao.impl.TagColorDaoImpl;
import web.calendar.tag.dao.impl.TagDefaultDaoImpl;
import web.calendar.tag.dao.impl.TagUserDefDaoImpl;
import web.calendar.tag.service.TagUserDefService;

public class TagUserDefServiceImpl implements TagUserDefService{
	private TagUserDefDao dao;
	private TagColorDao tagDao;
	private TagDefaultDao defaultDao;
	
	public TagUserDefServiceImpl() {
		dao = new TagUserDefDaoImpl();
		tagDao = new TagColorDaoImpl();
		defaultDao = new TagDefaultDaoImpl();
	}
	
	@Override
	public boolean add(TagUserDefined tud) {
		// memberNo: 不為空
		Integer memberNo = tud.getMemberNo();
		if (memberNo == null) {
			return false;
		}
		
		// tagId: 不為空，須在資料庫中存在
		Integer tagId = tud.getTagId();
		if (tagId == null 
			|| tagDao.selectTag(tagId) == null) {
			return false;
		}
		
		// definedColname: 不為空，1-12字元
		String colorName = tud.getDefinedColname();
		if (colorName != null
			&& colorName.isEmpty()
			&& (colorName.length() < 1 || colorName.length() > 12)) {
			return false;
		}
		
		return dao.insert(tud) >= 1;
	}

	@Override
	public boolean edit(TagUserDefined tud) {
		// definedColname: 不為空，1-12字元
		String definedColname = tud.getDefinedColname();
		if (definedColname != null
			&& !definedColname.isEmpty()
			&& (definedColname.length() < 1 || definedColname.length() > 12)) {
			return false;
		}
		
		// tagUserDefinedId: 需存在
		Integer tagUserDefinedId = tud.getTagUserDefinedId();
		if (dao.selectByDefined(tagUserDefinedId) == null) {
			return false;
		}
		return dao.update(tud) >= 1;
	}

	@Override
	public boolean delete(TagUserDefined tud) {
		Integer tudId = tud.getTagUserDefinedId(); 
		if (tudId == null) {
			return false;
		}
		return dao.deleteById(tudId) >= 1;
	}

	@Override
	public List<TagUserDefined> findAllByMemberNo(Integer memberNo) {
		if (memberNo == null) {
			return null;
		}
		return dao.selectByMemberNo(memberNo);
	}

	@Override
	public List<TagUserDefined> findAll() {
		return dao.selectAll();
	}

	@Override
	public boolean addAll(Integer memberNo) {
		if (memberNo == null) {
			return false;
		}
		return defaultDao.selectIdAndName(memberNo) >= 1;
	}

}
