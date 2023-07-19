package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.dto.SpuInfoDto;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/product/")
public class SpuInfoController {

    @Autowired
    private SpuInfoService spuInfoService;

    /*
    * http://api.gmall.com/admin/product/{page}/{limit}?category3Id=61
     * */
    @GetMapping("{page}/{limit}")
    public Result<Page> pageSpuInfo(@PathVariable("page") Integer pageNo,
                                    @PathVariable("limit") Integer limit,
                                    Long category3Id){

       Page spuInfoPage =  spuInfoService.findCategory3IdByPage(pageNo,limit,category3Id);

       return Result.build(spuInfoPage, ResultCodeEnum.SUCCESS);
    }


    @PostMapping("/saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfoDto spuInfoDto){
        spuInfoService.saveSpuInfo(spuInfoDto);
        return Result.ok();
    }

}
