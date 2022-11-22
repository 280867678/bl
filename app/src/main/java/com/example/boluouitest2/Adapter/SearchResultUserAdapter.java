package com.example.boluouitest2.Adapter;

import com.example.boluouitest2.VHDelegate.SearchResultUserVHDelegate;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;

/* loaded from: classes.dex */
public class SearchResultUserAdapter extends BaseListViewAdapter {

    /* renamed from: a */
    public String f1022a;

    /* renamed from: a */
    public void m20586a(String str) {
        this.f1022a = str;
    }

    @Override // com.comod.baselib.list.BaseListViewAdapter
    public VHDelegateImpl createVHDelegate(int i) {
        return new SearchResultUserVHDelegate(this.f1022a);
    }
}
