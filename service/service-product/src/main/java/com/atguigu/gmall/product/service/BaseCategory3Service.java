package com.atguigu.gmall.product.service;

import com.atguigu.gmall.product.entity.BaseCategory3;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author RAN
* @description 针对表【base_category3(三级分类表)】的数据库操作Service
* @createDate 2023-07-11 20:15:05
*/
public interface BaseCategory3Service extends IService<BaseCategory3> {

    List<BaseCategory3> findBaseCategory3ByC2Id(Long c2Id);
}
