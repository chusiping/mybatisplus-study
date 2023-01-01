package com.atguigu.mybatisplus.controller;

import com.atguigu.mybatisplus.entity.JsonResult;
import com.atguigu.mybatisplus.entity.Stocklist;
import com.atguigu.mybatisplus.mapper.StocklistMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api
@RestController
@RequestMapping("/stock")
public class api_StockList {

    @Autowired
    private StocklistMapper stocklistMapper;
    @RequestMapping("/test")
    @ResponseBody
    @ApiOperation(value="接口是否可以调用测试")
    public JsonResult<Stocklist> test() {
        Stocklist sl = new Stocklist();
        sl.setCode("002467");
        sl.setName("二六三");
        return new JsonResult<>(sl);
    }

    @RequestMapping("/all")
    public JsonResult<List<Stocklist>> all() {
        try{
            List<Stocklist> list = stocklistMapper.selectList(null);
            return new JsonResult<>(list);
        }catch(Exception e){
            return new JsonResult<>("-1","操作失败！"+e.toString());
        }
    }

    @RequestMapping("/add")
    @ApiOperation(value="添加Stocklist对象到记录")
    public JsonResult<Stocklist> add(@ApiParam(name="Stocklist",value="添加对象Stocklist",required=true) @RequestBody Stocklist sl_) {
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
