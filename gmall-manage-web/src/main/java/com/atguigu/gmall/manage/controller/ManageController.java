package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseCatalog1;
import com.atguigu.gmall.bean.BaseCatalog2;
import com.atguigu.gmall.bean.BaseCatalog3;
import com.atguigu.gmall.service.ManagerService;
import com.atguigu.gmall.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ManageController {
    @Reference
    ManagerService managerService;

    @RequestMapping(value = "/index" )
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/attrListPage" )
    public String attrListPage(){
        return "attrListPage";
    }

    @RequestMapping(value = "/getCatalog1" )
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        List<BaseCatalog1> baseCatalogs=managerService.getCatalog1();
        return baseCatalogs;
    }
    @RequestMapping(value = "/getCatalog2" )
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(@RequestParam String id){
        List<BaseCatalog2> baseCatalogs=managerService.getCatalog2(id);
        return baseCatalogs;
    }
    @RequestMapping(value = "/getCatalog3" )
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(@RequestParam Map<String,String> map){
       String id= map.get("id");
        List<BaseCatalog3> baseCatalogs=managerService.getCatalog3(id);
        return baseCatalogs;
    }

}

