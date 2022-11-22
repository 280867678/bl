package com.example.boluouitest2.util;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: e.f.a.d.d0 */
/* loaded from: classes.dex */
public class RecyclerViewUtil {
    /* renamed from: a */
    public static LinearLayoutManager m9212a(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        return linearLayoutManager;
    }
}
