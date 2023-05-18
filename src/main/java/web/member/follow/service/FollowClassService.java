package web.member.follow.service;

import web.member.follow.bean.FollowClass;

import java.util.List;

public interface FollowClassService{
    boolean newOneFollowClass(FollowClass followClass);
    boolean deleteFollowClassById(Integer id);
    List<FollowClass> findAllFollowClassById(Integer id);
}
