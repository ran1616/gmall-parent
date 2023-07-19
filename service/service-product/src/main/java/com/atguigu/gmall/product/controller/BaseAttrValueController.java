package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.entity.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product/")
public class BaseAttrValueController {

    @Autowired
    private BaseAttrValueService baseAttrValueService;


    @GetMapping("/getAttrValueList/{attrId}")
    public Result<List<BaseAttrValue>> findBaseAttrValueByAttrId(@PathVariable("attrId") Long attrId) {
        List<BaseAttrValue> baseAttrValueList = baseAttrValueService.findBaseAttrValueByAttrId(attrId);
        return Result.build(baseAttrValueList, ResultCodeEnum.SUCCESS);
    }
}

