package com.springcloud.springcloudeurekaapiinfo.controller;

import com.springcloud.springcloudeurekaapiinfo.dto.Student;
import com.springcloud.springcloudeurekaapiinfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController implements StudentControllerInterface {
    @Autowired
   private StudentService studentService;

    @PostMapping("/addStudent")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addStudent(@RequestBody Student student){
        System.out.println(student);
        studentService.addStudent(student);
        //System.out.println(1/0);
    }

    /**
     * 获取所有的学生信息
     * @return
     */
    @GetMapping("/getAllStudents")
    @Override
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

















}
