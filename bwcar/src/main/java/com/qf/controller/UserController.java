package com.qf.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.dto.UserDto;
import com.qf.pojo.SysUser;
import com.qf.service.SysUserService;
import com.qf.utils.MD5Utils;
import com.qf.utils.R;
import com.qf.utils.ShiroUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response){
        //缓存设置，设置不缓存（可选操作）
        response.setHeader("Cache-Control","no-store,no-cache");
        //设置响应内容
        response.setContentType("image/jpg");
        //生成验证码
        String text=defaultKaptcha.createText();//文本
        //生成图片
        BufferedImage image=defaultKaptcha.createImage(text);
        //验证码存储到shiro的session
        ShiroUtils.setKaptcha(text);

        try{
            //返回到页面
            ServletOutputStream outputStream=response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/sys/login")
    @ResponseBody
    public R login(@RequestBody UserDto userDto){
       //比对验证码
        String serverKaptcha=ShiroUtils.getKaptcha();
        if (!serverKaptcha.equalsIgnoreCase(userDto.getCaptcha())){
            return R.error("验证码错误");
        }

        Subject subject= SecurityUtils.getSubject();
        String newPass= MD5Utils.md5(userDto.getPassword(),userDto.getUsername(),1024);
        UsernamePasswordToken token=new UsernamePasswordToken(userDto.getUsername(),newPass);
        if (userDto.isRememberMe()){
            token.setRememberMe(true);
        }
        subject.login(token);
        return R.ok();
    }
    @RequestMapping("/sys/user/list")
    @ResponseBody
    public DataGridResult findUser(QueryDTO queryDTO){
        return sysUserService.findUserByPage(queryDTO);
    }

    @RequestMapping("/sys/user/export")
    public void exportUser(HttpServletResponse response){
        Workbook workbook=sysUserService.exportUser();
        try {
            //设置响应头
            response.setContentType("application/octet-stream");//所有文件的支持
            String fileName="员工信息.xls";
            fileName= URLEncoder.encode(fileName,"utf-8");
            response.setHeader("content-disposition","attachment;filename="+fileName);
            //文件下载
            workbook.write(response.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        ShiroUtils.logout();
        return "redirect:login.html";
    }

    @RequestMapping("sys/user/info")
    @ResponseBody
    public R userinfo(){
        //可以从shiro中获取
        SysUser userEntity=ShiroUtils.getUserEntity();
        return R.ok().put("user",userEntity);
    }

    @RequestMapping("/sys/user/save")
    @ResponseBody
    public R saveUser(@RequestBody SysUser sysUser){
        return sysUserService.saveUser(sysUser);
    }

    @RequestMapping("/sys/user/del")
    @ResponseBody
    public R deleteUser(@RequestBody List<Long> ids){
        return sysUserService.deleteUser(ids);
    }

    @RequestMapping("/sys/user/info/{userId}")
    @ResponseBody
    public R findUserById(@PathVariable("userId") Long userId){
        return sysUserService.findUserById(userId);
    }

    @RequestMapping("/sys/user/update")
    @ResponseBody
    public R updateUser(@RequestBody SysUser sysUser){
        return sysUserService.updateUser(sysUser);
    }

}
