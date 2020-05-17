package com.study.hot.data;

public enum SystemExceptionEnum implements AbstraceBaseExceptionEnum {

    SYSTEM_ERROR(1001,"服务器错误"),
    SYSTEM_NULL(1002,"服务不存在");

    private Integer code;
    private String message;

    SystemExceptionEnum(Integer code,String message){
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
    public String getMessage() {
        return message;
    }
}
