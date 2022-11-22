package com.example.boluouitest2.TitleView;

import android.content.Context;

import com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import com.example.boluouitest2.comod.baselib.view.magicindicator.util.ArgbEvaluatorHolder;

public class ColorTransitionPagerTitleView extends SimplePagerTitleView {

    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
    /* renamed from: a */
    public void mo8979a(int i, int i2) {
    }

    @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
    /* renamed from: a */
    public void mo8978a(int i, int i2, float f, boolean z) {
        setTextColor(ArgbEvaluatorHolder.m8989a(f, this.f1909c, this.f1908b));
    }

    @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
    /* renamed from: b */
    public void mo8977b(int i, int i2) {
    }

    @Override // com.comod.view.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerTitleView
    /* renamed from: b */
    public void mo8976b(int i, int i2, float f, boolean z) {
        setTextColor(ArgbEvaluatorHolder.m8989a(f, this.f1908b, this.f1909c));
    }


}
