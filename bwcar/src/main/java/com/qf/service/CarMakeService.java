package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarMake;

import java.util.List;

public interface CarMakeService {

    public int addCarMake(CarMake carMake);

    public void delCarMake(Integer id);

    public int updateCarMake(CarMake carMake);

    public List<CarMake> findAll();

    public CarMake findById(Integer id);

    public DataGridResult findByPage(QueryDTO queryDTO);
}
