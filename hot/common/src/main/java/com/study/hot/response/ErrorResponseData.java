package com.study.hot.response;

public class ErrorResponseData extends ResponseData {

    public ErrorResponseData(String message){
        super(false,ResponseData.DEFAULT_ERROR_CODE,message,null);
    }

    public ErrorResponseData(Integer code, String message){
        super(false,code,message,null);
    }

    public ErrorResponseData(Integer code,String message,Object data){
        super(false,code,message,data);
    }
}
