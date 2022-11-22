package com.example.boluouitest2.comod.baselib.view.flow;

import android.view.View;

import java.util.List;

/* renamed from: e.f.a.e.d.a */
/* loaded from: classes.dex */
public abstract class FlowAdapter<T> {


    /* renamed from: a */
    public List<T> f13241a;

    public FlowAdapter(List<T> list) {
        this.f13241a = list;
    }

    /* renamed from: a */
    public int mo35214a() {
        List<T> list = this.f13241a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public abstract View mo11688a(int i);

}
