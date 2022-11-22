package com.example.boluouitest2.comod.baselib.view.magicindicator.util;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    public int f1532a;

    /* renamed from: b */
    public int f1533b;

    /* renamed from: c */
    public int f1534c;

    /* renamed from: d */
    public int f1535d;

    public SpacesItemDecoration(int i) {
        this(i, i);
    }

    @Override // android.support.p004v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if ((linearLayoutManager != null ? linearLayoutManager.getOrientation() : 1) == 1) {
            rect.left = this.f1532a;
            rect.right = this.f1533b;
            rect.bottom = this.f1535d;
            if (recyclerView.getChildLayoutPosition(view) == 0) {
                rect.top = this.f1534c;
            } else {
                rect.top = 0;
            }
        } else {
            rect.top = this.f1534c;
            rect.right = this.f1533b;
            rect.bottom = this.f1535d;
            if (recyclerView.getChildLayoutPosition(view) == 0) {
                rect.left = this.f1532a;
            } else {
                rect.left = 0;
            }
        }
    }

    public SpacesItemDecoration(int i, int i2) {
        this(i, i, i2, i2);
    }

    public SpacesItemDecoration(int i, int i2, int i3, int i4) {
        this.f1532a = i;
        this.f1533b = i2;
        this.f1534c = i3;
        this.f1535d = i4;
    }


}
