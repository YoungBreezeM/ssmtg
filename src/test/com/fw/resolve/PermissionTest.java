package com.fw.resolve;

import com.fw.domain.User;
import com.fw.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PermissionTest {
    @Test
    public void resolve(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PermissionResolve permissionResolve= applicationContext.getBean("permissionResolve", PermissionResolve.class);
        User user = new User();
        user.setUid(3);
        List<String> paths = permissionResolve.resolvePermission(user);
        for (String path:paths){
            System.out.println(path);
        }
    }
}
