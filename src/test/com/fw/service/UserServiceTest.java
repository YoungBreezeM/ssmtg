package com.fw.service;

import com.fw.domain.Space;
import com.fw.domain.Student;
import com.fw.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceTest {

    @Test
    public void testFindAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService= applicationContext.getBean("userServiceImpl", UserService.class);
        List<User> users = userService.findAll() ;
        for(User user:users){
            System.out.println(user);
        }

    }
    @Test
    public void addUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService= applicationContext.getBean("userServiceImpl", UserService.class);
        User user = new User();
        user.setUserName("yqf");
        user.setPassword("123");
        user.setEmail("940695836@qq.com");
        user.setPhone("13023867686");
        user.setRealName("杨清峰");
        userService.addUser(user); ;

    }

    @Test
    public void updateUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SpaceService spaceService= applicationContext.getBean("spaceServiceImpl", SpaceService.class);
        Space space = new Space();
        space.setSpaceName("ok");
        space.setPath("d");
        space.setHasInsert(true);
        space.setHasSelect(true);
        space.setHasDelete(true);
        space.setHasUpdate(true);
        spaceService.addSpace(space);
    }
}
