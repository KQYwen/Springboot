package com.ssm.dao;

import com.ssm.ectity.User;

import java.util.List;

public interface UserDao {
    public boolean login(String loginName, String loginPwd);

    public int addUser(User user);

    public int deleteUser(Integer id);

    public int updateUser(User user);

    public User findUserById(Integer id);

    public List<User> findAllUser();
}
