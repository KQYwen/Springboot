package com.study.hot.controller;

import com.springboot.ioc.data.ParameterExceptionEnum;
import com.springboot.ioc.data.ServiceExceptionEnum;
import com.springboot.ioc.data.SystemExceptionEnum;
import com.springboot.ioc.exception.ParameterException;
import com.springboot.ioc.exception.ServiceException;
import com.springboot.ioc.exception.SystemException;
import com.springboot.ioc.response.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exception")
@ResponseBody
public class ExceptionController {

    @RequestMapping("/system")
    public ResponseData system(){
        throw new SystemException(SystemExceptionEnum.SYSTEM_ERROR);
    }

    @RequestMapping("/service")
    public ResponseData service(){
        throw new ServiceException(ServiceExceptionEnum.NO_THIS_USER);
    }

    @RequestMapping("/param")
    public ResponseData param(){
        throw new ParameterException(ParameterExceptionEnum.PARAM_NOT_NULL);
    }
}
