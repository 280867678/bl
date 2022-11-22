package com.example.boluouitest2.Adapter;

import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.VHDelegate.VideoCollectVideoListVHDelegate;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;

/* loaded from: classes.dex */
public class VideoCollectVideoListAdapter extends BaseListViewAdapter {
    @Override // com.comod.baselib.list.BaseListViewAdapter
    public VHDelegateImpl createVHDelegate(int i) {
        return new VideoCollectVideoListVHDelegate();
    }
}
