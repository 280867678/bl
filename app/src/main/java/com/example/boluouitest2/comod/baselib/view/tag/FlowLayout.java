package com.example.boluouitest2.comod.baselib.view.tag;



import android.content.Context;
import android.content.res.TypedArray;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.text.TextUtilsCompat;

import com.example.boluouitest2.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: b */
    public List<List<View>> f1778b;

    /* renamed from: c */
    public List<Integer> f1779c;

    /* renamed from: d */
    public List<Integer> f1780d;

    /* renamed from: e */
    public int f1781e;

    /* renamed from: f */
    public List<View> f1782f;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1778b = new ArrayList();
        this.f1779c = new ArrayList();
        this.f1780d = new ArrayList();
        this.f1782f = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f1781e = obtainStyledAttributes.getInt(R.styleable.TagFlowLayout_tag_gravity, -1);
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            if (this.f1781e == -1) {
                this.f1781e = 1;
            } else {
                this.f1781e = -1;
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1778b.clear();
        this.f1779c.clear();
        this.f1780d.clear();
        this.f1782f.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != View.GONE) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i6 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.f1779c.add(Integer.valueOf(i5));
                    this.f1778b.add(this.f1782f);
                    this.f1780d.add(Integer.valueOf(i6));
                    i5 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.f1782f = new ArrayList();
                    i6 = 0;
                }
                i6 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i5 = Math.max(i5, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.f1782f.add(childAt);
            }
        }
        this.f1779c.add(Integer.valueOf(i5));
        this.f1780d.add(Integer.valueOf(i6));
        this.f1778b.add(this.f1782f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f1778b.size();
        int i8 = paddingTop;
        int i9 = paddingLeft;
        int i10 = 0;
        while (i10 < size) {
            this.f1782f = this.f1778b.get(i10);
            int intValue = this.f1779c.get(i10).intValue();
            int intValue2 = this.f1780d.get(i10).intValue();
            int i11 = this.f1781e;
            if (i11 == -1) {
                i9 = getPaddingLeft();
            } else if (i11 == 0) {
                i9 = ((width - intValue2) / 2) + getPaddingLeft();
            } else if (i11 == 1) {
                i9 = (width - (intValue2 + getPaddingLeft())) - getPaddingRight();
                Collections.reverse(this.f1782f);
            }
            for (int i12 = 0; i12 < this.f1782f.size(); i12++) {
                View view = this.f1782f.get(i12);
                if (view.getVisibility() != View.GONE) {
                    MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) view.getLayoutParams();
                    int i13 = marginLayoutParams2.leftMargin + i9;
                    int i14 = marginLayoutParams2.topMargin + i8;
                    view.layout(i13, i14, view.getMeasuredWidth() + i13, view.getMeasuredHeight() + i14);
                    i9 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            i8 += intValue;
            i10++;
            i9 = i9;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == View.GONE) {
                if (i7 == childCount - 1) {
                    i3 = Math.max(i4, i3);
                    i6 += i5;
                }
                size2 = size2;
            } else {
                measureChild(childAt, i, i2);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                size2 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i8 = i4 + measuredWidth;
                if (i8 > (size - getPaddingLeft()) - getPaddingRight()) {
                    i3 = Math.max(i3, i4);
                    i6 += i5;
                } else {
                    measuredHeight = Math.max(i5, measuredHeight);
                    measuredWidth = i8;
                }
                if (i7 == childCount - 1) {
                    i3 = Math.max(measuredWidth, i3);
                    i6 += measuredHeight;
                }
                i5 = measuredHeight;
                i4 = measuredWidth;
            }
        }
        if (mode != 1073741824) {
            size = getPaddingRight() + i3 + getPaddingLeft();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? size2 : i6 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }
}

