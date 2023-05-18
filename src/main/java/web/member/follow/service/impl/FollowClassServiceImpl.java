package web.member.follow.service.impl;

import web.member.follow.bean.FollowClass;
import web.member.follow.dao.FollowClassDao;
import web.member.follow.dao.impl.FollowClassDaoImpl;
import web.member.follow.service.FollowClassService;

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
