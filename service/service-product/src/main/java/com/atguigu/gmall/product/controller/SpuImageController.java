package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.entity.SpuImage;
import com.atguigu.gmall.product.service.SpuImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/admin/product")
public class SpuImageController {

    @Autowired
    private SpuImageService spuImageService;

    @GetMapping("/spuImageList/{spuId}")
    public Result<List<SpuImage>> findAll(@PathVariable("spuId") Integer spuId){

        List<SpuImage> spuImageList = spuImageService.findAll(spuId);
        return Result.build(spuImageList, ResultCodeEnum.SUCCESS);
    }
}
