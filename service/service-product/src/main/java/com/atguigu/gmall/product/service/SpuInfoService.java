package com.atguigu.gmall.product.service;

import com.atguigu.gmall.product.dto.SpuInfoDto;
import com.atguigu.gmall.product.entity.SpuInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author RAN
* @description 针对表【spu_info(商品表)】的数据库操作Service
* @createDate 2023-07-11 20:15:05
*/
public interface SpuInfoService extends IService<SpuInfo> {

    Page findCategory3IdByPage(Integer pageNo, Integer limit,Long category3Id);

    void saveSpuInfo(SpuInfoDto spuInfoDto);

}
