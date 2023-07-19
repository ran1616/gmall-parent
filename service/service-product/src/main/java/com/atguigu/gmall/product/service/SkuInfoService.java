package com.atguigu.gmall.product.service;

import com.atguigu.gmall.product.dto.SkuInfoDTO;
import com.atguigu.gmall.product.entity.SkuInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author RAN
* @description 针对表【sku_info(库存单元表)】的数据库操作Service
* @createDate 2023-07-11 20:15:05
*/
public interface SkuInfoService extends IService<SkuInfo> {

    Page findSkuInfoPage(Integer pageNO, Integer limit);

    void saveSkuInfo(SkuInfoDTO skuInfoDTO);

    void updateSaleStatus(Long skuId, String number);
}
