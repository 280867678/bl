package com.example.boluouitest2.Adapter;

import com.example.boluouitest2.VHDelegate.PersonalVideoVHDelegate;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;

/* loaded from: classes.dex */
public class PersonalVideoAdapter extends BaseListViewAdapter {

    /* renamed from: a */
    public int f1021a;

    public PersonalVideoAdapter(int i) {
        this.f1021a = i;
    }

    @Override // com.comod.baselib.list.BaseListViewAdapter
    public VHDelegateImpl createVHDelegate(int i) {
        return new PersonalVideoVHDelegate(this.f1021a);
    }
}
