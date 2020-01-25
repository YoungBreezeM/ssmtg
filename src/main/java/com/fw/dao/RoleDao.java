package com.fw.dao;

import com.fw.domain.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public interface RoleDao {
    /**
     * 查找所有
     * */
    @Select("select * from role")
    List<Role> findAll();

    /**
     * 通过角色名查找
     * */
    @Select("select * from role where roleName =#{roleName}")
    List<Role> findByRoleName(String roleName);
    /**
     * 通过id查找
     * */
    @Select("select * from role where rid=#{rid}")
    List<Role> findById(Integer rid);

    /**
     * 增加信息
     * */
    @Insert("insert into role (roleName,power,roleDescribe) values(#{roleName},#{power},#{roleDescribe})")
    void addRole(Role role);

    /**
     * 更新角色表信息
     * */
    @Update("update role set roleName = #{roleName},power = #{power},roleDescribe = #{roleDescribe} where rid = #{rid}")
    void updateRole(Role Role);

    /**
     * 删除角色信息
     * */
    @Delete("delete from role where rid =#{rid}")
    void deleteRole(Integer rid);


}
