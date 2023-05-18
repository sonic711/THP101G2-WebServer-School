package web.community.classes.service.impl;

import web.community.classes.bean.CommunityClass;
import web.community.classes.dao.ClassDao;
import web.community.classes.dao.impl.ClassDaoImpl;
import web.community.classes.service.ClassService;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    private ClassDao dao;

    public ClassServiceImpl() {
        dao = new ClassDaoImpl();
    }
    @Override
    public List<CommunityClass> findAllClass() {
        return dao.selectAllClass();
    }
}
