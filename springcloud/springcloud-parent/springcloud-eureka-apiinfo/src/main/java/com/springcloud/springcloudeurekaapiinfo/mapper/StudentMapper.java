package com.springcloud.springcloudeurekaapiinfo.mapper;

import com.springcloud.springcloudeurekaapiinfo.dto.Student;
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
}
