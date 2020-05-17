package com.study.hot.controller;


import com.study.hot.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DemoController {

    @ModelAttribute
    public UserInfo getView(Integer id){
        if(id!=null){
            UserInfo userInfo = new UserInfo();
            return userInfo;
        }
        return new UserInfo();
    }

    @RequestMapping("/")
    public String sayHello(Model model){
        //model.addAttribute("success","123");
        return "sayHello";
    }

    @RequestMapping("/abc")
    public String abc(Model model){
        model.addAttribute("success","345");
        return "forward:/";
    }

    @RequestMapping("/file")
    @ResponseBody
    public String file(MultipartFile file){
        StringBuilder stringBuilder = new StringBuilder();
        if(!file.isEmpty()){
            stringBuilder.append(file.getContentType()).append("=").append(file.getOriginalFilename()).append("==").append(file.getSize());
            return stringBuilder.toString();
        }
        return "上传失败";
    }
}
