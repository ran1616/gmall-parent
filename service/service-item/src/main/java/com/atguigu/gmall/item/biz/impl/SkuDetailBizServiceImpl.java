package com.atguigu.gmall.item.biz.impl;

import com.atguigu.gmall.common.feign.product.SkuFeignClient;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.item.biz.SkuDetailBizService;
import com.atguigu.gmall.product.entity.SkuInfo;
import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.atguigu.gmall.product.vo.CategoryView;
import com.atguigu.gmall.product.vo.SkuDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class SkuDetailBizServiceImpl implements SkuDetailBizService {

    @Autowired
    private SkuFeignClient skuFeignClient ;

    @Override
    public SkuDetailVo item(Long skuId) {
        log.info("SkuDetailBizServiceImpl...item方法执行了...");

        // TODO 远程调用service-product微服务的接口，根据skuId查询相关数据
        // 根据skuId查询三级分类数据
        Result<CategoryView> viewResult = skuFeignClient.findCategoryViewBySkuId(skuId);
        CategoryView categoryView = viewResult.getData();

        // 根据skuId查询sku的基本信息和图片信息
        Result<SkuInfo> skuInfoAndImageResult = skuFeignClient.findSkuInfoAndImageBySkuId(skuId);
        SkuInfo skuInfoAndImage = skuInfoAndImageResult.getData();

        // 根据skuId查询价格数据
        Result<SkuInfo> skuInfoResult = skuFeignClient.findSkuInfoBySkuId(skuId);
        BigDecimal price = skuInfoResult.getData().getPrice();

        // 根据skuId查询其所对应的spu的销售属性和销售属性值
        Result<List<SpuSaleAttr>> spuSalAttrResult = skuFeignClient.findSpuSalAttrBySkuId(skuId);
        List<SpuSaleAttr> spuSaleAttrList = spuSalAttrResult.getData();

        // 创建skuDetailVo对象，封装查询结果数据
        SkuDetailVo skuDetailVo = new SkuDetailVo() ;
        skuDetailVo.setCategoryView(categoryView);
        skuDetailVo.setSkuInfo(skuInfoAndImage);
        skuDetailVo.setPrice(price);
        skuDetailVo.setSpuSaleAttrList(spuSaleAttrList);

        // 返回
        return skuDetailVo;
    }

}
