package com.atguigu.gmall.product.service;

import com.atguigu.gmall.product.entity.BaseCategory1;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author RAN
* @description 针对表【base_category1(一级分类表)】的数据库操作Service
* @createDate 2023-07-11 20:15:05
*/
public interface BaseCategory1Service extends IService<BaseCategory1> {


    List<BaseCategory1> findBaseCategory1();
}
