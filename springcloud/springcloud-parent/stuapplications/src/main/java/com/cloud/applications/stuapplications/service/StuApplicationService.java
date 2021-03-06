package com.cloud.applications.stuapplications.service;

import com.cloud.applications.stuapplications.dao.StudentDao;
import com.cloud.applications.stuapplications.dto.Student;
import com.cloud.applications.stuapplications.dto.StudentWapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
@FeignClient(name = "spring-cloud-eureka-apiinfo" ,fallback = com.cloud.applications.stuapplications.service.StuApplicationFallBackService.class)
public interface StuApplicationService{

    /**
     * 添加信息
     * @param student
     */
    @PostMapping(value = "/student/addStudent")
    void addStudent(@RequestBody Student student);

    @GetMapping(value = "/student/getAllStudents")
    List<Student> getAllStudents();

    @GetMapping(value = "/student/getUserInfoByUserName/{userName}")
    StudentWapper getUserInfoByUserName(@PathVariable String userName);
}
