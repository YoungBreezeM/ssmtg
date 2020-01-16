package com.fw.service.impl;

import com.fw.dao.StudentDao;
import com.fw.domain.Student;
import com.fw.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Resource(name = "studentDao")
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        System.out.println("查找了信息");
        return studentDao.findAll();
    }

    @Override
    public void saveInfo(Student student) {
        System.out.println("保存了信息");
        studentDao.saveInfo(student);
    }
}
