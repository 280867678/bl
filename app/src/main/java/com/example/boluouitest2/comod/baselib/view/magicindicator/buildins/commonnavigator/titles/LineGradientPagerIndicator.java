package com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.titles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RectF;
import android.graphics.Shader;

public class LineGradientPagerIndicator  extends LinePagerIndicator {


    /* renamed from: n */
    public int[] f1858n;

    /* renamed from: o */
    public float[] f1859o;

    public LineGradientPagerIndicator(Context context) {
        super(context);
    }

    @Override // com.comod.view.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        float[] fArr;
        int[] iArr = this.f1858n;
        if (!(iArr == null || (fArr = this.f1859o) == null)) {
            RectF rectF = this.f1871m;
            this.f1868j.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, iArr, fArr, Shader.TileMode.MIRROR));
        }
        super.onDraw(canvas);
    }

    public void setGradientColorList(int[] iArr) {
        this.f1858n = iArr;
    }

    public void setGradientPositionList(float[] fArr) {
        this.f1859o = fArr;
    }



}
