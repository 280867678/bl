package com.example.boluouitest2.util;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: e.f.a.d.u */
/* loaded from: classes.dex */
public class LayoutParamsUtil {
    /* renamed from: a */
    public static void m9077a(View view, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = (i * i3) / i2;
    }
}
