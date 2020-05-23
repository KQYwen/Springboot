package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarParamType;

import java.util.List;

public interface CaeParamTypeService {

    public int addCarPaeamType(CarParamType carParamType);

    public void delCarPaeamType(Integer id);

    public int updateCarPaeamType(CarParamType carParamType);

    public CarParamType findById(Integer id);

    public List<CarParamType> findAll();

    public DataGridResult findByPage(QueryDTO queryDTO);
}
