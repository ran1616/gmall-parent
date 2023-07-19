package com.atguigu.gmall.product.dto;

import com.atguigu.gmall.product.entity.SkuAttrValue;
import com.atguigu.gmall.product.entity.SkuImage;
import com.atguigu.gmall.product.entity.SkuSaleAttrValue;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SkuInfoDTO {

    private Long id;
    private Long spuId;
    private Double price;
    private String skuName;
    private String skuDesc;
    private BigDecimal weight;
    private Long tmId;
    private Long category3Id;
    private String skuDefaultImg;

    private List<SkuAttrValue> skuAttrValueList ;
    private List<SkuSaleAttrValue> skuSaleAttrValueList ;
    private List<SkuImage> skuImageList ;

}