package org.aly.hlx.biz.impl;

import org.aly.hlx.biz.UserinfoBiz;
import org.aly.hlx.dao.UserinfoDao;
import org.aly.hlx.dao.impl.UserinfoDaoImpl;
import org.aly.hlx.entity.UserInfo;

import java.util.List;

/**
 * 业务层
 */
public class UserinfoBizImpl implements UserinfoBiz {
    //底层对象
    private UserinfoDao dao = new UserinfoDaoImpl();

    @Override
    public UserInfo isLogin(UserInfo userInfo) throws Exception {
        return dao.isLogin(userInfo);
    }

    @Override
    public int add(UserInfo userInfo) throws Exception {
        return 0;
    }

    @Override
    public int del(String id) throws Exception {
        return 0;
    }

    @Override
    public int update(UserInfo userInfo) throws Exception {
        return 0;
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return null;
    }

    @Override
    public List<UserInfo> all(Object... param) throws Exception {
        return dao.all(param);
    }
}
