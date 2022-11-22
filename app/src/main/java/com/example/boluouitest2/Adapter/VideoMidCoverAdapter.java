package com.example.boluouitest2.Adapter;

import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.VHDelegate.VideoMidCoverVHDelegate;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;

/* loaded from: classes.dex */
public class VideoMidCoverAdapter extends BaseListViewAdapter {
    @Override // com.comod.baselib.list.BaseListViewAdapter
    public VHDelegateImpl createVHDelegate(int i) {
        return new VideoMidCoverVHDelegate();
    }
}
