package com.springcloud.springcloudeurekaapiinfo.service;

import ch.qos.logback.classic.spi.STEUtil;
import com.alibaba.fastjson.JSONObject;
import com.springcloud.springcloudeurekaapiinfo.dto.Message;
import com.springcloud.springcloudeurekaapiinfo.dto.Student;
import com.springcloud.springcloudeurekaapiinfo.dto.StudentWapper;
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
    public static final String SINGLE_STUDENT_FLAG = "single_student_";

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
    public StudentWapper getUserInfoByUserName(String userName){
        StudentWapper wapper = new StudentWapper();
           if(StringUtils.isBlank(userName)){
               wapper.setMessage(new Message("400","用户名称为空，查询失败"));
           }else{
               //先从redis中获取对应的缓存信息
               String s = redisUtils.get(SINGLE_STUDENT_FLAG + userName);
               if(StringUtils.isNotBlank(s)){
                   Student student = JSONObject.parseObject(s,Student.class);
                   if(null != student){
                       wapper.setStudent(student);
                       wapper.setMessage(new Message("200","查询成功"));
                   }
               }else{
                   //如果缓存中不存在的情况下，则查询数据库数据，并将查询结果存入到redis中
                   Student student = studentMapper.getUserInfoByUserName(userName);
                   if(null != student){
                       wapper.setStudent(student);
                       wapper.setMessage(new Message("200","查询到对应的数据"));
                       redisUtils.set(SINGLE_STUDENT_FLAG + userName,JSONObject.toJSONString(student),0);
                   }else{
                       wapper.setMessage(new Message("200","查询数据为空"));
                   }


               }

           }



        return wapper;
    }










}
