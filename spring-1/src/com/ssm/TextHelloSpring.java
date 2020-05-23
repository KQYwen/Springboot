package com.ssm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextHelloSpring {
    public static void main(String[] args){
        //初始化spring容器，加载applicationcontext.xml配置
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取配置中的helliSpring的实例
        HelloSpring helloSpring= (HelloSpring) context.getBean("helloSpring");
        helloSpring.show();
    }
}
