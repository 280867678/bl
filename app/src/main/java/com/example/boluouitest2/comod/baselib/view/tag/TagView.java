package com.example.boluouitest2.comod.baselib.view.tag;



import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class TagView extends FrameLayout implements Checkable {

    /* renamed from: c */
    public static final int[] f1791c = {16842912};

    /* renamed from: b */
    public boolean f1792b;

    public TagView(Context context) {
        super(context);
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f1792b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f1791c);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f1792b != z) {
            this.f1792b = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f1792b);
    }
}

