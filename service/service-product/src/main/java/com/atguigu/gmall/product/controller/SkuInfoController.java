package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.dto.SkuInfoDto;
import com.atguigu.gmall.product.dto.SkuInfoDto;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product")
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;
    @GetMapping("/list/{page}/{limit}")
    public Result<Page> pageSkuInfo(@PathVariable("page") Integer pageNO ,
                                    @PathVariable("limit") Integer limit){

        Page skuInfoPage = skuInfoService.findSkuInfoPage(pageNO,limit);
        return Result.build(skuInfoPage, ResultCodeEnum.SUCCESS);
    }

    @PostMapping(value = "/saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfoDto skuInfoDto) {
        skuInfoService.saveSkuInfo(skuInfoDto) ;
        return Result.ok() ;
    }

    @GetMapping(value = "/onSale/{skuId}")
    public Result onSale(@PathVariable(value = "skuId") Long skuId) {
        skuInfoService.onSale(skuId) ;
        return Result.ok() ;
    }

    @GetMapping(value = "/cancelSale/{skuId}")
    public Result cancelSale(@PathVariable(value = "skuId") Long skuId) {
        skuInfoService.cancelSale(skuId) ;
        return Result.ok() ;
    }
}
