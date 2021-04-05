package com.cloud.applications.stuapplications.dao;

import com.cloud.applications.stuapplications.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Component
//@FeignClient(value = "spring-cloud-eureka-apiinfo")
public interface StudentDao {

   /**
    * 添加信息
    * @param student
    */
//   @PostMapping(value = "/student/addStudent")
//   void addStudent(@RequestBody Student student);
//
//   @GetMapping(value = "/student/getAllStudents")
//   List<Student> getAllStudents();

}
