package com.example.boluouitest2.ViewHelper;

import android.content.Context;

import com.example.boluouitest2.R;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

public class C4323g0 {


    public static ClassicsHeader m9140a(Context context, int i, int i2, int i3) {
        ClassicsHeader classicsHeader = new ClassicsHeader(context);
        classicsHeader.setPrimaryColor(i);
        classicsHeader.setAccentColor(context.getResources().getColor(i2));
        classicsHeader.setBackgroundColor(context.getResources().getColor(i3));
        classicsHeader.setEnableLastTime(true);
        classicsHeader.setTextSizeTitle(12.0f);
        classicsHeader.setTextSizeTime(11.0f);
        classicsHeader.setElevation(15.0f);
        classicsHeader.setTextTimeMarginTop(15.0f);
        return classicsHeader;
    }

    /* renamed from: b */
    public static ClassicsHeader m9139b(Context context) {
        return m9140a(context, R.mipmap.icon_down_arrow, R.color.color_b4, R.color.transparent);
    }

    /* renamed from: a */
    public static BallPulseFooter m9141a(Context context) {
        BallPulseFooter a = new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale);
        a.setNormalColor(context.getResources().getColor(R.color.primary_color));
        return a;
    }


}
