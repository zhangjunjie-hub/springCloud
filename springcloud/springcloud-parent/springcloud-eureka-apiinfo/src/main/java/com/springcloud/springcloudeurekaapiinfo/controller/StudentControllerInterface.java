package com.springcloud.springcloudeurekaapiinfo.controller;

import com.springcloud.springcloudeurekaapiinfo.dto.Student;
import com.springcloud.springcloudeurekaapiinfo.dto.StudentWapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentControllerInterface {

   void addStudent(Student student);

   List<Student> getAllStudents();

   StudentWapper getUserInfoByUserName(@PathVariable String userName);

}
