package com.fw.dao;

import com.fw.domain.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表的操作
 * */
@Repository("userDao")
public interface UserDao {
    /**
     * 查找所有信息
     * */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 通过id查找用户
     * */
    @Select("select * from user where uid=#{uid}")
    List<User> findById(Integer uid);

    /**
     * 添加用户
     * */
    @Insert("insert into user (userName,password,email,phone,realName) values(#{userName},#{password},#{email},#{phone},#{realName})")
    void addUser(User user);

    /**
     * 删除用户
     * */
    @Delete("delete from user where uid =#{uid}")
    void deleteUser(Integer uid);

    /**
     * 修改用户
     * */
    @Update("update user set userName = #{userName},password = #{password},email = #{email},phone = #{phone},realName = #{realName} where uid = #{uid}")
    void updateUser(User user);


    /**
     * 用过用户名查找
     * */
    @Select("select * from user where userName=#{userName}")
    List<User> findAllByName(String userName);


    @Select("select * from user where userName=#{userName} and password=#{password}")
    List<User> findByNameAndPassword(User user);

    /**
     * 更新用户状态
     * */
    @Update("update user set status=#{status} where uid = #{uid}")
    void  updateUserStatus(User user);

}
