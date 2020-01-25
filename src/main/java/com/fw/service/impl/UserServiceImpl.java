package com.fw.service.impl;
import com.fw.dao.UserDao;
import com.fw.dao.UserRoleDao;
import com.fw.domain.Role;
import com.fw.domain.User;
import com.fw.domain.UserRole;
import com.fw.domain.UserRoleBase;
import com.fw.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource(name = "userDao")
    private UserDao userDao;
    @Resource(name = "userRoleDao")
    private UserRoleDao userRoleDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer uid) {
        List<User> users = userDao.findById(uid);
        if(users.isEmpty()){
            return null;
        }
        if (users.size()>1){
            throw new RuntimeException("数据库出错");
        }
        return users.get(0);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(Integer uid) {
        userDao.deleteUser(uid);
    }


    @Override
    public void addUserRole(UserRole userRole) {
        User user = userRole.getUser();
        //添加用户
        userDao.addUser(user);
        Integer uid = this.findByName(user.getUserName()).getUid();
        //添加角色
        UserRoleBase userRoleBase = new UserRoleBase();
        userRoleBase.setUid(uid);
        userRoleBase.setRid(userRole.getRole().getRid());
        userRoleDao.addUserRole(userRoleBase);
    }


    @Override
    public void updateUserRole(User user,Role role) {
        //更新用户
        userDao.updateUser(user);
        //更新用户角色
        Integer uid = user.getUid();
        UserRoleBase userRoleBase = new UserRoleBase();
        List<UserRoleBase> userRoleBases = userRoleDao.findUserRoleByUid(uid);
        userRoleBase.setUid(uid);
        userRoleBase.setRid(role.getRid());
        if(userRoleBases.size()>0){
            userRoleDao.updateUserRole(userRoleBase);
        }else {
            userRoleDao.addUserRole(userRoleBase);
        }
    }


    @Override
    public Boolean isReName(String userName) {
        List<User> users = userDao.findAllByName(userName);
        return users.size() > 0;
    }

    @Override
    public User findByName(String userName) {
        List<User> users = userDao.findAllByName(userName);
        if(users.isEmpty()){
            return null;
        }
        if(users.size()>1){
            throw new RuntimeException("用户相同，请及时修改数据");
        }
        return users.get(0);
    }

    @Override
    public UserRoleBase findUserRole(User user) {
        List<UserRoleBase> userRoleBases = userRoleDao.findUserRoleByUid(user.getUid());
//        System.out.println(userRoleBases);
        if(userRoleBases.isEmpty()){
            return null;
        }
        return userRoleBases.get(0);
    }

    @Override
    public void updateUserStatus(User user) {
        userDao.updateUserStatus(user);
    }

}
