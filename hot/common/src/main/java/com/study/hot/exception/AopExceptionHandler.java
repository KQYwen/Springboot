package com.study.hot.exception;

import com.springboot.ioc.response.ErrorResponseData;
import com.springboot.ioc.response.ResponseData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopExceptionHandler {

    @Pointcut("execution(* com.springboot.ioc.controller.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public ResponseData handler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        ResponseData responseData;
        try{
            responseData = (ResponseData) proceedingJoinPoint.proceed();
        }catch (Exception e){
            if(e instanceof ParameterException){
                return new ErrorResponseData(((ParameterException) e).getCode(),e.getMessage());
            }else{
                return new ErrorResponseData(ResponseData.DEFAULT_ERROR_CODE,ResponseData.DEFAULT_ERROR_MESSAGE);
            }
        }
        return responseData;
    }
}

