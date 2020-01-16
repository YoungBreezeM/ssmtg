package com.fw.Controller;

import com.fw.domain.Student;
import com.fw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    /**
     * 测试方法
     * */
    @GetMapping
    public ModelAndView findAll(){
        List<Student> students =studentService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("students",students);
        mv.setViewName("success");
        return mv;
    }

    @PostMapping
    public String addStudent(Student student){
        studentService.saveInfo(student);
        return "redirect:/student";
    }
}
