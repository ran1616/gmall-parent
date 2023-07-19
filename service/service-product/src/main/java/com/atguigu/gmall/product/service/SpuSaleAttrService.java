package com.atguigu.gmall.product.service;

import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author RAN
* @description 针对表【spu_sale_attr(spu销售属性)】的数据库操作Service
* @createDate 2023-07-11 20:15:05
*/
public interface SpuSaleAttrService extends IService<SpuSaleAttr> {

    List<SpuSaleAttr> findBySpuId(Integer spuId);
}
