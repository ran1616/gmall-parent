package com.atguigu.gmall.common.feign.product;

import com.atguigu.gmall.common.feign.product.fallback.SkuFeignClientFallback;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.entity.SkuInfo;
import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.atguigu.gmall.product.vo.CategoryView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "service-product" , fallback = SkuFeignClientFallback.class)
public interface SkuFeignClient {

    @GetMapping(value = "/api/inner/product/findCategoryViewBySkuId/{skuId}")
    public abstract Result<CategoryView> findCategoryViewBySkuId(@PathVariable(value = "skuId")Long skuId) ;

    @GetMapping(value = "/api/inner/product/findSkuInfoAndImageBySkuId/{skuId}")
    public abstract Result<SkuInfo> findSkuInfoAndImageBySkuId(@PathVariable(value = "skuId")Long skuId) ;

    @GetMapping(value = "/api/inner/product/findSkuInfoBySkuId/{skuId}")
    public abstract Result<SkuInfo> findSkuInfoBySkuId(@PathVariable(value = "skuId")Long skuId) ;

    @GetMapping(value = "/api/inner/product/findSpuSalAttrBySkuId/{skuId}")
    public abstract Result<List<SpuSaleAttr>> findSpuSalAttrBySkuId(@PathVariable(value = "skuId")Long skuId) ;

}
