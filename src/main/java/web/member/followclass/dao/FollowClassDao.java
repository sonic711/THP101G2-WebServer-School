package web.member.followclass.dao;

import web.member.followclass.bean.FollowClass;

import java.util.List;

public interface FollowClassDao {
    int insert(FollowClass followClass);
    int deleteById(Integer id, Integer classId);
    List<FollowClass> findAllById(Integer id);
}
