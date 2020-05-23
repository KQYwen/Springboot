package com.ssm;

import com.ssm.ectity.AdminInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringConstructor {
    public static void main(String[] args){
        //加载applicationContext.xml
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取实例
//        AdminInfo adminInfo= (AdminInfo) context.getBean("adminInfo");
        AdminInfo adminInfo= (AdminInfo) context.getBean("admin");
        adminInfo.print();

    }
}
