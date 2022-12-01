package com.atguigu.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisplus.entity.Stocklist;
import com.atguigu.mybatisplus.service.StocklistService;
import com.atguigu.mybatisplus.mapper.StocklistMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【T_GP_StockList】的数据库操作Service实现
* @createDate 2022-11-30 17:43:33
*/
@Service
public class StocklistServiceImpl extends ServiceImpl<StocklistMapper, Stocklist>
    implements StocklistService{

}




