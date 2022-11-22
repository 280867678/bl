package com.example.boluouitest2.comod.baselib.util;



import android.graphics.Rect;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

/* loaded from: classes.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    public int f1526a;

    /* renamed from: b */
    public int f1527b;

    /* renamed from: c */
    public boolean f1528c;

    /* renamed from: d */
    public int f1529d;

    /* renamed from: e */
    public boolean f1530e;

    /* renamed from: f */
    public boolean f1531f;

    public GridSpacingItemDecoration(int i, int i2, boolean z, boolean z2, boolean z3) {
        this(0, i, i2, z, z2, z3);
    }

    @Override // android.support.p004v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        try {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int itemCount = ((RecyclerView.Adapter) Objects.requireNonNull(recyclerView.getAdapter())).getItemCount();
            if (childAdapterPosition - this.f1529d >= 0) {
                int i = childAdapterPosition - this.f1529d;
                int i2 = i % this.f1526a;
                if (this.f1528c) {
                    rect.left = this.f1527b - ((this.f1527b * i2) / this.f1526a);
                    rect.right = ((i2 + 1) * this.f1527b) / this.f1526a;
                    if (i >= this.f1526a) {
                        rect.top = this.f1527b;
                    } else if (this.f1530e) {
                        rect.top = this.f1527b;
                    } else {
                        rect.top = 0;
                    }
                    if (this.f1531f) {
                        if (itemCount - i <= (itemCount % this.f1526a == 0 ? this.f1526a : itemCount % this.f1526a)) {
                            rect.bottom = this.f1527b;
                        } else {
                            rect.bottom = 0;
                        }
                    } else {
                        rect.bottom = 0;
                    }
                } else {
                    rect.left = (this.f1527b * i2) / this.f1526a;
                    rect.right = this.f1527b - (((i2 + 1) * this.f1527b) / this.f1526a);
                    if (i >= this.f1526a && this.f1530e) {
                        rect.top = this.f1527b;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GridSpacingItemDecoration(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.f1530e = true;
        this.f1531f = true;
        this.f1526a = i2;
        this.f1527b = i3;
        this.f1528c = z;
        this.f1529d = i;
        this.f1530e = z2;
        this.f1531f = z3;
    }
}

