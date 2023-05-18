package web.member.follow.dao;

import web.member.follow.bean.FollowClass;

import java.util.List;

public interface FollowClassDao {
    int insert(FollowClass followClass);
    int deleteById(Integer id);
    List<FollowClass> findAllById(Integer id);
}
