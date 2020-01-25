package com.fw.resolve;

import com.fw.domain.*;
import com.fw.service.RoleService;
import com.fw.service.SpaceService;
import com.fw.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component("permissionResolve")
public class PermissionResolve {
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "roleService")
    private RoleService roleService;
    @Resource(name = "spaceService")
    private SpaceService spaceService;
    /**
     * 解析用户角色id
     * */
    private UserRoleBase resolveUserRole(User user){
        return userService.findUserRole(user);
    }
    /**
     * 解析角色空间
     * */
    private List<RoleSpaceBase> resolveRoleSpace(Integer rid){
        return roleService.findAllRoleSpace(rid);
    }
    /**
     * 解析用户权限
     * */
    public List<String> resolvePermission(User user){
        UserRoleBase userRoleBase = this.resolveUserRole(user);
        List<RoleSpaceBase> roleSpaceBases = this.resolveRoleSpace(userRoleBase.getRid());
        ArrayList<String> paths = new ArrayList<>();
        for (RoleSpaceBase roleSpaceBase:roleSpaceBases){
            Space space= spaceService.findById(roleSpaceBase.getSid());
            String path = space.getPath();
            if(roleSpaceBase.getHasSelect()!=null){
                paths.add(path);
                String options =path+"/select";
                paths.add(options);
            }
            if(roleSpaceBase.getHasDelete()!=null){
                String options = path+"/delete";
                paths.add(options);
            }
            if(roleSpaceBase.getHasInsert()!=null){
                String options = path+"/insert";
                paths.add(options);
            }
            if(roleSpaceBase.getHasUpdate()!=null){
                String options = path+"/update";
                paths.add(options);
            }
        }
        return paths;
    }


}
