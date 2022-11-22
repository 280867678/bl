package com.example.boluouitest2.Adapter;

import com.example.boluouitest2.VHDelegate.SearchNormalTagInfoVHDelegate;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;

/* loaded from: classes.dex */
public class SearchNormalTagAdapter extends BaseListViewAdapter {
    @Override // com.comod.baselib.list.BaseListViewAdapter
    public VHDelegateImpl createVHDelegate(int i) {
        return new SearchNormalTagInfoVHDelegate();
    }
}
