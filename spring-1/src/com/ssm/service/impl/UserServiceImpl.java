package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    //使用接口UserDao声明对象，添加setter方法，用于依赖注入
    @Autowired
    UserDao userDAO;


//    public void setUserDAO(UserDao userDao){
//        this.userDAO=userDao;
//    }

    //实现接口中的方法
    @Override
    public boolean login(String loginName, String loginPwd) {
        //调用UserDAO中的login（）方法
        return userDAO.login(loginName,loginPwd);
}
}
