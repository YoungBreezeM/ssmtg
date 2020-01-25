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
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }


    @Override
    public boolean transfer(Student source, Student target, Double money) {
        source.setMoney(source.getMoney()-money);
        //更新发送方
        studentDao.updateStudent(source);
        List<Student> students = this.findAllStudent();
        System.out.println(students);
//        int i =1/0;
        //更新接受方
        target.setMoney(target.getMoney()+money);
        studentDao.updateStudent(target);
        return true;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentDao.findAllStudent();
    }


}
