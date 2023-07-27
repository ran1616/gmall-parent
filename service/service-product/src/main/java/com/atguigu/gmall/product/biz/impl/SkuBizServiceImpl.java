package com.atguigu.gmall.product.biz.impl;

import com.atguigu.gmall.product.biz.SkuBizService;
import com.atguigu.gmall.product.entity.SkuInfo;
import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.atguigu.gmall.product.mapper.BaseCategory1Mapper;
import com.atguigu.gmall.product.mapper.SkuInfoMapper;
import com.atguigu.gmall.product.mapper.SkuSaleAttrValueMapper;
import com.atguigu.gmall.product.mapper.SpuSaleAttrMapper;
import com.atguigu.gmall.product.vo.AttrValueConcatVo;
import com.atguigu.gmall.product.vo.CategoryView;
import com.atguigu.gmall.product.vo.SkuDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkuBizServiceImpl implements SkuBizService {

    @Autowired
    private BaseCategory1Mapper baseCategory1Mapper ;

    @Autowired
    private SkuInfoMapper skuInfoMapper ;

    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper ;

    @Autowired
    private SkuSaleAttrValueMapper skuSaleAttrValueMapper;

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

    @Override
    public List<AttrValueConcatVo> findSkuAttrValueConcatBySkuId(Long skuId) {
        return skuSaleAttrValueMapper.findSkuAttrValueConcatBySkuId(skuId);
    }

    @Override
    public SkuDetailVo findSkuDetailVo(Long skuId) {

        CategoryView categoryView = this.findCategoryViewBySkuId(skuId);
        SkuInfo skuInfoAndImage = findSkuInfoAndImageBySkuId(skuId);
        SkuInfo skuInfo = findSkuInfoBySkuId(skuId);
        List<SpuSaleAttr> spuSaleAttrList = findSpuSalAttrBySkuId(skuId) ;
        List<AttrValueConcatVo> attrValueConcatVos= findSkuAttrValueConcatBySkuId(skuId) ;

        SkuDetailVo skuDetailVo = new SkuDetailVo() ;
        skuDetailVo.setCategoryView(categoryView);
        skuDetailVo.setSkuInfo(skuInfoAndImage);
        skuDetailVo.setPrice(skuInfo.getPrice());
        skuDetailVo.setSpuSaleAttrList(spuSaleAttrList);
        skuDetailVo.setValuesSkuJson("");

        return skuDetailVo;
    }

    @Override
    public List<Long> findAllSkuIds() {
        List<SkuInfo> skuInfoList = skuInfoMapper.selectList(null);
        List<Long> list = skuInfoList.stream().map(skuInfo -> skuInfo.getId()).collect(Collectors.toList());
        return list;
    }

}
