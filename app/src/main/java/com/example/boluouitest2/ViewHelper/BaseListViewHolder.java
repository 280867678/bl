package com.example.boluouitest2.ViewHelper;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boluouitest2.VHDelegate.VHDelegateImpl;

/* loaded from: classes.dex */
public class BaseListViewHolder<T extends BaseListViewAdapter.C0890c> extends RecyclerView.ViewHolder {

    /* renamed from: a */
    public VHDelegateImpl<T> f1525a;

    public BaseListViewHolder(@NonNull View view, VHDelegateImpl<T> dVar) {
        super(view);
        try {
            this.f1525a = dVar;
            this.f1525a.mo9237a(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public VHDelegateImpl<T> m20148a() {
        return this.f1525a;
    }
}
