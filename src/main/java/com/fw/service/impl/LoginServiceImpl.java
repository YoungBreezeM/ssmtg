package com.fw.service.impl;

import com.fw.dao.UserDao;
import com.fw.domain.User;
import com.fw.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public User checkInfo(User user) {
        List<User> users = userDao.findByNameAndPassword(user);
        if(users.isEmpty()){
            return null;
        }
        if(users.size()>1){
            throw new RuntimeException("用户名相同请及时修改");
        }
        return users.get(0);
    }
}
