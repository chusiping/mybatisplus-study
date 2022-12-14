package com.atguigu.mybatisplus.controller;
import java.io.IOException;
import java.util.Date;

import com.atguigu.mybatisplus.entity.JsonResult;
import com.atguigu.mybatisplus.entity.Tradehistory;
import com.atguigu.mybatisplus.mapper.TradehistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/trade")
public class api_TradeHistory {
    @Autowired
    private TradehistoryMapper tradehistoryMapper;
    //============ 测试方法 上传文件 ================
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Tradehistory> test(@RequestParam(name = "multipartFile") MultipartFile file) throws IOException {
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
                                        float guessPrice , @DateTimeFormat(pattern = "yyyy-MM-dd") Date guessDate  )
            throws IOException {
        byte[] Image_ = file.getBytes();
        Tradehistory th = new Tradehistory();
        th.setCode(code);
        th.setName(name);
        th.setGuessprice(guessPrice);
        th.setDateguess(guessDate);
        th.setContent(content);
        th.setImage(Image_);
        int rt = tradehistoryMapper.insert(th);
        return new JsonResult<>(th);
    }
    //股票历史预测 - 修改
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Tradehistory> edit(@RequestParam(name = "image") MultipartFile file,
                                        Long ID,String code, String name, String content,
                                         float guessPrice , @DateTimeFormat(pattern = "yyyy-MM-dd") Date guessDate  )
            throws IOException {
        byte[] Image_ = file.getBytes();
        Tradehistory th = new Tradehistory();
        th.setId(ID);
        th.setCode(code);
        th.setName(name);
        th.setGuessprice(guessPrice);
        th.setDateguess(guessDate);
        th.setContent(content);
        th.setImage(Image_);
        int rt = tradehistoryMapper.updateById(th);
        return new JsonResult<>(th);
    }
    //股票历史预测 - 删除
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
