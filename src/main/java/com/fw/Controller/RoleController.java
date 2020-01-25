package com.fw.Controller;

import com.fw.domain.*;
import com.fw.service.RoleService;
import com.fw.service.SpaceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Resource(name = "roleService")
    private RoleService roleService;

    @Resource(name = "spaceService")
    private SpaceService spaceService;

    @Resource(name = "result")
    private Result result;

    /**
     * 获取角色页面列表
     * */
    @GetMapping
    public ModelAndView getRolePage(){
        List<Role> roles = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        //添加角色
        mv.addObject("roles",roles);
        mv.setViewName("admin/role/admin-role");
        return mv;
    }

    /**
     * 获取添加角色页面
     * */
    @GetMapping(value = "/insert")
    public ModelAndView getAddPage(){
        List<Space> spaces = spaceService.findAll();
        ModelAndView mv = new ModelAndView();
        //添加空间
        mv.addObject("spaces",spaces);
        mv.setViewName("admin/role/admin-role-add");
        return mv;
    }

    /**
     * 添加角色
     * */
    @PostMapping(value = "/insert")
    public ModelAndView addRole(RoleSpace roleSpace){
        Role role = roleSpace.getRole();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/role/admin-role-add");
        if(roleService.isReName(role.getRoleName())){
            result.setCode(1);
            result.setMessage("角色名已经存在");
            mv.addObject("result",result);
            return mv;
        }
        //添加角色权限
        roleService.addRoleSpace(roleSpace);
        result.setCode(0);
        result.setMessage("success");
        mv.addObject("result",result);
        return mv;
    }

    /**
     * 删除角色
     * */
    @GetMapping(value = "delete/{rid}")
    public String deleteRole(@PathVariable Integer rid){
        roleService.deleteRole(rid);
        return "success";
    }

    /**
     * 角色更新页面获取
     * */
    @GetMapping(value = "/update/{rid}")
    public ModelAndView getUpdatePage(@PathVariable Integer rid){
        ModelAndView mv = new ModelAndView();
        //获取角色信息
        Role role = roleService.findById(rid);
        //获取权限列表
        List<Space> spaces = spaceService.findAll();
        //获取角色权限列表
        List<RoleSpaceBase> roleSpaceBases= roleService.findAllRoleSpace(role.getRid());
        mv.addObject("role",role);
        mv.addObject("spaces",spaces);
        mv.addObject("roleSpaceBases",roleSpaceBases);
        mv.setViewName("admin/role/admin-role-update");
        return mv;
    }

    /**
     * 角色更新
     * */
    @PostMapping(value = "update")
    public ModelAndView updateRole(RoleSpace roleSpace){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/role/admin-role-update");
        Result result = new Result();
        roleService.updateRole(roleSpace);
        result.setCode(0);
        result.setMessage("success");
        mv.addObject("result",result);
        return mv;
    }
}
