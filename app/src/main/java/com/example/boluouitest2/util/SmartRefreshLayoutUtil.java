package com.example.boluouitest2.util;

import android.content.Context;

import com.example.boluouitest2.R;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

public class SmartRefreshLayoutUtil {

    /* renamed from: a */
    public static BallPulseFooter m9581a(Context context) {
//        BallPulseFooter a = new BallPulseFooter(context).m18512a(SpinnerStyle.f17376e);
        BallPulseFooter a = new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale);
//        a.m18513a(context.getResources().getColor(R.color.color_fcd935));
        a.setNormalColor(context.getResources().getColor(R.color.color_fcd935));
        return a;
    }



    /* renamed from: b */
    public static ClassicsHeader m9579b(Context context) {
        return m9580a(context, R.mipmap.icon_down_arrow, R.color.color_b4, R.color.transparent);
    }

    /* renamed from: a */
    public static ClassicsHeader m9580a(Context context, int i, int i2, int i3) {
        ClassicsHeader classicsHeader = new ClassicsHeader(context);
//        classicsHeader.m18494b(i);
//        classicsHeader.mo18496a(context.getResources().getColor(i2));
        classicsHeader.setBackgroundColor(context.getResources().getColor(i3));
//        classicsHeader.m18503a(true);
//        classicsHeader.m18493c(12.0f);
//        classicsHeader.m18502d(11.0f);
//        classicsHeader.m18497a(15.0f);
//        classicsHeader.m18495b(15.0f);
        return classicsHeader;
    }



}
