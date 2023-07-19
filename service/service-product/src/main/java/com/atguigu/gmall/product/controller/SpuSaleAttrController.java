package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product/")
public class SpuSaleAttrController {

    @Autowired
    private SpuSaleAttrService spuSaleAttrService;
    @GetMapping("/spuSaleAttrList/{spuId}")
    public Result<List<SpuSaleAttr>> findBySpuId(@PathVariable("spuId") Integer spuId){
        List<SpuSaleAttr> spuSaleAttrList = spuSaleAttrService.findBySpuId(spuId);

        return Result.build(spuSaleAttrList, ResultCodeEnum.SUCCESS);
    }
}
