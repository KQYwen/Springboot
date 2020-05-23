package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.Car;
import com.qf.pojo.CarParamType;
import com.qf.service.CaeParamTypeService;
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
public class CarParamTypeController {

    @Autowired
    private CaeParamTypeService caeParamTypeService;

    @RequestMapping("/sys/paramtype/list")
    @ResponseBody
    public DataGridResult findCarparamType(QueryDTO queryDTO){
        return caeParamTypeService.findByPage(queryDTO);
    }

    @RequestMapping("/sys/paramtype/del")
    @ResponseBody
    public R delCarparamType(@RequestBody List<Integer> ids){
        for (Integer id:ids){
            caeParamTypeService.delCarPaeamType(id);
        }
        return R.ok();
    }


    @RequestMapping("/sys/paramtype/info/{id}")
    @ResponseBody
    public R findById(@PathVariable("id")Integer id){
        CarParamType byId=caeParamTypeService.findById(id);
        return R.ok().put("paramtype",byId);
    }


    @RequestMapping("/sys/paramtype/save")
    @ResponseBody
    public R addCaramType(@RequestBody CarParamType carParamType){
        int i=caeParamTypeService.addCarPaeamType(carParamType);
        return i>0?R.ok():R.error("添加失败");
    }


    @RequestMapping("/sys/paramtype/update")
    @ResponseBody
    public R updateCaramType(@RequestBody CarParamType carParamType){
        int i=caeParamTypeService.updateCarPaeamType(carParamType);
        return i>0?R.ok():R.error("修改失败");
    }


}
