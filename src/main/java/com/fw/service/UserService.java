package com.fw.service;

import com.fw.domain.*;

import java.util.List;

public interface UserService {
    /**
     * 查找所有信息
     * */
    List<User> findAll();

    /**
     * 通过id查找用户
     * */

    User findById(Integer uid);

    /**
     * 添加用户
     * */
    void addUser(User user);

    /**
     * 删除用户
     * */

    void deleteUser(Integer uid);

    /**
     * 添加角色
     * **/
    void addUserRole(UserRole userRole);

    /**
     * 更新角色
     * */
    void updateUserRole(User user, Role role);

    /**
     * 用户名字是否存在
     * */
    Boolean isReName(String userName);
    /**
     * 通过用户名字查找
     * */
    User findByName(String userName);

    /**
     * 查找用户角色
     * */
    UserRoleBase findUserRole(User user);

    /**
     * 更新用户状态
     * */
    void updateUserStatus(User user);


}
