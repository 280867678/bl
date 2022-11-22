package com.example.boluouitest2.comod.baselib.view.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.boluouitest2.comod.baselib.view.magicindicator.IMeasurablePagerTitleView;
import com.example.boluouitest2.util.UIUtil;

public class SimplePagerTitleView extends AppCompatTextView implements IMeasurablePagerTitleView {


    /* renamed from: b */
    public int f1908b;

    /* renamed from: c */
    public int f1909c;

    public SimplePagerTitleView(Context context) {
        super(context, null);
        m19966a(context);
    }

    /* renamed from: a */
    public void mo8978a(int i, int i2, float f, boolean z) {
    }

    /* renamed from: a */
    public final void m19966a(Context context) {
        setGravity(17);
        int a = UIUtil.m8988a(context, 10.0d);
        setPadding(a, 0, a, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    /* renamed from: b */
    public void mo8977b(int i, int i2) {
        setTextColor(this.f1908b);
    }

    /* renamed from: b */
    public void mo8976b(int i, int i2, float f, boolean z) {
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IMeasurablePagerTitleView
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IMeasurablePagerTitleView
    public int getContentLeft() {
        String str;
        String[] split;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            str = "";
            for (String str2 : getText().toString().split("\\n")) {
                if (str2.length() > str.length()) {
                    str = str2;
                }
            }
        } else {
            str = getText().toString();
        }
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IMeasurablePagerTitleView
    public int getContentRight() {
        String str;
        String[] split;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            str = "";
            for (String str2 : getText().toString().split("\\n")) {
                if (str2.length() > str.length()) {
                    str = str2;
                }
            }
        } else {
            str = getText().toString();
        }
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.IMeasurablePagerTitleView
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.f1909c;
    }

    public int getSelectedColor() {
        return this.f1908b;
    }

    public void setNormalColor(int i) {
        this.f1909c = i;
    }

    public void setSelectedColor(int i) {
        this.f1908b = i;
    }

    /* renamed from: a */
    public void mo8979a(int i, int i2) {
        setTextColor(this.f1909c);
    }


}
