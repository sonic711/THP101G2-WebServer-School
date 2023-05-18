package web.community.classes.dao;


import web.community.classes.bean.CommunityClass;
import web.community.classes.bean.MainClass;
import web.community.classes.bean.SecClass;

import java.util.List;

public interface ClassDao {
    List<MainClass> selectAllMainClass();
    List<SecClass> selectAllSecClass();
    List<CommunityClass> selectAllClass();
}
