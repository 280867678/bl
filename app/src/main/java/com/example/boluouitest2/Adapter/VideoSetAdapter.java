package com.example.boluouitest2.Adapter;

import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.VHDelegate.VideoHSmallCoverVHDelegate;

/* loaded from: classes.dex */
public class VideoSetAdapter extends BaseListViewAdapter {
    @Override // com.comod.baselib.list.BaseListViewAdapter
    public VHDelegateImpl createVHDelegate(int i) {
        return new VideoHSmallCoverVHDelegate();
    }
}
