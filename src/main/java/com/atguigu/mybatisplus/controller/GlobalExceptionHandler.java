package com.atguigu.mybatisplus.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> exceptionHandler(Exception e) {
        log.info("捕获全局异常：" + e.getMessage());
        log.info(e.toString());
        Map<String, Object> res = new HashMap<>();
        res.put("code", -10);
        res.put("msg", "操作失败! " + e.getMessage());
        //res.put("cause",e.getCause().toString());
        //res.put("stackTrace[0]",e.getStackTrace()[0]);
        return res;
    }
}
