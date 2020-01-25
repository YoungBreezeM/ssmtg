package com.fw.Controller;

import com.fw.domain.*;
import com.fw.service.RoleService;
import com.fw.service.UserService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "roleService")
    private RoleService roleService;

    @Resource(name = "result")
    private Result result;

    /**
     * 查找所有用户
     * */
    @GetMapping
    public ModelAndView getUserPage(){
        ModelAndView mv = new ModelAndView();
        List<User> users = userService.findAll();
        mv.addObject("users",users);
        mv.setViewName("admin/admin/admin-list");
        return mv;
    }

    /**
     * 获取更新页面
     * */
    @GetMapping(value ="update/{uid}")
    public ModelAndView findUserById(@PathVariable Integer uid){
        ModelAndView mv = new ModelAndView();
        User user = userService.findById(uid);
        List<Role> roles = roleService.findAll();
        UserRoleBase userRoleBase = userService.findUserRole(user);
        mv.addObject("roles",roles);
        mv.addObject("user",user);
        mv.addObject("userRoleBase",userRoleBase);
        mv.setViewName("admin/admin/admin-update");
        return mv;
    }

    /**
     * 更新用户信息
     * */
    @PostMapping(value = "update")
    public ModelAndView updateUser(User user,Role role){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/admin/admin-update");
        //更新用户角色
        userService.updateUserRole(user,role);
        result.setMessage("success");
        result.setCode(0);
        mv.addObject("result",result);
        return mv;
    }

    /**
     * 获取插入页面
     * */
    @GetMapping(value = "insert")
    public ModelAndView  getInsertPage(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roles",roles);
        mv.setViewName("admin/admin/admin-insert");
        return mv;
    }

    /**
     * 插入用户信息
     * */
    @PostMapping(value = "insert")
    public ModelAndView insertUser(UserRole userRole){
        System.out.println(userRole);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/admin/admin-insert");
        if(userService.isReName(userRole.getUser().getUserName())){
            result.setCode(1);
            result.setMessage("用户名已经存在");
            mv.addObject("result",result);
            return mv;
        }
        //给用户添加角色
        userService.addUserRole(userRole);
        result.setCode(0);
        result.setMessage("success");
        mv.addObject("result",result);
        return mv;
    }
    /**
     * 删除用户
     * */
    @GetMapping(value = "delete/{uid}")
    public String deleteUser(@PathVariable Integer uid){
        userService.deleteUser(uid);
        return "success";
    }

    /**
     * 启用管理员
     * */
    @PostMapping("/start")
    public Result startUser(@RequestBody User user){
        user.setStatus(true);
        System.out.println(user);
        userService.updateUserStatus(user);
        result.setCode(0);
        result.setMessage("启用成功");
        return result;

    }

    /**
     * 禁用用户
     * */
    @PostMapping("/stop")
    public Result stopUser(@RequestBody User user){
        user.setStatus(false);
        System.out.println(user);
        userService.updateUserStatus(user);
        result.setCode(0);
        result.setMessage("禁用成功");
        return result;
    }


}
