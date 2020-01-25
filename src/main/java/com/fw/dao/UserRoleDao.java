package com.fw.dao;

import com.fw.domain.UserRoleBase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRoleDao")
public interface UserRoleDao {

    /**
     * 用户插入角色
     * */
    @Insert("insert into user_role (uid,rid) values(#{uid},#{rid})")
    void addUserRole(UserRoleBase userRoleBase);

    /**
     * 查询用户角色
     * */
    @Select("select * from user_role where uid=#{uid}")
    List<UserRoleBase> findUserRoleByUid(Integer uid);

    /**
     * 更新用户角色
     * */
    @Update("update user_role set rid=#{rid} where uid=#{uid}")
    void updateUserRole(UserRoleBase userRoleBase);


}
