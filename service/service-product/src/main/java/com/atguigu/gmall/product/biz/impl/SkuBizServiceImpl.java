package com.atguigu.gmall.product.biz.impl;

import com.atguigu.gmall.product.biz.SkuBizService;
import com.atguigu.gmall.product.entity.SkuInfo;
import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.atguigu.gmall.product.mapper.BaseCategory1Mapper;
import com.atguigu.gmall.product.mapper.SkuInfoMapper;
import com.atguigu.gmall.product.mapper.SpuSaleAttrMapper;
import com.atguigu.gmall.product.vo.CategoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuBizServiceImpl implements SkuBizService {

    @Autowired
    private BaseCategory1Mapper baseCategory1Mapper ;

    @Autowired
    private SkuInfoMapper skuInfoMapper ;

    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper ;

    @Override
    public CategoryView findCategoryViewBySkuId(Long skuId) {
        return baseCategory1Mapper.findCategoryViewBySkuId(skuId);
    }

    @Override
    public SkuInfo findSkuInfoAndImageBySkuId(Long skuId) {
        return skuInfoMapper.findSkuInfoAndImageBySkuId(skuId);
    }

    @Override
    public SkuInfo findSkuInfoBySkuId(Long skuId) {
        return skuInfoMapper.selectById(skuId);
    }

    @Override
    public List<SpuSaleAttr> findSpuSalAttrBySkuId(Long skuId) {
        return spuSaleAttrMapper.findSpuSalAttrBySkuId(skuId);
    }

}
