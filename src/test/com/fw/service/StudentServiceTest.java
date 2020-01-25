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
    * 更新用户
    * */
   @Test
   public void updateStudent(){
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
       StudentService studentService= applicationContext.getBean("studentServiceImpl", StudentService.class);
       Student student = new Student(1,"uqf",1000.00);
       studentService.updateStudent(student);
   }

   /**
    * 转账
    * */
   @Test
    public void transfer(){
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
       StudentService studentService= applicationContext.getBean("studentServiceImpl", StudentService.class);
       Student source = new Student(1,"yqf",1000.00);
       Student target = new Student(2,"yqf",1000.00);
       Boolean rs= studentService.transfer(source,target,300.00);
       System.out.println(rs);
   }

}
