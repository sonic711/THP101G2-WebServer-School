package web.member.followclass.service;

import web.member.followclass.bean.FollowClass;

import java.util.List;

public interface FollowClassService{
    boolean newOneFollowClass(FollowClass followClass);
    boolean deleteFollowClassById(Integer id);
    List<FollowClass> findAllFollowClassById(Integer id);
}
