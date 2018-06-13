package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpuInfoServiceImpl implements SpuInfoService {
    @Autowired
    private SpuInfoMapper spuInfoMapper;
    @Autowired
    private BaseSaleAttrMapper baseSaleAttrMapper;
    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;
    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;
    @Autowired
    private SpuImageMapper spuImageMapper;

    @Override
    public List<SpuInfo> getSpuInfoList(String catalog3Id) {
        SpuInfo spuInfo=new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        return spuInfoMapper.select(spuInfo);
    }

    @Override
    public List<BaseSaleAttr> baseSaleAttrList() {
        return baseSaleAttrMapper.selectAll();
    }

    @Override
    public void saveSpu(SpuInfo spuInfo) {
        //插入商品表
        spuInfoMapper.insert(spuInfo);
        //插入商品属性表
        String spuId=spuInfo.getId();
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {
            spuSaleAttr.setSpuId(spuId);
            spuSaleAttrMapper.insert(spuSaleAttr);
            //插入商品属性值表
            List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
            for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList) {
                spuSaleAttrValue.setSpuId(spuId);
                spuSaleAttrValueMapper.insert(spuSaleAttrValue);
            }
        }
        //保存图片
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        for (SpuImage spuImage : spuImageList) {
            spuImage.setSpuId(spuId);
            spuImageMapper.insert(spuImage);
        }


    }

    @Override
    public List<SpuImage> spuImageList(String spuId) {
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuId);
        return spuImageMapper.select(spuImage);
    }

    @Override
    public List<SpuSaleAttr> spuSaleAttrList(String spuId) {
        SpuSaleAttr spuSaleAttr = new SpuSaleAttr();
        spuSaleAttr.setSpuId(spuId);
        List<SpuSaleAttr> spuSaleAttrs = spuSaleAttrMapper.select(spuSaleAttr);
        for (SpuSaleAttr saleAttr : spuSaleAttrs) {
            SpuSaleAttrValue spuSaleAttrValue=new SpuSaleAttrValue();
            spuSaleAttrValue.setSpuId(saleAttr.getSpuId());
            spuSaleAttrValue.setSaleAttrId(saleAttr.getSaleAttrId());
            List<SpuSaleAttrValue> select = spuSaleAttrValueMapper.select(spuSaleAttrValue);
            saleAttr.setSpuSaleAttrValueList(select);
        }
        return spuSaleAttrs;
    }

    @Override
    public SpuInfo getSpuInfo(String spuId) {
        return spuInfoMapper.selectByPrimaryKey(spuId);
    }
    @Override
    public List<SpuSaleAttr> selectSaleAttrCheckedBySpuAndSku(String spuId,String skuId){
        Map<Object,Object> map=new HashMap<>();
        map.put("spuId",Integer.parseInt(spuId));
        map.put("skuId",Integer.parseInt(skuId));
        List<SpuSaleAttr> spuSaleAttrs = spuSaleAttrMapper.selectSaleAttrCheckedBySpuAndSku(map);
        return spuSaleAttrs;
    }

}
