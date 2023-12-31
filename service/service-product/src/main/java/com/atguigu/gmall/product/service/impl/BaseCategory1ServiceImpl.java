package com.atguigu.gmall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.entity.BaseCategory1;
import com.atguigu.gmall.product.service.BaseCategory1Service;
import com.atguigu.gmall.product.mapper.BaseCategory1Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author RAN
* @description 针对表【base_category1(一级分类表)】的数据库操作Service实现
* @createDate 2023-07-11 20:15:05
*/
@Service
public class BaseCategory1ServiceImpl extends ServiceImpl<BaseCategory1Mapper, BaseCategory1>
    implements BaseCategory1Service{

    @Override
    public List<BaseCategory1> findBaseCategory1() {
        return this.list();
    }
}




