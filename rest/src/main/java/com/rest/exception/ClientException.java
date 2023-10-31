package com.rest.exception;

import org.springframework.http.HttpStatusCode;

public class ClientException  {

    private Integer messageCode;
    private String message;


    public ClientException(Integer messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;
    }

    public Integer getMessageCode() {
        return messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessageCode(Integer messageCode) {
        this.messageCode = messageCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
