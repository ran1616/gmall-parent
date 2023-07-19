package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.product.entity.BaseCategory1;
import com.atguigu.gmall.product.vo.CategoryView;
import com.atguigu.gmall.product.vo.CategoryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author RAN
* @description 针对表【base_category1(一级分类表)】的数据库操作Mapper
* @createDate 2023-07-11 20:15:05
* @Entity com.atguigu.gmall.product.entity.BaseCategory1
*/
public interface BaseCategory1Mapper extends BaseMapper<BaseCategory1> {

    List<CategoryVo> findAllCategoryTree();

    CategoryView findCategoryViewBySkuId(Long skuId);
}




