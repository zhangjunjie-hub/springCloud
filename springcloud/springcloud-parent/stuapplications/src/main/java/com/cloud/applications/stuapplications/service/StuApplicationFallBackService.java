package com.cloud.applications.stuapplications.service;

import com.cloud.applications.stuapplications.dto.Student;
import com.cloud.applications.stuapplications.dto.StudentWapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StuApplicationFallBackService implements StuApplicationService {
    @Override
    public void addStudent(Student student) {
        System.out.println("addStudent服务挂掉了，进入熔断器方法……");
    }

    @Override
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents服务挂掉了，进入熔断器方法……");
        return null;
    }

    @Override
    public StudentWapper getUserInfoByUserName(String userName) {
        System.out.println("getUserInfoByUserName服务挂掉了，进入熔断器方法……");
        return null;
    }
}
