package com.springcloud.springcloudeurekaapiinfo.mapper;

import com.springcloud.springcloudeurekaapiinfo.dto.Student;
import com.springcloud.springcloudeurekaapiinfo.dto.StudentWapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentMapper {

    /**
     * 新增学生信息
     * @param student
     */
     void insertStudent(Student student);

    /**
     * 获取所有的学生信息
     * @return
     */
    List<Student> getAllStudents();

    /**
     * 根据用户名查询对应的用户信息
     * @param userName
     */
    Student getUserInfoByUserName(String userName);
}
