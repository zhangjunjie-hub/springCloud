package com.cloud.applications.stuapplications.dto;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangjunjie
 * 这个是所有类的消息提示
 */
public class Message {
  private String messageCode;
  private String messageInfo;

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public Message() {
    }

    public Message(String messageCode, String messageInfo) {
        this.messageCode = messageCode;
        this.messageInfo = messageInfo;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(new Message(this.messageCode,this.messageInfo));
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }
}


