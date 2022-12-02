package com.atguigu.mybatisplus.controller;
import java.util.HashMap;
import java.util.Map;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    public CustomException(String message) {
        this.message = message;
    }

    public CustomException(Integer code) {
        this.code = code;
    }

    public CustomException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public CustomException(Integer code, String message, Throwable e) {
        this.code = code;
        this.message = message;
        this.code = code;
    }

    public CustomException(Integer code,String message) {
        Map<String,Object> res = new HashMap<>();
        this.code = code;
        this.message = message;
    }


    public CustomException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}