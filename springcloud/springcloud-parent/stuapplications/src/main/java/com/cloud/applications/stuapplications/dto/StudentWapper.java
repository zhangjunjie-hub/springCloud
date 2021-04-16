package com.cloud.applications.stuapplications.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * @author  zhangjunjie
 * 这个是用来封装用户相关的信息以及
 * 一些提示信息
 */
public class StudentWapper {
    private Message message;
    private Student student;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentWapper() {
    }

    public StudentWapper(Message message, Student student) {
        this.message = message;
        this.student = student;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(new StudentWapper(this.message,this.student));
    }
}
