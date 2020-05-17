package com.study.hot.controller;

import com.springboot.ioc.utils.RequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestController {

    @RequestMapping("/display")
    public String display(){
        return RequestHandler.get().getRequestURI()+RequestHandler.get().getPathInfo();
    }
}
