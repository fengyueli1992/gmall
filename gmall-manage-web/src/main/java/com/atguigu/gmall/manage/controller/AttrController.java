package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.service.AttrService;
import com.atguigu.gmall.vo.Datas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class AttrController {
    @Reference
    AttrService attrService;

    @RequestMapping("getAttrList")
    @ResponseBody
    public List<BaseAttrInfo> getAttrList(@RequestParam  String id){
        List<BaseAttrInfo> baseAttrInfos=attrService.getAttrListCatalog3(id);
        return baseAttrInfos;
    }
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(BaseAttrInfo baseAttrInfo){
        attrService.saveAttrInfo(baseAttrInfo);
        return "success";
    }

    @RequestMapping("deleteAttrInfo")
    @ResponseBody
    public String deleteAttrInfo(String id){
        int i=attrService.deleteAttrInfo(id);
        if(1==i){
            return "success";
        }else{
            return "fail";
        }

    }

}
