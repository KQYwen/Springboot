package com.study.hot.data;

public enum ServiceExceptionEnum implements AbstraceBaseExceptionEnum {

    NO_THIS_USER(2001,"没有此用户"),
    OLD_PWD_NOT_RIGHT(2002,"密码不正确");

    private Integer code;
    private String message;

    ServiceExceptionEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
