package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.product.dto.SpuInfoDto;
import com.atguigu.gmall.product.entity.SpuImage;
import com.atguigu.gmall.product.entity.SpuSaleAttr;
import com.atguigu.gmall.product.entity.SpuSaleAttrValue;
import com.atguigu.gmall.product.service.SpuImageService;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.atguigu.gmall.product.service.SpuSaleAttrValueService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.entity.SpuInfo;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.atguigu.gmall.product.mapper.SpuInfoMapper;
import jodd.bean.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author RAN
* @description 针对表【spu_info(商品表)】的数据库操作Service实现
* @createDate 2023-07-11 20:15:05
*/
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo>
    implements SpuInfoService{

    @Autowired
    private SpuImageService spuImageService;

    @Autowired
    private SpuSaleAttrService spuSaleAttrService;

    @Autowired
    private SpuSaleAttrValueService spuSaleAttrValueService;
    @Override
    public Page findCategory3IdByPage(Integer pageNo, Integer limit, Long category3Id) {

        Page<SpuInfo> spuInfoPage = new Page<>(pageNo,limit);
        LambdaQueryWrapper<SpuInfo> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SpuInfo::getCategory3Id,category3Id);

        page(spuInfoPage,lambdaQueryWrapper);
        return spuInfoPage;
    }

    @Override
    public void saveSpuInfo(SpuInfoDto spuInfoDto) {

        SpuInfo spuInfo = new SpuInfo();
        BeanUtils.copyProperties(spuInfoDto,spuInfo);
        this.save(spuInfo);

        //保存spu图片
        List<SpuImage> spuImageList = spuInfoDto.getSpuImageList();
        spuImageList.stream().map(spuImage -> {
            spuImage.setSpuId(spuInfo.getId());
            return  spuImage;
        }).collect(Collectors.toList());
        spuImageService.saveBatch(spuImageList);

        //保存spu销售属性名
        List<SpuSaleAttr> spuSaleAttrList = spuInfoDto.getSpuSaleAttrList();
        spuSaleAttrList.stream().map(spuSaleAttr -> {
            spuSaleAttr.setSpuId(spuInfo.getId());
            return spuSaleAttr;
        }).collect(Collectors.toList());
        spuSaleAttrService.saveBatch(spuSaleAttrList);

        //保存spu的销售属性值
        spuSaleAttrList.stream().forEach(spuSaleAttr -> {
            List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
            spuSaleAttrValueList.stream().map(spuSaleAttrValue -> {
                spuSaleAttrValue.setSaleAttrName(spuSaleAttr.getSaleAttrName());
                spuSaleAttrValue.setSpuId(spuInfo.getId());
                return spuSaleAttrValue;
            }).collect(Collectors.toList());
            spuSaleAttrValueService.saveBatch(spuSaleAttrValueList);
        });
    }
}




