package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.product.entity.SkuSaleAttrValue;
import com.atguigu.gmall.product.vo.AttrValueConcatVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author RAN
* @description 针对表【sku_sale_attr_value(sku销售属性值)】的数据库操作Mapper
* @createDate 2023-07-11 20:15:05
* @Entity com.atguigu.gmall.product.entity.SkuSaleAttrValue
*/
public interface SkuSaleAttrValueMapper extends BaseMapper<SkuSaleAttrValue> {

    List<AttrValueConcatVo> findSkuAttrValueConcatBySkuId(Long skuId);
}




