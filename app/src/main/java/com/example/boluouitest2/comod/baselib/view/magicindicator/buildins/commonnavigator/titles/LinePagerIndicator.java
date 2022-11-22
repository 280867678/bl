package com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.PositionData;
import com.example.boluouitest2.comod.baselib.view.magicindicator.util.ArgbEvaluatorHolder;
import com.example.boluouitest2.comod.baselib.view.magicindicator.util.FragmentContainerHelper;
import com.example.boluouitest2.util.UIUtil;

import java.util.Arrays;
import java.util.List;

public class LinePagerIndicator extends View implements IPagerIndicator {


    /* renamed from: b */
    public int f1860b;

    /* renamed from: e */
    public float f1863e;

    /* renamed from: f */
    public float f1864f;

    /* renamed from: g */
    public float f1865g;

    /* renamed from: h */
    public float f1866h;

    /* renamed from: i */
    public float f1867i;

    /* renamed from: j */
    public Paint f1868j;

    /* renamed from: k */
    public List<PositionData> f1869k;

    /* renamed from: l */
    public List<Integer> f1870l;

    /* renamed from: c */
    public Interpolator f1861c = new LinearInterpolator();

    /* renamed from: d */
    public Interpolator f1862d = new LinearInterpolator();

    /* renamed from: m */
    public RectF f1871m = new RectF();

    public LinePagerIndicator(Context context) {
        super(context);
        m19978a(context);
    }

    /* renamed from: a */
    public final void m19978a(Context context) {
        this.f1868j = new Paint(1);
        this.f1868j.setStyle(Paint.Style.FILL);
        this.f1864f = UIUtil.m8988a(context, 3.0d);
        this.f1866h = UIUtil.m8988a(context, 10.0d);
    }

    public List<Integer> getColors() {
        return this.f1870l;
    }

    public Interpolator getEndInterpolator() {
        return this.f1862d;
    }

    public float getLineHeight() {
        return this.f1864f;
    }

    public float getLineWidth() {
        return this.f1866h;
    }

    public int getMode() {
        return this.f1860b;
    }

    public Paint getPaint() {
        return this.f1868j;
    }

    public float getRoundRadius() {
        return this.f1867i;
    }

    public Interpolator getStartInterpolator() {
        return this.f1861c;
    }

    public float getXOffset() {
        return this.f1865g;
    }

    public float getYOffset() {
        return this.f1863e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f1871m;
        float f = this.f1867i;
        canvas.drawRoundRect(rectF, f, f, this.f1868j);
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6 = 0;           /////////////////////////////////////////////////////////////改
        int i3 = 0;                         /////////////////////////////////////////////////////////////改
        List<PositionData> list = this.f1869k;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.f1870l;
            if (list2 != null && list2.size() > 0) {
                this.f1868j.setColor(ArgbEvaluatorHolder.m8989a(f, this.f1870l.get(Math.abs(i) % this.f1870l.size()).intValue(), this.f1870l.get(Math.abs(i + 1) % this.f1870l.size()).intValue()));
            }
            PositionData a = FragmentContainerHelper.m9009a(this.f1869k, i);
            PositionData a2 = FragmentContainerHelper.m9009a(this.f1869k, i + 1);
            int i4 = this.f1860b;
            if (i4 == 0) {
                f6 = this.f1865g;
                f5 = a.f13256a + f6;
                f4 = a2.f13256a + f6;
                f2 = a.f13258c - f6;
                i3 = a2.f13258c;
            } else if (i4 == 1) {
                f6 = this.f1865g;
                f5 = a.f13260e + f6;
                f4 = a2.f13260e + f6;
                f2 = a.f13262g - f6;
                i3 = a2.f13262g;
            } else {
                f5 = a.f13256a + ((a.m8974b() - this.f1866h) / 2.0f);
                f4 = a2.f13256a + ((a2.m8974b() - this.f1866h) / 2.0f);
                f2 = ((a.m8974b() + this.f1866h) / 2.0f) + a.f13256a;
                f3 = ((a2.m8974b() + this.f1866h) / 2.0f) + a2.f13256a;
                this.f1871m.left = f5 + ((f4 - f5) * this.f1861c.getInterpolation(f));
                this.f1871m.right = f2 + ((f3 - f2) * this.f1862d.getInterpolation(f));
                this.f1871m.top = (getHeight() - this.f1864f) - this.f1863e;
                this.f1871m.bottom = getHeight() - this.f1863e;
                invalidate();
            }
            f3 = i3 - f6;
            this.f1871m.left = f5 + ((f4 - f5) * this.f1861c.getInterpolation(f));
            this.f1871m.right = f2 + ((f3 - f2) * this.f1862d.getInterpolation(f));
            this.f1871m.top = (getHeight() - this.f1864f) - this.f1863e;
            this.f1871m.bottom = getHeight() - this.f1863e;
            invalidate();
        }
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerIndicator
    public void onPageSelected(int i) {
    }

    public void setColors(Integer... numArr) {
        this.f1870l = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f1862d = interpolator;
        if (this.f1862d == null) {
            this.f1862d = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f) {
        this.f1864f = f;
    }

    public void setLineWidth(float f) {
        this.f1866h = f;
    }

    public void setMode(int i) {
        if (i == 2 || i == 0 || i == 1) {
            this.f1860b = i;
            return;
        }
        throw new IllegalArgumentException("mode " + i + " not supported.");
    }

    public void setRoundRadius(float f) {
        this.f1867i = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f1861c = interpolator;
        if (this.f1861c == null) {
            this.f1861c = new LinearInterpolator();
        }
    }

    public void setXOffset(float f) {
        this.f1865g = f;
    }

    public void setYOffset(float f) {
        this.f1863e = f;
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IPagerIndicator
    /* renamed from: a */
    public void mo8980a(List<PositionData> list) {
        this.f1869k = list;
    }



}
