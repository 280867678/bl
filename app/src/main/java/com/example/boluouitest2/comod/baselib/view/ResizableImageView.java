package com.example.boluouitest2.comod.baselib.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes.dex */
public class ResizableImageView extends AppCompatImageView {
    public ResizableImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int size = View.MeasureSpec.getSize(i);
            setMeasuredDimension(size, (int) Math.ceil((size * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth()));
            return;
        }
        super.onMeasure(i, i2);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
