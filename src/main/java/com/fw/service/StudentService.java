package com.fw.service;

import com.fw.domain.Student;

import java.util.List;

public interface StudentService {


     void updateStudent(Student student);
     /**
      * 转账
      * */
     boolean transfer(Student source,Student target,Double money);
     /**
      * 查找学生信息
      * */
     List<Student> findAllStudent();
}
