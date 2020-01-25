package com.fw.dao;

import com.fw.domain.RoleSpaceBase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleSpaceDao")
public interface RoleSpaceDao {
    /**
     * 查找更新的角色权限对象是否存在
     * */
    @Select("select * from role_space where rid=#{rid} and sid=#{sid}")
    List<RoleSpaceBase> findRoleSpaceById(RoleSpaceBase roleSpaceBase);

    /**
     * 插入角色的权限
     * */
    @Insert("insert into role_space (rid,sid,hasSelect,hasUpdate,hasInsert,hasDelete) values(#{rid},#{sid},#{hasSelect},#{hasUpdate},#{hasInsert},#{hasDelete})")
    void addRoleSpace(RoleSpaceBase roleSpaceBase);

    /**
     * 获取角色权限列表
     * */
    @Select("select * from role_space where rid =#{rid}")
    List<RoleSpaceBase> findAllRoleSpace(Integer rid);

    /**
     * 更角色权限列表
     * **/
    @Update("update role_space set hasSelect=#{hasSelect},hasUpdate=#{hasUpdate},hasInsert=#{hasInsert},hasDelete=#{hasDelete} where rid=#{rid} and sid=#{sid}")
    void updateRoleSpace(RoleSpaceBase roleSpaceBase);

}
