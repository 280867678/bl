package com.example.boluouitest2.bean;

import java.util.List;

public class SearchNormalInfoBean {
    public List<AdBannerBean> ads;
    public List<TagInfoBean> list;

    public List<AdBannerBean> getAds() {
        return this.ads;
    }

    public List<TagInfoBean> getList() {
        return this.list;
    }

    public void setAds(List<AdBannerBean> list) {
        this.ads = list;
    }

    public void setList(List<TagInfoBean> list) {
        this.list = list;
    }


}
