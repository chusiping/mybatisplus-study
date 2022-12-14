package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName T_GP_TradeHistory
 */
@TableName(value ="T_GP_TradeHistory")
@Data
public class Tradehistory implements Serializable {

    @TableId(value="id",type= IdType.AUTO)
    private Long id;

    private String code;

    private String name;

    private float guessprice;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateguess;

    private Date dateadd;

    private byte[] image;

    private static final long serialVersionUID = 1L;
}