package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;

import java.util.List;

public interface RoleService {
    public List<String> findRolesByUserID(Long userId);

}
