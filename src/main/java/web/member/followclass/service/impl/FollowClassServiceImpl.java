package web.member.followclass.service.impl;

import web.member.followclass.bean.FollowClass;
import web.member.followclass.dao.FollowClassDao;
import web.member.followclass.dao.impl.FollowClassDaoImpl;
import web.member.followclass.service.FollowClassService;

import java.util.List;

public class FollowClassServiceImpl implements FollowClassService {
    private FollowClassDao dao;

    public FollowClassServiceImpl() {
        dao = new FollowClassDaoImpl();
    }

    @Override
    public boolean newOneFollowClass(FollowClass followClass) {
        int result = dao.insert(followClass);
        return result > 0;
    }

    @Override
    public boolean deleteFollowClassById(Integer id) {
        int result = dao.deleteById(id);
        return result > 0;
    }

    @Override
    public List<FollowClass> findAllFollowClassById(Integer id) {
        return dao.findAllById(id);
    }
}
