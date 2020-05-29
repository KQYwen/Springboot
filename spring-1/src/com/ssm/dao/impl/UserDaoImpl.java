package com.ssm.dao.impl;

import com.ssm.dao.UserDao;
import com.ssm.ectity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDAO")
public class UserDaoImpl implements UserDao {
    //声明JdbcTemplate属性及其setter的方法
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean login(String loginName, String loginPwd) {
        if (loginName.equals("admin")&&loginPwd.equals("120831")){
            return true;
        }
        return false;
    }

    @Override
    public int addUser(User user) {
        String sql="insert into user(userName,password) values(?,?)";
        //使用数据组来存储参数
        Object[] objects=new Object[]{user.getUserName(),user.getPassword()};
        //执行他添加操作
        int result=jdbcTemplate.update(sql,objects);
        return result;
    }

    @Override
    public int deleteUser(Integer id) {
        String sql="delete from user where id=?";
        int result=jdbcTemplate.update(sql,id);
        return result;
    }

    @Override
    public int updateUser(User user) {
        String sql="update user set userName=?,password=? where id=?";
        Object[] objects=new Object[]{user.getUserName(),user.getPassword(),user.getId()};
        int result=jdbcTemplate.update(sql,objects);
        return result;
    }

    @Override
    public User findUserById(Integer id) {
        String sql="select * from user where id=?";

        //创建一个新的BeanRowMapper返回一个Object类型的对象，自动将数据库中的数据自动映射到所创建的类中
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public List<User> findAllUser() {
        String sql="select * from user";

        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);

        return this.jdbcTemplate.query(sql,rowMapper);
    }
}
