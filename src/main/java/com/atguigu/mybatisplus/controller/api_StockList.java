package com.atguigu.mybatisplus.controller;

import com.atguigu.mybatisplus.entity.JsonResult;
import com.atguigu.mybatisplus.entity.Stocklist;
import com.atguigu.mybatisplus.mapper.StocklistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stock")
public class api_StockList {

    @Autowired
    private StocklistMapper stocklistMapper;
    @RequestMapping("/test")
    @ResponseBody
    public JsonResult<Stocklist> test() {
        Stocklist sl = new Stocklist();
        sl.setCode("002467");
        sl.setName("二六三");
        return new JsonResult<>(sl);
    }

    @RequestMapping("/add")
    public JsonResult<Stocklist> add(@RequestBody Stocklist sl_) {
        try{
            int rt = stocklistMapper.insert(sl_);
            if(rt == 0 )
                return new JsonResult<>("-1","操作失败！");
            else
                return new JsonResult<>(sl_);
        }catch(Exception e){
            return new JsonResult<>("-1","操作失败！"+e.toString());
        }
    }

    @RequestMapping("/del")
    public JsonResult<Stocklist> del(@RequestBody Stocklist sl_) {
        Map<String,Object> map = new HashMap<>();
        map.put("code",sl_.getCode());
        int rt = stocklistMapper.deleteByMap(map);
        if(rt == 0 )
            return new JsonResult<>("-1","操作失败！");
        else
            return new JsonResult<>(sl_);
    }
}
