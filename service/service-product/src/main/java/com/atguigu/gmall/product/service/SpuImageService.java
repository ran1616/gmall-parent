package com.atguigu.gmall.product.service;

import com.atguigu.gmall.product.entity.SpuImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author RAN
* @description 针对表【spu_image(商品图片表)】的数据库操作Service
* @createDate 2023-07-11 20:15:05
*/
public interface SpuImageService extends IService<SpuImage> {

    List<SpuImage> findAll(Integer spuId);
}
