package com.atguigu.gmall.manage.controller;

import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuImage;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.bean.SpuSaleAttr;
import com.atguigu.gmall.manage.util.MyFileUploadUtil;
import com.atguigu.gmall.service.SpuInfoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping("getSpuInfo")
    @ResponseBody
    public SpuInfo getSpuInfo(@RequestParam String spuId){
        return spuInfoService.getSpuInfo(spuId);


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

    @RequestMapping("spuImageList")
    @ResponseBody
    public List<SpuImage> spuImageList(String spuId){
        List<SpuImage> spuImages = spuInfoService.spuImageList(spuId);
        return spuImages;


    }
    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){
        return spuInfoService.spuSaleAttrList(spuId);


    }

    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file){
        String url="";
        try {
          url=  MyFileUploadUtil.uploadImage(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;


    }

}
