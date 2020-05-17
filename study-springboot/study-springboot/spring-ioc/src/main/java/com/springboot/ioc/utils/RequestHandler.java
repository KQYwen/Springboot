package com.springboot.ioc.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestHandler {

    private static final ThreadLocal<HttpServletRequest> REQUEST_DATA = new ThreadLocal<>();

    public static void put(HttpServletRequest request){
        REQUEST_DATA.set(request);
    }

    public static HttpServletRequest get(){
        return REQUEST_DATA.get();
    }

    public static void remove(){
        REQUEST_DATA.remove();
    }
}
