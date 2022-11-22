package com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.PositionData;
import com.example.boluouitest2.comod.baselib.view.magicindicator.util.FragmentContainerHelper;
import com.example.boluouitest2.util.UIUtil;

import java.util.List;

public class DotPagerIndicator extends View implements IPagerIndicator {


    /* renamed from: b */
    public List<PositionData> f1842b;

    /* renamed from: c */
    public float f1843c;

    /* renamed from: d */
    public float f1844d;

    /* renamed from: e */
    public float f1845e;

    /* renamed from: f */
    public float f1846f;

    /* renamed from: g */
    public float f1847g;

    /* renamed from: h */
    public float f1848h;

    /* renamed from: i */
    public float f1849i;

    /* renamed from: j */
    public float f1850j;

    /* renamed from: k */
    public float f1851k;

    /* renamed from: l */
    public float f1852l;

    /* renamed from: m */
    public Paint f1853m;

    /* renamed from: n */
    public Interpolator f1854n = new AccelerateInterpolator();

    /* renamed from: o */
    public Interpolator f1855o = new DecelerateInterpolator();

    /* renamed from: p */
    public boolean f1856p;

    /* renamed from: q */
    public int f1857q;

    public DotPagerIndicator(Context context) {
        super(context);
        m19979a(context);
    }

    /* renamed from: a */
    public final void m19979a(Context context) {
        this.f1853m = new Paint(1);
        this.f1853m.setStyle(Paint.Style.FILL);
        this.f1851k = UIUtil.m8988a(context, 6.0d);
        this.f1852l = UIUtil.m8988a(context, 3.0d);
    }

    public int getColor() {
        return this.f1857q;
    }

    public float getMaxCircleRadius() {
        return this.f1851k;
    }

    public float getMinCircleRadius() {
        return this.f1852l;
    }

    public float getXOffset() {
        return this.f1850j;
    }

    public float getYOffset() {
        return this.f1849i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f1853m.setColor(this.f1857q);
        canvas.drawCircle(this.f1844d - this.f1850j, this.f1847g + this.f1849i, this.f1843c, this.f1853m);
        canvas.drawCircle(this.f1846f - this.f1850j, this.f1848h + this.f1849i, this.f1845e, this.f1853m);
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        List<PositionData> list = this.f1842b;
        if (list != null && !list.isEmpty()) {
            PositionData a = FragmentContainerHelper.m9009a(this.f1842b, i);
            PositionData a2 = FragmentContainerHelper.m9009a(this.f1842b, i + 1);
            float f2 = a.f13262g;
            float f3 = a2.f13262g - f2;
            this.f1844d = (this.f1854n.getInterpolation(f) * f3) + f2;
            this.f1846f = f2 + (f3 * this.f1855o.getInterpolation(f));
            if (!this.f1856p) {
                this.f1856p = true;
                int i3 = a.f13261f;
                this.f1847g = i3;
                this.f1848h = i3;
            }
            float f4 = this.f1851k;
            this.f1843c = f4 + ((this.f1852l - f4) * this.f1855o.getInterpolation(f));
            float f5 = this.f1852l;
            this.f1845e = f5 + ((this.f1851k - f5) * this.f1854n.getInterpolation(f));
            invalidate();
        }
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerIndicator
    public void onPageSelected(int i) {
    }

    public void setColor(int i) {
        this.f1857q = i;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f1855o = interpolator;
        if (this.f1855o == null) {
            this.f1855o = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f) {
        this.f1851k = f;
    }

    public void setMinCircleRadius(float f) {
        this.f1852l = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f1854n = interpolator;
        if (this.f1854n == null) {
            this.f1854n = new AccelerateInterpolator();
        }
    }

    public void setXOffset(float f) {
        this.f1850j = f;
    }

    public void setYOffset(float f) {
        this.f1849i = f;
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerIndicator
    /* renamed from: a */
    public void mo8980a(List<PositionData> list) {
        this.f1842b = list;
    }

}
