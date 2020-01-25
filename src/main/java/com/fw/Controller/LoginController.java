package com.fw.Controller;

import com.fw.domain.Result;
import com.fw.domain.User;

import com.fw.service.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

import java.util.Map;

@Controller
@RequestMapping("/login")
@SessionAttributes(value = {"userSession"})
public class LoginController {

    @Resource(name = "loginService")
    private LoginService loginService;
    @Resource(name = "result")
    private Result result;
//    @Resource(name = "permissionResolve")
//    PermissionResolve permissionResolve;
    /**
     * 获取登陆页面
     * */
    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    /**
     * 验证身份
     * */
    @PostMapping
    public ModelAndView checkInfo(User user, Model model){
        ModelAndView mv = new ModelAndView();
        User user1 = loginService.checkInfo(user);
        Map<String,Object> userSession = new HashMap<>();
        System.out.println(user1);
        if(user1==null){
            //用户密码不存在
            mv.setViewName("login");
            result.setCode(1);
            result.setMessage("用户或密码错误");
            mv.addObject("result",result);
            return mv;

        }
        if(!user1.getStatus()){
            mv.setViewName("login");
            result.setCode(1);
            result.setMessage("你的账户已经被停用，请联系管理员");
            mv.addObject("result",result);
            return mv;
        }
        userSession.put("user",user1);
//        PathResolve pathResolve = new PathResolve();
//        //获取用户权限路径
//        List<String> paths =permissionResolve.resolvePermission(user1);
//        paths.add("/index");
//        paths= pathResolve.toRealPath(paths) ;
        userSession.put("paths",null);
        model.addAttribute("userSession",userSession);
        mv.setViewName("redirect:/index");
        return mv;
    }
}
