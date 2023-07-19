package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author RAN
* @description 针对表【spu_sale_attr(spu销售属性)】的数据库操作Mapper
* @createDate 2023-07-11 20:15:05
* @Entity com.atguigu.gmall.product.entity.SpuSaleAttr
*/
public interface SpuSaleAttrMapper extends BaseMapper<SpuSaleAttr> {

    List<SpuSaleAttr> findBySpuId(Integer spuId);

    List<SpuSaleAttr> findSpuSalAttrBySkuId(Long skuId);
}




