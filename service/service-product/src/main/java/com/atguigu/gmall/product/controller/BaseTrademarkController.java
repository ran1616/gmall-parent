package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.entity.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("品牌列表")
@RestController
@RequestMapping("/admin/product/baseTrademark")
public class BaseTrademarkController {

    @Autowired
    private BaseTrademarkService baseTrademarkService;

    @ApiOperation("品牌列表分页")
    @GetMapping("/{page}/{limit}")
    public Result<Page> findByPage(@PathVariable("page") Integer pageNo,
                                   @PathVariable("limit") Integer pageSize) {
        Page page = baseTrademarkService.findByPage(pageNo, pageSize);
        return Result.build(page, ResultCodeEnum.SUCCESS);
    }

    @ApiOperation("添加品牌")
    @PostMapping("/save")
    public Result save(@RequestBody BaseTrademark baseTrademark) {
        baseTrademarkService.save(baseTrademark);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }


    @ApiOperation("根据id获取品牌")
    @GetMapping("/get/{id}")
    public Result<BaseTrademark> getById(@PathVariable("id") Long id) {

        BaseTrademark baseTrademark = baseTrademarkService.getById(id);
        return Result.build(baseTrademark, ResultCodeEnum.SUCCESS);
    }

    @PutMapping("/update")
    public Result updateById(@RequestBody BaseTrademark baseTrademark) {
        baseTrademarkService.updateById(baseTrademark);
        return Result.ok();
    }

    @DeleteMapping("remove/{id}")
    public Result deleteById(@PathVariable("id") Long id) {
        baseTrademarkService.deleteById(id);
        return Result.ok();
    }

    //baseTrademark/getTrademarkList
    @GetMapping("/getTrademarkList")
    public Result<List<BaseTrademark>> findAllBaseTrademark(){

        List<BaseTrademark> baseTrademarkList = baseTrademarkService.list();
        return Result.build(baseTrademarkList,ResultCodeEnum.SUCCESS);
    }

}
