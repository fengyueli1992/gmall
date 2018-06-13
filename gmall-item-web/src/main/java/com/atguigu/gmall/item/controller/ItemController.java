package com.atguigu.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.bean.SkuInfo;
import com.atguigu.gmall.bean.SkuSaleAttrValue;
import com.atguigu.gmall.bean.SpuSaleAttr;
import com.atguigu.gmall.service.SkuInfoService;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {
    @Reference
    SkuInfoService skuInfoService;
    @Reference
    SpuInfoService spuInfoService;
    @RequestMapping("{skuId}.html")
    public String html(@PathVariable String skuId,ModelMap modelMap){
        SkuInfo skuInfo= skuInfoService.html(skuId);
        //当前sku信息
        modelMap.put("skuInfo",skuInfo);

        //  获取所有销售属性及值及带选择的属性
        List<SpuSaleAttr> spuSaleAttrs = spuInfoService.selectSaleAttrCheckedBySpuAndSku(skuInfo.getSpuId(), skuId);
        modelMap.put("spuSaleAttrListCheckBySku",spuSaleAttrs);

        //获取每个sku和其多个销售属性值的对应关系JSON
        List<SkuInfo> skuHash=skuInfoService.getSkuHashBySpuId(skuInfo.getSpuId());
        Map<String,String> mapSku=new HashMap<>();
        for (SkuInfo hash : skuHash) {
            String v=hash.getId();
            String k="";
            List<SkuSaleAttrValue> skuSaleAttrValueList = hash.getSkuSaleAttrValueList();
            for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValueList) {
                String id=skuSaleAttrValue.getSaleAttrValueId();
                k+="|"+id;
            }
            mapSku.put(k,v);
        }
        String skuHashJson = JSON.toJSONString(mapSku);
        modelMap.put("skuHashJson",skuHashJson);
        return "item";
    }
    @RequestMapping("index")
    public String index(ModelMap map){
        map.addAttribute("hello","hello thymeleaf");

        List list=new ArrayList();
        list.add("tyemelaeaf1");
        list.add("tyemelaeaf2");
        list.add("tyemelaeaf3");
        list.add("tyemelaeaf4");
        list.add("tyemelaeaf5");
        map.addAttribute("list",list);
        return "index";
    }
}
