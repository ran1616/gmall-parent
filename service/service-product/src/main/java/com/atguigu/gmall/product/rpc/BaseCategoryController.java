package com.atguigu.gmall.product.rpc;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.biz.BaseCategoryBizService;
import com.atguigu.gmall.product.vo.CategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/inner/product")
@Slf4j
public class BaseCategoryController {

    @Autowired
    private BaseCategoryBizService baseCategoryBizService ;

    @GetMapping("/findAllCategoryTree")
    public Result<List<CategoryVo>> findAllCategoryTree() {

        List<CategoryVo> categoryVoList =  baseCategoryBizService.findAllCategoryTree() ;
        return Result.build(categoryVoList , ResultCodeEnum.SUCCESS) ;
    }

}

