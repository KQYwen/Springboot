package com.study.hot.data;

public enum ParameterExceptionEnum implements AbstraceBaseExceptionEnum {

    PARAM_NOT_NULL(3001,"参数不能为空");

    private Integer code;
    private String message;

    ParameterExceptionEnum(Integer code,String message){
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
