package com.fw.interceptor;


import com.fw.domain.User;
import com.fw.resolve.PermissionResolve;
import com.fw.utils.PathResolve;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
    @Resource(name = "permissionResolve")
    PermissionResolve permissionResolve;
    /**
     * @return true 应许通过 到下一个拦截器
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("userSession")!=null){
//            System.out.println(session.getAttribute("userSession"));
            Map<String,Object> userSession = (Map<String, Object>) session.getAttribute("userSession");
            User user = (User) userSession.get("user");
            PathResolve pathResolve = new PathResolve();
            //获取用户权限路径
            List<String> paths =permissionResolve.resolvePermission(user);
            paths.add("/index");
            paths= pathResolve.toRealPath(paths);
            userSession.put("paths",paths);
            session.setAttribute("userSession",userSession);
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
    }


}
