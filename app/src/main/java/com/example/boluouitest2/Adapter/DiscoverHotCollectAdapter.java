package com.example.boluouitest2.Adapter;

import com.example.boluouitest2.VHDelegate.DiscoverHotVideoCollectVHDelegate;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.bean.VideoCollectInfoBean;

/* loaded from: classes.dex */
public class DiscoverHotCollectAdapter extends BaseListViewAdapter<VideoCollectInfoBean> {
    @Override // com.comod.baselib.list.BaseListViewAdapter
    public VHDelegateImpl<VideoCollectInfoBean> createVHDelegate(int i) {
        return new DiscoverHotVideoCollectVHDelegate();
    }
}
