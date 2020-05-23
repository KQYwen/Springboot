package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarParamType;
import com.qf.pojo.CarParams;
import com.qf.service.CaeParamTypeService;
import com.qf.service.CarParamService;
import com.qf.utils.R;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarParamsController {

    @Autowired
    private CarParamService carParamService;

    @Autowired
    private CaeParamTypeService caeParamTypeService;

    @RequestMapping("/sys/params/list")
    @ResponseBody
    public DataGridResult findById(QueryDTO queryDTO){
        return carParamService.findByPage(queryDTO);
    }

    @RequestMapping("/sys/params/del")
    @ResponseBody
    public R deleteCarParams(@RequestBody List<Integer> ids){
        for (Integer id:ids){
            carParamService.delCarParams(id);
        }
        return R.ok();
    }

    //获取分类信息
    @RequestMapping("/sys/params/typeall")
    @ResponseBody
    public R typeAll(){
        List<CarParamType> all=caeParamTypeService.findAll();
        return R.ok().put("sites",all);
    }

    @RequestMapping("/sys/params/info/{id}")
    @ResponseBody
    public R findById(@PathVariable("id") Integer id){
        CarParams byId=carParamService.findById(id);
        return R.ok().put("params",byId);
    }


    @RequestMapping("/sys/params/save")
    @ResponseBody
    public R addCarParams(@RequestBody CarParams carParams){
        int i=carParamService.addCarParams(carParams);
        return i>0?R.ok():R.error("添加失败");
    }

    @RequestMapping("/sys/params/update")
    @ResponseBody
    public R updateCarParams(@RequestBody CarParams carParams){
        int i=carParamService.updateCarParams(carParams);
        return i>0?R.ok():R.error("修改失败");
    }

}
