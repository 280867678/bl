package com.example.boluouitest2.comod.baselib.view.tag;



import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.boluouitest2.Adapter.TagAdapter;
import com.example.boluouitest2.R;


import java.util.HashSet;
import java.util.Set;


/* loaded from: classes.dex */
public class TagFlowLayout extends FlowLayout implements TagAdapter.AbstractC4332a {

    /* renamed from: g */
    public TagAdapter f1783g;

    /* renamed from: h */
    public int f1784h;

    /* renamed from: i */
    public Set<Integer> f1785i;

    /* renamed from: j */
    public AbstractC0917b f1786j;

    /* renamed from: k */
    public AbstractC0918c f1787k;

    /* renamed from: com.comod.baselib.view.tag.TagFlowLayout$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0916a implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ TagView f1788b;

        /* renamed from: c */
        public final /* synthetic */ int f1789c;

        public View$OnClickListenerC0916a(TagView tagView, int i) {
            this.f1788b = tagView;
            this.f1789c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TagFlowLayout.this.m20000a(this.f1788b, this.f1789c);
            if (TagFlowLayout.this.f1787k != null) {
                TagFlowLayout.this.f1787k.m19998a(this.f1788b, this.f1789c, TagFlowLayout.this);
            }
        }
    }

    /* renamed from: com.comod.baselib.view.tag.TagFlowLayout$b */
    /* loaded from: classes.dex */
    public interface AbstractC0917b {
        /* renamed from: a */
        void mo9898a(Set<Integer> set);
    }

    /* renamed from: com.comod.baselib.view.tag.TagFlowLayout$c */
    /* loaded from: classes.dex */
    public interface AbstractC0918c {
        /* renamed from: a */
        boolean m19998a(View view, int i, FlowLayout flowLayout);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1784h = -1;
        this.f1785i = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f1784h = obtainStyledAttributes.getInt(R.styleable.TagFlowLayout_max_select, -1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    public final void m19999b(int i, TagView tagView) {
        tagView.setChecked(false);
        this.f1783g.m9010b(i, tagView.getTagView());
    }

    public TagAdapter getAdapter() {
        return this.f1783g;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f1785i);
    }

    @Override // com.comod.baselib.view.tag.FlowLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != View.GONE && tagView.getTagView().getVisibility() == View.GONE) {
                tagView.setVisibility(View.GONE);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String string = bundle.getString("key_choose_pos");
            if (!TextUtils.isEmpty(string)) {
                for (String str : string.split("\\|")) {
                    int parseInt = Integer.parseInt(str);
                    this.f1785i.add(Integer.valueOf(parseInt));
                    TagView tagView = (TagView) getChildAt(parseInt);
                    if (tagView != null) {
                        m20004a(parseInt, tagView);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable("key_default"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        String str = "";
        if (this.f1785i.size() > 0) {
            for (Integer num : this.f1785i) {
                str = str + num.intValue() + "|";
            }
            str = str.substring(0, str.length() - 1);
        }
        bundle.putString("key_choose_pos", str);
        return bundle;
    }

    public void setAdapter(TagAdapter aVar) {
        this.f1783g = aVar;
        this.f1783g.setOnDataChangedListener(this);
        this.f1785i.clear();
        m20005a();
    }

    public void setMaxSelectCount(int i) {
        if (this.f1785i.size() > i) {
            Log.w("TagFlowLayout", "you has already select more than " + i + " views , so it will be clear .");
            this.f1785i.clear();
        }
        this.f1784h = i;
    }

    public void setOnSelectListener(AbstractC0917b bVar) {
        this.f1786j = bVar;
    }

    public void setOnTagClickListener(AbstractC0918c cVar) {
        this.f1787k = cVar;
    }

    /* renamed from: a */
    public final void m20005a() {
        removeAllViews();
        TagAdapter aVar = this.f1783g;
        HashSet<Integer> b = aVar.m9011b();
        for (int i = 0; i < aVar.m9016a(); i++) {
            View a = aVar.mo9012a(this, i, aVar.m9015a(i));
            TagView tagView = new TagView(getContext());
            a.setDuplicateParentStateEnabled(true);
            if (a.getLayoutParams() != null) {
                tagView.setLayoutParams(a.getLayoutParams());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(m20003a(getContext(), 5.0f), m20003a(getContext(), 5.0f), m20003a(getContext(), 5.0f), m20003a(getContext(), 5.0f));
                tagView.setLayoutParams(marginLayoutParams);
            }
            a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            tagView.addView(a);
            addView(tagView);
            if (b.contains(Integer.valueOf(i))) {
                m20004a(i, tagView);
            }
            if (this.f1783g.m9013a(i, (int) aVar.m9015a(i))) {
                m20004a(i, tagView);
            }
            a.setClickable(false);
            tagView.setOnClickListener(new View$OnClickListenerC0916a(tagView, i));
        }
        this.f1785i.addAll(b);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m20004a(int i, TagView tagView) {
        tagView.setChecked(true);
        this.f1783g.m9014a(i, tagView.getTagView());
    }

    /* renamed from: a */
    public final void m20000a(TagView tagView, int i) {
        if (tagView.isChecked()) {
            m19999b(i, tagView);
            this.f1785i.remove(Integer.valueOf(i));
        } else if (this.f1784h == 1 && this.f1785i.size() == 1) {
            Integer next = this.f1785i.iterator().next();
            m19999b(next.intValue(), (TagView) getChildAt(next.intValue()));
            m20004a(i, tagView);
            this.f1785i.remove(next);
            this.f1785i.add(Integer.valueOf(i));
        } else if (this.f1784h <= 0 || this.f1785i.size() < this.f1784h) {
            m20004a(i, tagView);
            this.f1785i.add(Integer.valueOf(i));
        } else {
            return;
        }
        AbstractC0917b bVar = this.f1786j;
        if (bVar != null) {
            bVar.mo9898a(new HashSet(this.f1785i));
        }
    }

    /* renamed from: a */
    public static int m20003a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}

