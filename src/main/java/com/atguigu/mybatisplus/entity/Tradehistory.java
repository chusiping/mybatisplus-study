package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName T_GP_TradeHistory
 */
@TableName(value ="T_GP_TradeHistory")
@Data
public class Tradehistory implements Serializable {
    private Long id;

    private String code;

    private String name;

    private Integer guessprice;

    private String content;

    private Date dateguess;

    private Date dateadd;

    private byte[] image;

    private static final long serialVersionUID = 1L;
}