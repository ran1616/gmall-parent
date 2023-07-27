package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.product.dto.SkuInfoDto;
import com.atguigu.gmall.product.entity.SkuAttrValue;
import com.atguigu.gmall.product.entity.SkuImage;
import com.atguigu.gmall.product.entity.SkuSaleAttrValue;
import com.atguigu.gmall.product.service.SkuAttrValueService;
import com.atguigu.gmall.product.service.SkuImageService;
import com.atguigu.gmall.product.service.SkuSaleAttrValueService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.entity.SkuInfo;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.atguigu.gmall.product.mapper.SkuInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author RAN
* @description 针对表【sku_info(库存单元表)】的数据库操作Service实现
* @createDate 2023-07-11 20:15:05
*/
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
    implements SkuInfoService{

    @Autowired
    private SkuImageService skuImageService;

    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @Autowired
    private SkuAttrValueService skuAttrValueService;
    @Override
    public Page findSkuInfoPage(Integer pageNO, Integer limit) {
        Page<SkuInfo> skuInfoPage = new Page<>(pageNO,limit);
        this.page(skuInfoPage);
        return skuInfoPage;
    }

    @Override
    @Transactional
    public void saveSkuInfo(SkuInfoDto skuInfoDto) {

        SkuInfo skuInfo = new SkuInfo();
        BeanUtils.copyProperties(skuInfoDto,skuInfo);
        this.save(skuInfo);


        List<SkuImage> skuImageList = skuInfoDto.getSkuImageList();
        skuImageList.stream().map(skuImage -> {
            skuImage.setSkuId(skuInfo.getId());
            return skuImage;
        }).collect(Collectors.toList());
        skuImageService.saveBatch(skuImageList);


        // 保存SKU平台属性信息
        List<SkuAttrValue> skuAttrValueList = skuInfoDto.getSkuAttrValueList();
        skuAttrValueList = skuAttrValueList.stream().map(item -> {
            item.setSkuId(skuInfo.getId());
            return item ;
        }).collect(Collectors.toList()) ;
        skuAttrValueService.saveBatch(skuAttrValueList) ;

        // 保存SKU销售属性信息
        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfoDto.getSkuSaleAttrValueList();
        skuSaleAttrValueList = skuSaleAttrValueList.stream().map(skuSaleAttrValue -> {
            skuSaleAttrValue.setSkuId(skuInfo.getId());
            skuSaleAttrValue.setSpuId(skuInfoDto.getSpuId());
            return skuSaleAttrValue ;
        }).collect(Collectors.toList()) ;
        skuSaleAttrValueService.saveBatch(skuSaleAttrValueList) ;
    }

    @Override
    public void onSale(Long skuId) {
        SkuInfo skuInfo = this.getById(skuId);
        skuInfo.setIsSale(1);
        this.updateById(skuInfo) ;
    }

    @Override
    public void cancelSale(Long skuId) {
        SkuInfo skuInfo = this.getById(skuId);
        skuInfo.setIsSale(0);
        this.updateById(skuInfo) ;
    }


}




