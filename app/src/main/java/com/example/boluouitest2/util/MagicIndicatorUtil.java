package com.example.boluouitest2.util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import androidx.viewpager.widget.ViewPager;

import com.example.boluouitest2.TitleView.ScaleTransitionPagerTitleView;
import com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.titles.LineGradientPagerIndicator;

import java.util.List;

public class MagicIndicatorUtil {

    /* compiled from: MagicIndicatorUtil.java */
    /* renamed from: e.f.a.d.x$a */
    /* loaded from: classes.dex */
    public static class C4328a extends ScaleTransitionPagerTitleView {
        public C4328a(Context context) {
            super(context);
        }

        @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView, com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
        /* renamed from: a */
        public void mo8979a(int i, int i2) {
            super.mo8979a(i, i2);
            setTypeface(Typeface.DEFAULT);
        }

        @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView, com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
        /* renamed from: b */
        public void mo8977b(int i, int i2) {
            super.mo8977b(i, i2);
            setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    /* renamed from: a */
    public static ScaleTransitionPagerTitleView m9072a(Context context, final int i, List<String> list, final ViewPager viewPager, int i2, int i3, int i4) {
        C4328a aVar = new C4328a(context);
        aVar.setText(list.get(i));
        aVar.setTextSize(i2);
        aVar.setNormalColor(i3);
        aVar.setSelectedColor(i4);
        aVar.setOnClickListener(new View.OnClickListener() { // from class: e.f.a.d.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                viewPager.setCurrentItem(i);
            }
        });
        return aVar;
    }



    /* renamed from: a */
    public static LineGradientPagerIndicator m9073a(Context context, int i, int i2, int[] iArr, float[] fArr) {
        LineGradientPagerIndicator lineGradientPagerIndicator = new LineGradientPagerIndicator(context);
        lineGradientPagerIndicator.setMode(1);
        lineGradientPagerIndicator.setLineHeight(i);
        lineGradientPagerIndicator.setRoundRadius(i2);
        lineGradientPagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        lineGradientPagerIndicator.setEndInterpolator(new DecelerateInterpolator(1.5f));
        lineGradientPagerIndicator.setGradientColorList(iArr);
        lineGradientPagerIndicator.setGradientPositionList(fArr);
        return lineGradientPagerIndicator;
    }





}
