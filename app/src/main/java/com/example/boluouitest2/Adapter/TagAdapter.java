package com.example.boluouitest2.Adapter;



import android.util.Log;
import android.view.View;


import com.example.boluouitest2.comod.baselib.view.tag.FlowLayout;

import java.util.HashSet;
import java.util.List;

/* renamed from: e.f.a.e.g.a */
/* loaded from: classes.dex */
public abstract class TagAdapter<T> {

    /* renamed from: a */
    public List<T> f13243a;
    @Deprecated

    /* renamed from: b */
    public HashSet<Integer> f13244b = new HashSet<>();

    /* compiled from: TagAdapter.java */
    /* renamed from: e.f.a.e.g.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC4332a {
    }

    public TagAdapter(List<T> list) {
        this.f13243a = list;
    }

    /* renamed from: a */
    public int m9016a() {
        List<T> list = this.f13243a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public abstract View mo9012a(FlowLayout flowLayout, int i, T t);

    /* renamed from: a */
    public boolean m9013a(int i, T t) {
        return false;
    }

    @Deprecated
    /* renamed from: b */
    public HashSet<Integer> m9011b() {
        return this.f13244b;
    }

    public void setOnDataChangedListener(AbstractC4332a aVar) {
    }

    /* renamed from: a */
    public T m9015a(int i) {
        return this.f13243a.get(i);
    }

    /* renamed from: b */
    public void m9010b(int i, View view) {
        Log.d("zhy", "unSelected " + i);
    }

    /* renamed from: a */
    public void m9014a(int i, View view) {
        Log.d("zhy", "onSelected " + i);
    }
}

