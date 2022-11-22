package com.example.boluouitest2.util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import androidx.viewpager.widget.ViewPager;

import com.example.boluouitest2.R;
import com.example.boluouitest2.TitleView.ScaleTransitionPagerTitleView;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.indicators.DotPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.titles.LineGradientPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

public class CustomMagicIndicatorUtil {

    /* compiled from: CustomMagicIndicatorUtil.java */
    /* renamed from: e.c.a.k.m$a */
    /* loaded from: classes.dex */
    public static class C4240a extends SimplePagerTitleView {
        public C4240a(Context context) {
            super(context);
        }

        @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
        /* renamed from: a */
        public void mo8979a(int i, int i2) {
            super.mo8979a(i, i2);
            setTypeface(Typeface.DEFAULT);
        }

        @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
        /* renamed from: b */
        public void mo8977b(int i, int i2) {
            super.mo8977b(i, i2);
            setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    /* renamed from: a */
    public static SimplePagerTitleView m9466a(Context context, final int i, List<String> list, final ViewPager viewPager, int i2, int i3, int i4) {
        C4240a aVar = new C4240a(context);
        aVar.setText(list.get(i));
        aVar.setTextSize(i2);
        aVar.setNormalColor(i3);
        aVar.setSelectedColor(i4);
        aVar.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.k.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                viewPager.setCurrentItem(i);
            }
        });
        return aVar;
    }

    /* renamed from: b */
    public static LineGradientPagerIndicator m9464b(Context context) {
        return MagicIndicatorUtil.m9073a(context, UIUtil.m8988a(context, 3.0d), UIUtil.m8988a(context, 3.0d), new int[]{context.getResources().getColor(R.color.color_fd8f2e), context.getResources().getColor(R.color.color_f0cb1c)}, new float[]{0.0f, 1.0f});
    }



//
//    /* renamed from: a */
    public static DotPagerIndicator m9469a(Context context, int i) {
        DotPagerIndicator dotPagerIndicator = new DotPagerIndicator(context);
        dotPagerIndicator.setColor(i);
        dotPagerIndicator.setXOffset(5.0f);
        dotPagerIndicator.setYOffset(15.0f);
        return dotPagerIndicator;
    }
//
//    /* renamed from: a */
    public static IPagerIndicator m9470a(Context context) {
        return m9468a(context, UIUtil.m8988a(context, 20.0d), UIUtil.m8988a(context, 3.0d), UIUtil.m8988a(context, 3.0d), new int[]{context.getResources().getColor(R.color.color_fd8f2e), context.getResources().getColor(R.color.color_f0cb1c)}, new float[]{0.0f, 1.0f});
    }
//
//    /* renamed from: a */
    public static IPagerIndicator m9468a(Context context, int i, int i2, int i3, int[] iArr, float[] fArr) {
        LineGradientPagerIndicator lineGradientPagerIndicator = new LineGradientPagerIndicator(context);
        lineGradientPagerIndicator.setMode(2);
        lineGradientPagerIndicator.setLineHeight(i2);
        lineGradientPagerIndicator.setLineWidth(i);
        lineGradientPagerIndicator.setRoundRadius(i3);
        lineGradientPagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        lineGradientPagerIndicator.setEndInterpolator(new DecelerateInterpolator(1.5f));
        lineGradientPagerIndicator.setGradientColorList(iArr);
        lineGradientPagerIndicator.setGradientPositionList(fArr);
        return lineGradientPagerIndicator;
    }
//
    /* renamed from: a */
    public static ScaleTransitionPagerTitleView m9467a(Context context, int i, List<String> list, ViewPager viewPager) {
        return MagicIndicatorUtil.m9072a(context, i, list, viewPager, 16, context.getResources().getColor(R.color.color_666), context.getResources().getColor(R.color.color_333));
    }


}
