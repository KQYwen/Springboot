package com.ssm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbcTemplate {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext(
                "applicationContextJDBC.xml");

            JdbcTemplate jdbcTemplate= (JdbcTemplate) context.getBean("jdbcTemplate");

            String sql="create table user(id int primary key auto_increment,userName varchar(20)," +
                    "password varchar(32))";

            jdbcTemplate.execute(sql);
            System.out.println("数据表创建成功");



    }
}
