package com.fw.service;

import com.fw.domain.Student;

import java.util.List;

public interface StudentService {

    /**
     *查找所有学生信息
     * */
    List<Student> findAll();

    /**
     * 保存学生信息
     * */
    void saveInfo(Student student);
}
