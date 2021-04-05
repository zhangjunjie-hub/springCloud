package com.springcloud.springcloudeurekaapiinfo.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
}
