package com.study.hot.exception;

import com.springboot.ioc.response.ErrorResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
@Slf4j
public class AdviceExceptionHandler {

    /**
     * 拦截系统异常
     */
    @ExceptionHandler(SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseData system(SystemException exception){
        log.error("系统异常："+exception);
        return new ErrorResponseData(exception.getCode(),exception.getMessage());
    }

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseData service(ServiceException exception){
        log.error("系统异常："+exception);
        return new ErrorResponseData(exception.getCode(),exception.getMessage());
    }

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(ParameterException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseData param(ParameterException exception){
        log.error("系统异常："+exception);
        return new ErrorResponseData(exception.getCode(),exception.getMessage());
    }
}
