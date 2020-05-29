package com.ssm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Aspect
@Component
public class ALLLogAdvice {

    @Pointcut("execution(* com.ssm.service.ProductService.*(..))")
    //使用一个返回值void、方法体为空的方法来命名切入点
    private void allMethod(){

    }
    //此方法为前置通知
    @Before("allMethod()")
    public void myBeforeAdvice(JoinPoint joinPoint){
        //获取业务方法参数
        List<Object> args= Arrays.asList(joinPoint.getArgs());
        //日志格式字符串
        String logInfoText="前置通知："
                +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date())+" "+args.get(0).toString()
                +"浏览商品"+args.get(1).toString();
        //将日志输出到控制台
        System.out.println(logInfoText);
    }

    //返回通知
    @AfterReturning("allMethod()")
    public void myAfterReturnAdvice(JoinPoint joinPoint){
        //获取方法参数
        List<Object> args=Arrays.asList(joinPoint.getArgs());

        //日志格式串
        String loginfoText="返回通知："
                +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date())+"  "+args.get(0).toString()
                +"浏览商品"+args.get(1).toString();
        //将日志输出到控制台
        System.out.println(loginfoText);
    }

    //异常通知
    @AfterThrowing(pointcut = "allMethod()",throwing = "e")
    public void myThrowAdvice(JoinPoint joinPoint,Exception e){
        //获取被调取的类名
        String targetClassName=joinPoint.getTarget().getClass().getName();
        //获取被调取的方法名
        String targetMethodName=joinPoint.getSignature().getName();
        //日志格式字符串
        String logInfoText="异常通知：执行"+targetClassName+"类的"
                +targetMethodName+"方法时出现异常";

        System.out.println(logInfoText);
    }

    //环绕通知
    @Around("allMethod()")

    public void myAroundAdvice(ProceedingJoinPoint joinPoint)throws Throwable{
        long beginTime=System.currentTimeMillis();
        joinPoint.proceed();
        long endTime=System.currentTimeMillis();

        //获取被调用的方法名
        String targetMethodName=joinPoint.getSignature().getName();

        String logInfoText="环绕通知"+targetMethodName+"方法调用前时间"+
                beginTime+"毫秒"+"调用后时间"+endTime+"毫秒";

        System.out.println(logInfoText);
    }
}
