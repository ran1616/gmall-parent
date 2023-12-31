package com.atguigu.gmall.product.service;

import com.atguigu.gmall.product.entity.BaseAttrInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author RAN
* @description 针对表【base_attr_info(属性表)】的数据库操作Service
* @createDate 2023-07-11 20:15:05
*/
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {

    List<BaseAttrInfo> findBaseAttrInfo(Long c1Id, Long c2Id, Long c3Id);

    void saveBaseAttrInfo(BaseAttrInfo baseAttrInfo);
}
