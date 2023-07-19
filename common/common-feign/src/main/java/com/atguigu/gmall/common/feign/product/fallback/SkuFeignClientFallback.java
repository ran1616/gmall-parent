package com.atguigu.gmall.common.feign.product.fallback;

import com.atguigu.gmall.common.feign.product.SkuFeignClient;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.entity.SkuInfo;
import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.atguigu.gmall.product.vo.CategoryView;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SkuFeignClientFallback implements SkuFeignClient {

    @Override
    public Result<CategoryView> findCategoryViewBySkuId(Long skuId) {
        log.info("SkuFeignClientFallback...findCategoryViewBySkuId方法执行了...");
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @Override
    public Result<SkuInfo> findSkuInfoAndImageBySkuId(Long skuId) {
        log.info("SkuFeignClientFallback...findSkuInfoAndImageBySkuId方法执行了...");
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @Override
    public Result<SkuInfo> findSkuInfoBySkuId(Long skuId) {
        log.info("SkuFeignClientFallback...findSkuInfoBySkuId方法执行了...");
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @Override
    public Result<List<SpuSaleAttr>> findSpuSalAttrBySkuId(Long skuId) {
        log.info("SkuFeignClientFallback...findSpuSalAttrBySkuId方法执行了...");
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}
