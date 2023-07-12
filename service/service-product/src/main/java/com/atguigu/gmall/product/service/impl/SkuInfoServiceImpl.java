package com.atguigu.gmall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.entity.SkuInfo;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.atguigu.gmall.product.mapper.SkuInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author RAN
* @description 针对表【sku_info(库存单元表)】的数据库操作Service实现
* @createDate 2023-07-11 20:15:05
*/
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
    implements SkuInfoService{

}




