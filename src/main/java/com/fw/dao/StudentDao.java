package com.fw.dao;

import com.fw.domain.Student;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "studentDao")
public interface StudentDao {
    /**
     * 更新学生信息
     */
    @Update("update student s,student1 s1 set s.name=#{name},s1.name=#{name},s.money=#{money},s1.money=#{money} where s.id = #{id} and s1.id=#{id}")
    void updateStudent(Student student);



    /**
     * 查询学生信息
     */
    @Select("Select * from student")
    List<Student> findAllStudent();
}
