package com.fw.service.impl;

import com.fw.dao.RoleSpaceDao;
import com.fw.dao.RoleDao;
import com.fw.domain.Role;
import com.fw.domain.RoleSpace;
import com.fw.domain.RoleSpaceBase;
import com.fw.domain.Space;
import com.fw.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService {
    @Resource(name = "roleDao")
    private RoleDao roleDao;

    @Resource(name = "roleSpaceDao")
    private RoleSpaceDao roleSpaceDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Boolean isReName(String roleName) {
        List<Role> roles = roleDao.findByRoleName(roleName);
        return roles.size() > 0;
    }



    @Override
    public void deleteRole(Integer rid) {
        roleDao.deleteRole(rid);
    }
    

    @Override
    public void updateRole(com.fw.domain.RoleSpace roleSpace) {
        Role role = roleSpace.getRole();
        List<Space> spaces = roleSpace.getSpaces();
        RoleSpaceBase roleSpaceBase = new RoleSpaceBase();
        //更新角色表
        roleDao.updateRole(role);
        //设置角色id
        roleSpaceBase.setRid(role.getRid());
        for(Space space:spaces){
            roleSpaceBase.setSid(space.getSid());
            roleSpaceBase.setHasInsert(space.getHasInsert());
            roleSpaceBase.setHasSelect(space.getHasSelect());
            roleSpaceBase.setHasUpdate(space.getHasUpdate());
            roleSpaceBase.setHasDelete(space.getHasDelete());
            //查找更新目标对象
            if(this.roleSpaceDao.findRoleSpaceById(roleSpaceBase).size()>0){
                this.roleSpaceDao.updateRoleSpace(roleSpaceBase);
            }else {
                this.roleSpaceDao.addRoleSpace(roleSpaceBase);
            }
        }

    }

    @Override
    public Role findById(Integer rid) {
        List<Role> roles = roleDao.findById(rid);
        if (roles.isEmpty()){
            return null;
        }
        if(roles.size()>1){
            throw new RuntimeException("datatable is err");
        }
        return roles.get(0);
    }

    @Override
    public Role findByName(String roleName) {
        List<Role> roles= roleDao.findByRoleName(roleName);
        if(roles.isEmpty()){
            return null;
        }
        if(roles.size()>1){
            throw new RuntimeException("角色名重复，请及时修正bug");
        }
        return roles.get(0);
    }

    @Override
    public void addRoleSpace(RoleSpace roleSpace) {
        Role role = roleSpace.getRole();
        RoleSpaceBase roleSpaceBase = new RoleSpaceBase();
        List<Space> spaces = roleSpace.getSpaces();
        //添加角色
        roleDao.addRole(role);
        //查找角色id
        Integer rid = this.findByName(role.getRoleName()).getRid();
        roleSpaceBase.setRid(rid);
        //添加权限
        for (Space space:spaces){
            roleSpaceBase.setSid(space.getSid());
            roleSpaceBase.setHasInsert(space.getHasInsert());
            roleSpaceBase.setHasSelect(space.getHasSelect());
            roleSpaceBase.setHasUpdate(space.getHasUpdate());
            roleSpaceBase.setHasDelete(space.getHasDelete());
            this.roleSpaceDao.addRoleSpace(roleSpaceBase);
        }
    }

    @Override
    public List<RoleSpaceBase> findAllRoleSpace(Integer rid) {
        return roleSpaceDao.findAllRoleSpace(rid);
    }


}
