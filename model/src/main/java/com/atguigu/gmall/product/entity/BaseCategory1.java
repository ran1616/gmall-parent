package com.atguigu.gmall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 一级分类表
 * @TableName base_category1
 */
@TableName(value ="base_category1")
@Data
public class BaseCategory1 {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    private String name ;

}