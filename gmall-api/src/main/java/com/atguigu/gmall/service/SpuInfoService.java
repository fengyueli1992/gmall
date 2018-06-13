package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuImage;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.bean.SpuSaleAttr;

import java.util.List;

public interface SpuInfoService {
    List<SpuInfo> getSpuInfoList(String catalog3Id);

    List<BaseSaleAttr> baseSaleAttrList();

    void saveSpu(SpuInfo spuInfo);

    List<SpuImage> spuImageList(String spuId);

    List<SpuSaleAttr> spuSaleAttrList(String spuId);

    SpuInfo getSpuInfo(String spuId);

    List<SpuSaleAttr> selectSaleAttrCheckedBySpuAndSku(String spuId, String skuId);
}
