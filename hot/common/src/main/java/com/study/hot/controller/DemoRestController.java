package com.study.hot.controller;

import com.springboot.ioc.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
@Slf4j
public class DemoRestController {

    @RequestMapping("/")
    public String sayHello(){
        return "sayHello";
    }

    @RequestMapping("/path/{phone}/{token}")
    public String path(@PathVariable String phone,@PathVariable String token){
        return "phone="+ phone + "==token" + token;
    }

    @RequestMapping("/path1")
    public String path1(String phone){
        return "phone="+ phone;
    }

    @RequestMapping("/path2")
    public String path2(@RequestParam(defaultValue = "11") String phone){
        return "phone="+ phone;
    }

    @RequestMapping("/path3")
    public String path3(@Validated({UserInfo.Add.class}) UserInfo userInfo, BindingResult result){
        if(result.hasErrors()){
            StringBuilder stringBuilder = new StringBuilder();
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error: errors){
                FieldError fieldError = (FieldError) error;
                stringBuilder.append(fieldError.getField()).append(fieldError.getDefaultMessage());
                return stringBuilder.toString();
            }
        }
        return userInfo.toString();
    }

    @RequestMapping("/path8")
    public UserInfo path8(UserInfo userInfo){
//        Map<String,String> map = BeanValidation.check(userInfo);
//        if(map!=null && !map.isEmpty()){
//            return map.toString();
//        }
//        if(ToolsUtil.isOneEmpty(userInfo,userInfo.getId(),userInfo.getUserName())){
//            return "参数异常";
//        }
        log.info(userInfo.toString());
        return userInfo;
    }

    @RequestMapping(value = "/path4",consumes = "application/json")
    public String path4(){
        return "this is consumes!";
    }

    @RequestMapping(value = "/path5",produces = "application/json")
    public String path5(){
        return "this is produces!";
    }

    @RequestMapping(value = "/path6",params = "action=update")
    public String path6(String action){
        return "action OK!";
    }

    @RequestMapping(value = "/path7",headers = "app=xxx")
    public String path7(String action){
        return "header OK!";
    }

}
