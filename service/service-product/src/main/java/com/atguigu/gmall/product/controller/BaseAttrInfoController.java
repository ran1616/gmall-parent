package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.entity.BaseAttrInfo;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/product/")
public class BaseAttrInfoController {

    @Autowired
    private BaseAttrInfoService baseAttrInfoService;


    /*
     *http://api.gmall.com/admin/product/attrInfoList/{category1Id}/{category2Id}/{category3Id}
     * */
    @GetMapping("/attrInfoList/{c1Id}/{c2Id}/{c3Id}")
    public Result<List<BaseAttrInfo>> findBaseAttrInfo(@PathVariable("c1Id") Long c1Id,
                                                       @PathVariable("c2Id") Long c2Id,
                                                       @PathVariable("c3Id") Long c3Id) {

        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoService.findBaseAttrInfo(c1Id, c2Id, c3Id);

        return Result.ok(baseAttrInfoList);

    }

    @PostMapping("/saveAttrInfo")
    public Result saveBaseAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {

        baseAttrInfoService.saveBaseAttrInfo(baseAttrInfo);

        return Result.ok();

    }
}
