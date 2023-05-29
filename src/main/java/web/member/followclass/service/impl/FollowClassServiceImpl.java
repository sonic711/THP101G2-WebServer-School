package web.member.followclass.service.impl;

import web.member.followclass.bean.FollowClass;
import web.member.followclass.dao.FollowClassDao;
import web.member.followclass.dao.impl.FollowClassDaoImpl;
import web.member.followclass.service.FollowClassService;

import java.util.Iterator;
import java.util.List;

public class FollowClassServiceImpl implements FollowClassService {
    private FollowClassDao dao;

    public FollowClassServiceImpl() {
        dao = new FollowClassDaoImpl();
    }

    /**
     * 追蹤分類前會先查詢有無追蹤紀錄，有的話直接回傳false
     *
     * @param followClass 前端傳給後端的物件
     * @return 追蹤是否成功
     */
    @Override
    public boolean newOneFollowClass(FollowClass followClass) {

        List<FollowClass> followClasses = dao.findAllById(followClass.getMemberNo());
        Iterator<FollowClass> it = followClasses.iterator();
        while (it.hasNext()) {
            if (followClass.getComSecClassId() == it.next().getComSecClassId()) {
                return false;
            }
        }
        int result = dao.insert(followClass);
        return result > 0;
    }

    @Override
    public boolean deleteFollowClassById(Integer id, Integer classId) {
        int result = dao.deleteById(id, classId);
        return result > 0;
    }

    @Override
    public List<FollowClass> findAllFollowClassById(Integer id) {
        return dao.findAllById(id);
    }
}
