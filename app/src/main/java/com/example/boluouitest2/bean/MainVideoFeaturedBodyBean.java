package com.example.boluouitest2.bean;



import com.alibaba.fastjson.JSONArray;

import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;

/* loaded from: classes.dex */
public class MainVideoFeaturedBodyBean extends BaseListViewAdapter.C0890c {
    public String desc;
    public String icon;
    public JSONArray item;
    public String name;
    public String subName;
    public String type;

    public String getDesc() {
        return this.desc;
    }

    public String getIcon() {
        return this.icon;
    }

    public JSONArray getItem() {
        return this.item;
    }

    public String getName() {
        return this.name;
    }

    public String getSubName() {
        return this.subName;
    }

    public String getType() {
        return this.type;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setItem(JSONArray jSONArray) {
        this.item = jSONArray;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSubName(String str) {
        this.subName = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}

