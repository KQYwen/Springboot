package com.study.hot.exception;

import com.springboot.ioc.data.AbstraceBaseExceptionEnum;

public class ServiceException extends RuntimeException{

    private Integer code;
    private String errorMessage;

    public ServiceException(Integer code,String errorMessage){
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(AbstraceBaseExceptionEnum exception){
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return this.code;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }

}
