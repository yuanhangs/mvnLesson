package org.aly.hlx.dao.impl;

import org.aly.hlx.dao.UserinfoDao;
import org.aly.hlx.entity.UserInfo;
import org.aly.hlx.util.BaseDao;

import java.util.List;

/**
 * 底层数据实现
 */
public class UserinfoDaoImpl extends BaseDao implements UserinfoDao {
    @Override
    public UserInfo isLogin(UserInfo userInfo) throws Exception {
        //sql语句
        String sql = "SELECT * from userinfo WHERE userName=? and `passWord`=?";
        //参数
        Object[] obj = {userInfo.getUserName(), userInfo.getPassWord()};
        //调用方法
        return this.excuteOneQuery(sql, UserInfo.class, obj);
    }

    @Override
    public int add(UserInfo userInfo) throws Exception {
        return 0;
    }

    @Override
    public int del(String id) {
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
        String sql = "";
        List<UserInfo> list = null;
        if (param.length == 0) {
            //sql语句
            sql = "SELECT * from userinfo";
            //调用方法
            list = this.excuteMoreQuery(sql, UserInfo.class);
        } else {
            sql = "SELECT * from userinfo where username like ?";
            //参数
            Object[] obj = {"%" + param[0] + "%"};
            //调用方法
            list = this.excuteMoreQuery(sql, UserInfo.class, obj);
        }

        return list;
    }
}
