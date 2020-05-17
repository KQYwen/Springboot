package com.study.hot.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseData {

    public static  final String DEFAULT_SUCCESS_MESSAGE = "请求成功";
    public static final Integer DEFAULT_SUCCESS_CODE = 200;
    public static  final String DEFAULT_ERROR_MESSAGE = "请求异常";
    public static final Integer DEFAULT_ERROR_CODE = 500;

    //请求的是否成功
    private Boolean success;
    //返回结果码
    private Integer code;
    //返回的结果信息
    private String message;
    //返回的结果数据
    private Object data;

    public ResponseData(){

    }

    public ResponseData(Boolean success,Integer code,String message,Object data){
        this.success =success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public SuccesResponseData success(){
        return new SuccesResponseData();
    }

    public SuccesResponseData success(Object data){
        return new SuccesResponseData(data);
    }

    public SuccesResponseData success(Integer code,String message,Object data){
        return new SuccesResponseData(code,message,data);
    }

    public ErrorResponseData error(String message){
        return new ErrorResponseData(message);
    }

    public ErrorResponseData error(Integer code, String message){
        return new ErrorResponseData(code,message);
    }

    public ErrorResponseData error(Integer code,String message,Object data){
        return new ErrorResponseData(code,message,data);
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("success",success);
        map.put("code",code);
        map.put("message",message);
        map.put("data",data);
        return map;
    }
}
