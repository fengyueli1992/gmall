package com.atguigu.gmall.vo;

import com.atguigu.gmall.bean.BaseAttrValue;

import java.io.Serializable;
import java.util.List;

public class Datas implements Serializable{
    List<BaseAttrValue> attrValueList;
    String catalog3Id;
    String attrName;

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public List<BaseAttrValue> getAttrValueList() {
        return attrValueList;
    }

    public void setAttrValueList(List<BaseAttrValue> attrValueList) {
        this.attrValueList = attrValueList;
    }
}
