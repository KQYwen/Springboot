package com.ssm;

import com.ssm.service.UserService;
import com.ssm.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringDI {
    public static void main(String[] args){
        //加载配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取配置中的UserServiceImpl实例
        UserService userService= (UserService) context.getBean("userService");
        boolean flag=userService.login("admin","120831");

        if (flag){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
