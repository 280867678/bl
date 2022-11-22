package com.example.boluouitest2.TitleView;

import android.content.Context;
import android.graphics.Typeface;

public class ScaleTransitionPagerTitleView extends ColorTransitionPagerTitleView {

    /* renamed from: d */
    public float f1951d = 0.9f;

    public ScaleTransitionPagerTitleView(Context context) {
        super(context);
    }

    @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView, com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
    /* renamed from: a */
    public void mo8978a(int i, int i2, float f, boolean z) {
        super.mo8978a(i, i2, f, z);
        float f2 = this.f1951d;
        setScaleX(f2 + ((1.0f - f2) * f));
        float f3 = this.f1951d;
        setScaleY(f3 + ((1.0f - f3) * f));
        setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }

    @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView, com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
    /* renamed from: b */
    public void mo8976b(int i, int i2, float f, boolean z) {
        super.mo8976b(i, i2, f, z);
        setScaleX(((this.f1951d - 1.0f) * f) + 1.0f);
        setScaleY(((this.f1951d - 1.0f) * f) + 1.0f);
        setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }

    public float getMinScale() {
        return this.f1951d;
    }

    public void setMinScale(float f) {
        this.f1951d = f;
    }


}
