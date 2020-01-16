package com.fw.service;

import com.fw.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class StudentServiceTest {
//    @Autowired
//    private ApplicationContext applicationContext =null;

    /**
     * 查找所有用户
     * */
    @Test
    public void testFindAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        StudentService studentService= applicationContext.getBean("studentServiceImpl", StudentService.class);
        List<Student> students = studentService.findAll() ;
        for(Student student:students){
            System.out.println(student);
        }

    }
}
