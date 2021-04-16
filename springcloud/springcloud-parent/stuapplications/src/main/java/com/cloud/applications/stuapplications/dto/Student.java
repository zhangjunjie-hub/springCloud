package com.cloud.applications.stuapplications.dto;


import com.alibaba.fastjson.JSONObject;
import com.cloud.applications.stuapplications.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import netscape.javascript.JSObject;


public class Student extends BaseDto {
     private String userName;
     private String password;
     private String realName;


     public Student() {
     }

     public Student(String userName, String password, String realName) {
          this.userName = userName;
          this.password = password;
          this.realName = realName;
     }

     public String getUserName() {
          return userName;
     }

     public void setUserName(String userName) {
          this.userName = userName;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getRealName() {
          return realName;
     }

     public void setRealName(String realName) {
          this.realName = realName;
     }

     @Override
     public String toString() {
          return JSONObject.toJSONString(new Student(this.userName,this.password,this.realName));
     }
}
