package com.springcloud.springcloudeurekaapiinfo.controller;

import com.springcloud.springcloudeurekaapiinfo.dto.Student;

import java.util.List;

public interface StudentControllerInterface {

   void addStudent(Student student);

   List<Student> getAllStudents();

}
