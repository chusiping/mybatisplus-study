package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName T_GP_StockList
 */
@TableName(value ="T_GP_StockList")
@Data
public class Stocklist implements Serializable {
    private String code;

    private String name;

    private Date dateadd;

    private static final long serialVersionUID = 1L;
}