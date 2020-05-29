package com.ssm;

import com.ssm.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
    public static void main(String[] args){
        //初始化spring容器
        ApplicationContext context=new
                ClassPathXmlApplicationContext("applicationContext4.xml");
        //通过容器获取配置中的实例
        ProductService productService=
                (ProductService) context.getBean("productService");
        //调用browse方法
        productService.browse("温彬","华为nava4");
    }
}
