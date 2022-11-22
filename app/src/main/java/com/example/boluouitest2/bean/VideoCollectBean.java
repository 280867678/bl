package com.example.boluouitest2.bean;

import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;

import java.util.List;

/* loaded from: classes.dex */
public class VideoCollectBean extends BaseListViewAdapter.C0890c {
    public VideoCollectInfoBean info;
    public List<VideoBean> list;

    public VideoCollectInfoBean getInfo() {
        return this.info;
    }

    public List<VideoBean> getList() {
        return this.list;
    }

    public void setInfo(VideoCollectInfoBean videoCollectInfoBean) {
        this.info = videoCollectInfoBean;
    }

    public void setList(List<VideoBean> list) {
        this.list = list;
    }
}
