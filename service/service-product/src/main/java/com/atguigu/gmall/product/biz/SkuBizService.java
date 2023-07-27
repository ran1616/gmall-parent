package com.atguigu.gmall.product.biz;

import com.atguigu.gmall.product.entity.SkuInfo;
import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.atguigu.gmall.product.vo.AttrValueConcatVo;
import com.atguigu.gmall.product.vo.CategoryView;
import com.atguigu.gmall.product.vo.SkuDetailVo;

import java.util.List;

public interface SkuBizService {

     CategoryView findCategoryViewBySkuId(Long skuId);

      SkuInfo findSkuInfoAndImageBySkuId(Long skuId);

     SkuInfo findSkuInfoBySkuId(Long skuId);

      List<SpuSaleAttr> findSpuSalAttrBySkuId(Long skuId);

     List<AttrValueConcatVo> findSkuAttrValueConcatBySkuId(Long skuId);

     SkuDetailVo findSkuDetailVo(Long skuId);

    List<Long> findAllSkuIds();
}
