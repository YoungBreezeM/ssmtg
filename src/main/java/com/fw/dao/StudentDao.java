package com.fw.dao;

import com.fw.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "studentDao")
public interface StudentDao {
    /**
     *查找所有学生信息
     * */
     @Select("select * from student")
     List<Student> findAll();

     /**
      * 保存学生信息
      * */
     @Insert("insert into student (name,age) values(#{name},#{age})")
     void saveInfo(Student student);
}
