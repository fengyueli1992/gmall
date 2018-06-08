package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseAttrValue;
import com.atguigu.gmall.vo.Datas;

import java.util.List;
import java.util.Map;

public interface AttrService {
    public List<BaseAttrInfo> getAttrListCatalog3(String id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    int deleteAttrInfo(String id);
}
