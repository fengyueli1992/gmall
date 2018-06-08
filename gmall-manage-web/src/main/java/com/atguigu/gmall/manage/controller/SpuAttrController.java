package com.atguigu.gmall.manage.controller;

import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.service.SpuInfoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpuAttrController {
    @Reference
    private SpuInfoService spuInfoService;
    @RequestMapping("spuAttrListPage")
    public String spuAttrListPage(){
        return "spuAttrListPage";
    }


    @RequestMapping("getSpuInfoList")
    @ResponseBody
    public List<SpuInfo> getSpuInfoList(@RequestParam String id){
       return spuInfoService.getSpuInfoList(id);


    }
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<BaseSaleAttr> baseSaleAttrList(){
        return spuInfoService.baseSaleAttrList();


    }
    @RequestMapping("saveSpu")
    @ResponseBody
    public String saveSpu(SpuInfo spuInfo){
        spuInfoService.saveSpu(spuInfo);
        return "success";


    }

}
