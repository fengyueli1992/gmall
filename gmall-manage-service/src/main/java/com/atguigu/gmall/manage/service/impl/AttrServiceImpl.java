package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseAttrValue;
import com.atguigu.gmall.manage.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.manage.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.service.AttrService;
import com.atguigu.gmall.vo.Datas;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class AttrServiceImpl implements AttrService {
    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;
    @Override
    public List<BaseAttrInfo> getAttrListCatalog3(String id) {
        BaseAttrInfo baseAttrInfo=new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(id);
        List<BaseAttrInfo> baseAttrInfos=baseAttrInfoMapper.select(baseAttrInfo);
        return baseAttrInfos;
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {

        baseAttrInfoMapper.insert(baseAttrInfo);
        String id = baseAttrInfo.getId();

        //获得values集合
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
      for(int i=0;i<attrValueList.size();i++){
          BaseAttrValue baseAttrValue = attrValueList.get(i);
          baseAttrValue.setAttrId(id);
          baseAttrValueMapper.insert(baseAttrValue);
      }

    }

    @Override
    public int deleteAttrInfo(String id) {
        BaseAttrValue baseAttrValue=new BaseAttrValue();
        baseAttrValue.setAttrId(id);
       int i= baseAttrValueMapper.delete(baseAttrValue);
      int j =baseAttrInfoMapper.deleteByPrimaryKey(id);
        return j;
    }
}
