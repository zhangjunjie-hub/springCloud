package com.springcloud.springcloudeurekaapiinfo.service;

import com.springcloud.springcloudeurekaapiinfo.dto.Student;
import com.springcloud.springcloudeurekaapiinfo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 添加学生信息
     * @param student
     */
    public void addStudent(Student student){
        studentMapper.insertStudent(student);
    }


    public List<Student> getAllStudents() {

        return studentMapper.getAllStudents();
    }
}
