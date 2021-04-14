package com.springcloud.springcloudeurekaapiinfo.service;

import com.alibaba.fastjson.JSONObject;
import com.springcloud.springcloudeurekaapiinfo.dto.Student;
import com.springcloud.springcloudeurekaapiinfo.mapper.StudentMapper;
import com.springcloud.springcloudeurekaapiinfo.utils.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 添加学生信息
     * @param student
     */
    public void addStudent(Student student){
        studentMapper.insertStudent(student);
    }


    /**
     * 获取所有的用户信息
     * @return
     */
    public List<Student> getAllStudents() {
        List<Student> allStudents = null ;
        //这里先从redis缓存中获取，
        String allStudentsStr = redisUtils.get("all_students");
        if(StringUtils.isBlank(allStudentsStr)){
            //如果缓存为空，则进行数据库查询，并将查询到的数据存入到redis中
            allStudents = studentMapper.getAllStudents();
            redisUtils.set("all_students", JSONObject.toJSONString(allStudents),0);
        }else{
            //如果查询到的数据是存在的，则将数据转化为list
            allStudents = JSONObject.parseArray(allStudentsStr, Student.class);
        }
        return allStudents;
    }

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    public Student getStudengByUserName(String userName){
           if(StringUtils.isBlank(userName)){
               return null;
           }else{


           }



        return null;
    }










}
