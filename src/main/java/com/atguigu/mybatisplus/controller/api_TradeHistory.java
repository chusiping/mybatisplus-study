package com.atguigu.mybatisplus.controller;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.atguigu.mybatisplus.entity.JsonResult;
import com.atguigu.mybatisplus.entity.Stocklist;
import com.atguigu.mybatisplus.entity.Tradehistory;
import com.atguigu.mybatisplus.mapper.TradehistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/trade")
public class api_TradeHistory {
    @Autowired
    private TradehistoryMapper tradehistoryMapper;
    //============上传文件二进制入表================
    @RequestMapping(value = "/up3", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Tradehistory> up3(@RequestParam(name = "multipartFile") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        Tradehistory th = new Tradehistory();
        th.setCode("601066");
        th.setName("中心建构");
        th.setContent("ceshi ");
        th.setImage(bytes);
        int rt = tradehistoryMapper.insert(th);
        return new JsonResult<>(th);
    }

    //股票历史预测 - 插入
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Tradehistory> add(@RequestParam(name = "image") MultipartFile file,
                                        String code, String name, String content,
                                        float guessPrice , String guessDate  )
            throws IOException {
        byte[] Image_ = file.getBytes();
        Tradehistory th = new Tradehistory();
        th.setCode(code);
        th.setName(name);
        th.setGuessprice(guessPrice);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        try {
            th.setDateguess(format1.parse(guessDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        th.setContent(content);
        th.setImage(Image_);
        int rt = tradehistoryMapper.insert(th);
        return new JsonResult<>(th);
    }
    //股票历史预测 - 插入
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Tradehistory> edit(@RequestParam(name = "image") MultipartFile file,
                                        Long ID,String code, String name, String content,
                                         float guessPrice , String guessDate  )
            throws IOException {
        byte[] Image_ = file.getBytes();
        Tradehistory th = new Tradehistory();
        th.setId(ID);
        th.setCode(code);
        th.setName(name);
        th.setGuessprice(guessPrice);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            th.setDateguess(format1.parse(guessDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        th.setContent(content);
        th.setImage(Image_);
        int rt = tradehistoryMapper.updateById(th);
        return new JsonResult<>(th);
    }
    //股票历史预测 - 插入
    @RequestMapping(value = "/del")
    @ResponseBody
    public JsonResult<Tradehistory> del(Long ID)
            throws IOException {
        Tradehistory th = new Tradehistory();
        th.setId(ID);
        int rt = tradehistoryMapper.deleteById(ID);
        return new JsonResult<>(th);
    }
}
