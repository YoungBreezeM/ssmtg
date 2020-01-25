package com.fw.interceptor;

import com.fw.utils.PathResolve;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        PathResolve pathResolve = new PathResolve();
        HttpSession session = request.getSession();
        String url = pathResolve.toRealPath(request.getRequestURI());
        Map<String,Object> userSession = (Map<String, Object>) session.getAttribute("userSession");
        List<String> paths = (List<String>) userSession.get("paths");
//        System.out.println(paths);
//        System.out.println(url);
        int index = paths.indexOf(url);
        if(index != -1){
            return true;
        }else{
            response.sendRedirect(request.getContextPath()+"/msg/noPermission");
            return false;
        }
    }
}
