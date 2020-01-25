package com.fw.dao;

import com.fw.domain.Space;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("spaceDao")
public interface SpaceDao {
    /**
     * 查找所有
     * */
    @Select("select * from space")
    List<Space> findAll();

    /**
     * 查找所有系统可用空间
     * */
    @Select("select * from system_space")
    List<Space> findAllSpace();

    /**
     * 通过空间名查找
     * */
    @Select("select * from space where spaceName =#{spaceName}")
    List<Space> findBySpaceName(String spaceName);
    /**
     * 通过id查找
     * */
    @Select("select * from space where sid=#{sid}")
    List<Space> findById(Integer sid);

    /**
     * 通过spaceName 查找系统全部space
     * */
    @Select("select * from system_space where spaceName=#{spaceName}")
    List<Space> findAllBySpaceName(String spaceName);

    /**
     * 增加信息
     * */
    @Insert("insert into space (spaceName,path,hasSelect,hasUpdate,hasInsert,hasDelete) values(#{spaceName},#{path},#{hasSelect},#{hasUpdate},#{hasInsert},#{hasDelete})")
    void addSpace(Space space);

    /**
     * 更新信息
     * */
    @Update("update space set spaceName = #{spaceName},path = #{path},hasSelect = #{hasSelect},hasUpdate = #{hasUpdate},hasInsert = #{hasInsert},hasDelete = #{hasDelete} where sid = #{sid}")
    void updateSpace(Space space);

    /**
     * 删除信息
     * */
    @Delete("delete from space where sid =#{sid}")
    void deleteSpace(Integer sid);
}
