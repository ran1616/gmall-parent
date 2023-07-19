package com.atguigu.gmall.product.biz.impl;

import com.atguigu.gmall.product.biz.BaseCategoryBizService;
import com.atguigu.gmall.product.mapper.BaseCategory1Mapper;
import com.atguigu.gmall.product.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseCategoryBizServiceImpl implements BaseCategoryBizService {

    @Autowired
    private BaseCategory1Mapper baseCategory1Mapper ;

    @Override
    public List<CategoryVo> findAllCategoryTree() {
        return baseCategory1Mapper.findAllCategoryTree();
    }
}
