package com.fw.service;

import com.fw.domain.Role;
import com.fw.domain.RoleSpace;
import com.fw.domain.RoleSpaceBase;

import java.util.List;

public interface RoleService {
    /**
     * 查找所有角色信息
     * */
    List<Role> findAll();

    /**
     * 查询角色名是否重复
     * */
    Boolean isReName(String roleName);

    /**
     * 删除用户
     * */
    void deleteRole(Integer rid);

    /**
     * 更新用户
     * */
    void updateRole(RoleSpace roleSpace);

    /**
     * 通过id 查找
     * */
    Role findById(Integer rid);

    /**
     * 通过角色查找
     * */
    Role findByName(String roleName);

    /**
     * 插入信息
     * */
    void addRoleSpace(RoleSpace roleSpace);



    List<RoleSpaceBase> findAllRoleSpace(Integer rid);
}
