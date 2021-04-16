package com.cloud.applications.stuapplications.controller;


import com.cloud.applications.stuapplications.dto.Student;
import com.cloud.applications.stuapplications.dto.StudentWapper;
import com.cloud.applications.stuapplications.service.StuApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentApp")
public class StuApplicationController {

    @Autowired
    private StuApplicationService stuApplicationService;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        stuApplicationService.addStudent(student);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        List<Student> list = stuApplicationService.getAllStudents();
        return list;
    }
    @GetMapping("/getUserInfoByUserName/{userName}")
    public StudentWapper getUserInfoByUserName(@PathVariable String userName){
        return stuApplicationService.getUserInfoByUserName(userName);
    };



}
