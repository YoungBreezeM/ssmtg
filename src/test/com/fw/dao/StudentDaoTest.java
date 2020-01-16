package com.fw.dao;

import com.fw.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDaoTest {
    @Test
    public void findAllTest() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        /**
         * 数据源注入代理工场
         * 创建sqlSessionFactory代理工厂
         * */
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取代理对象
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //获取所有信息
        List<Student> students = studentDao.findAll();
        for (Student student:students){
            System.out.println(student);
        }
        //关闭资源
        sqlSession.close();
        in.close();

    }
    @Test
    public void saveInfoTest() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        /**
         * 数据源注入代理工场
         * 创建sqlSessionFactory代理工厂
         * */
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取代理对象
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //获取所有信息
        Student student = new Student();
        student.setName("yqf");
        student.setAge(18);
        studentDao.saveInfo(student);
        //提交事物
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        in.close();

    }
}
