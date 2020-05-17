package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.SysMenu;
import com.qf.pojo.SysUser;
import com.qf.utils.R;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface SysUserService {
    public List<SysUser> findAll();

    public DataGridResult findUserByPage(QueryDTO queryDTO);

    public Workbook exportUser();

    public SysUser findByUsername(String username);

    public R saveUser(SysUser sysUser);

    public R deleteUser(List<Long> ids);

    public R findUserById(Long userId);

    public R updateUser(SysUser sysUser);
}
