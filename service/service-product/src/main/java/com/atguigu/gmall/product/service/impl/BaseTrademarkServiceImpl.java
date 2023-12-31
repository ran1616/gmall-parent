package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.common.execption.GmallException;
import com.atguigu.gmall.common.result.ResultCodeEnum;
import com.atguigu.gmall.product.entity.SkuInfo;
import com.atguigu.gmall.product.entity.SpuInfo;
import com.atguigu.gmall.product.mapper.SkuInfoMapper;
import com.atguigu.gmall.product.mapper.SpuInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.entity.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.atguigu.gmall.product.mapper.BaseTrademarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author RAN
* @description 针对表【base_trademark(品牌表)】的数据库操作Service实现
* @createDate 2023-07-11 20:15:05
*/
@Service
public class BaseTrademarkServiceImpl extends ServiceImpl<BaseTrademarkMapper, BaseTrademark>
    implements BaseTrademarkService{

    @Autowired
    private SpuInfoMapper spuInfoMapper;

    @Autowired
    private SkuInfoMapper skuInfoMapper;

    @Override
    public Page findByPage(Integer pageNo, Integer pageSize) {

        Page page = new Page(pageNo,pageSize);
        QueryWrapper queryWrapper = new QueryWrapper();
        page(page, queryWrapper);
        return page;
    }

    @Override
    public void deleteById(Long id) {

        LambdaQueryWrapper<SpuInfo> spulambdaQueryWrapper = new LambdaQueryWrapper<>();
        spulambdaQueryWrapper.eq(SpuInfo::getTmId, id);
        List<SpuInfo> spuInfoList = spuInfoMapper.selectList(spulambdaQueryWrapper);
        if (spuInfoList != null && spuInfoList.size() > 0){
            throw new GmallException(ResultCodeEnum.ERROR_SPU_REF) ;
        }

        LambdaQueryWrapper<SkuInfo> skulambdaQueryWrapper = new LambdaQueryWrapper<>();
        skulambdaQueryWrapper.eq(SkuInfo::getTmId, id);
        List<SkuInfo> skuInfoList = skuInfoMapper.selectList(skulambdaQueryWrapper);
        if (skuInfoList != null && skuInfoList.size() > 0){
            throw new GmallException(ResultCodeEnum.ERROR_SPU_REF) ;
        }

        removeById(id);
    }
}




