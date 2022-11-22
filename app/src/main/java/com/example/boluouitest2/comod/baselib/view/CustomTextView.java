package com.example.boluouitest2.comod.baselib.view;

import android.content.Context;
import android.graphics.Typeface;

import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {
    public CustomTextView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m20144a(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/DIN-Medium-2.otf"));
    }

    public CustomTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20144a(context);
    }
}
