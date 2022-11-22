package com.example.boluouitest2.util;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class CustomLayoutParamsUtil {

    /* renamed from: a */
    public static void m9473a(Context context, ImageView imageView) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = ((ScreenUtil.m9202b(context) - (DpUtil.m9101a(context, 12) * 2)) * 9) / 16;
        imageView.setLayoutParams(layoutParams);
    }


    /* renamed from: a */
    public static void m9474a(Context context, View view) {
        LayoutParamsUtil.m9077a(view, ScreenUtil.m9202b(context), 800, 451);
    }


    /* renamed from: b */
    public static void m9472b(Context context, ImageView imageView) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (((ScreenUtil.m9202b(context) - (DpUtil.m9101a(context, 10) * 3)) / 2) * 10) / 16;
        imageView.setLayoutParams(layoutParams);
    }



}
