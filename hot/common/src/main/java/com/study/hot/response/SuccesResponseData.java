package com.study.hot.response;

public class SuccesResponseData extends ResponseData {

    public SuccesResponseData(){
        super(true,ResponseData.DEFAULT_SUCCESS_CODE,ResponseData.DEFAULT_SUCCESS_MESSAGE,null);
    }

    public SuccesResponseData(Object data){
        super(true,ResponseData.DEFAULT_SUCCESS_CODE,ResponseData.DEFAULT_SUCCESS_MESSAGE,data);
    }

    public SuccesResponseData(Integer code,String message,Object data){
        super(true,code,message,data);
    }
}
