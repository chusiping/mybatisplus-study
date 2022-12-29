package com.atguigu.mybatisplus.mapper;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatisplus.entity.Tradehistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【T_GP_TradeHistory】的数据库操作Mapper
* @createDate 2022-12-02 15:08:42
* @Entity com.atguigu.mybatisplus.entity.Tradehistory
*/
public interface TradehistoryMapper extends BaseMapper<Tradehistory> {
    int deleteByCode(@Param("code") String code);

}




