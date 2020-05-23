package com.ssm.dao.impl;

import com.ssm.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String loginName, String loginPwd) {
        if (loginName.equals("admin")&&loginPwd.equals("120831")){
            return true;
        }
        return false;
    }
}
