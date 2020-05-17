package com.qf.service.impl;

import com.qf.dao.SysRoleMapper;
import com.qf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
/*
根据用户ID查询角色信息

 */
    @Override
    public List<String> findRolesByUserID(Long userId) {
        return sysRoleMapper.findRolesByUserId(userId);
    }
}
