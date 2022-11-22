package com.example.boluouitest2.comod.baselib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.boluouitest2.R;

import java.util.ArrayList;


public class MultipleStatusLayout extends FrameLayout {

    /* renamed from: q */
    public static final FrameLayout.LayoutParams f1557q = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: b */
    public int f1558b;

    /* renamed from: c */
    public int f1559c;

    /* renamed from: d */
    public int f1560d;

    /* renamed from: e */
    public int f1561e;

    /* renamed from: f */
    public View f1562f;

    /* renamed from: g */
    public View f1563g;

    /* renamed from: h */
    public View f1564h;

    /* renamed from: i */
    public View f1565i;

    /* renamed from: j */
    public View f1566j;

    /* renamed from: k */
    public int f1567k;

    /* renamed from: l */
    public LayoutInflater f1568l;

    /* renamed from: m */
    public int f1569m;

    /* renamed from: n */
    public final ArrayList<Integer> f1570n;

    /* renamed from: o */
    public View.OnClickListener f1571o;

    /* renamed from: p */
    public Context f1572p;

    public MultipleStatusLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m20139a(int i, ViewGroup.LayoutParams layoutParams) {
        m20138a(m20140a(i), layoutParams);
    }

    /* renamed from: b */
    public final void m20133b(int i, ViewGroup.LayoutParams layoutParams) {
        try {
            m20132b(m20140a(i), layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public final void m20131c() {
        m20139a(this.f1558b, f1557q);
    }

    /* renamed from: d */
    public final void m20128d() {
        m20133b(this.f1559c, f1557q);
    }

    /* renamed from: e */
    public final void m20125e() {
        m20130c(this.f1560d, f1557q);
    }

    /* renamed from: f */
    public final void m20124f() {
        m20127d(this.f1561e, f1557q);
    }

    public int getViewStatus() {
        return this.f1569m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m20136a(this.f1562f, this.f1564h, this.f1563g, this.f1565i);
        this.f1562f = null;
        this.f1564h = null;
        this.f1563g = null;
        this.f1565i = null;
        if (!this.f1570n.isEmpty()) {
            this.f1570n.clear();
        }
        if (this.f1571o != null) {
            this.f1571o = null;
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        m20141a();
    }

    public void setOnRetryClickListener(View.OnClickListener onClickListener) {
        this.f1571o = onClickListener;
    }

    public MultipleStatusLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public final void m20138a(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            m20137a(view, "Empty view is null!");
            this.f1569m = 2;
            if (this.f1562f == null) {
                this.f1562f = view;
                View findViewById = this.f1562f.findViewById(R.id.empty_retry_view);
                if (!(this.f1571o == null || findViewById == null)) {
                    findViewById.setOnClickListener(this.f1571o);
                }
                this.f1570n.add(Integer.valueOf(this.f1562f.getId()));
                addView(this.f1562f, 0, layoutParams);
            }
            m20134b(this.f1562f.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public final void m20130c(int i, ViewGroup.LayoutParams layoutParams) {
        m20129c(m20140a(i), layoutParams);
    }

    /* renamed from: d */
    public final void m20127d(int i, ViewGroup.LayoutParams layoutParams) {
        m20126d(m20140a(i), layoutParams);
    }

    public MultipleStatusLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1570n = new ArrayList<>();
        this.f1572p = context;
        this.f1568l = LayoutInflater.from(this.f1572p);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MultipleStatusLayout, i, 0);
        if (obtainStyledAttributes != null) {
            this.f1558b = obtainStyledAttributes.getResourceId(R.styleable.MultipleStatusLayout_emptyView, R.layout.layout_empty_view);
            this.f1559c = obtainStyledAttributes.getResourceId(R.styleable.MultipleStatusLayout_errorView, R.layout.layout_error_view);
            this.f1560d = obtainStyledAttributes.getResourceId(R.styleable.MultipleStatusLayout_loadingView, R.layout.layout_loading_view);
            this.f1561e = obtainStyledAttributes.getResourceId(R.styleable.MultipleStatusLayout_noNetworkView, R.layout.layout_no_network_view);
            this.f1567k = obtainStyledAttributes.getResourceId(R.styleable.MultipleStatusLayout_contentView, -1);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    public final void m20132b(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            m20137a(view, "Error view is null!");
            this.f1569m = 3;
            if (this.f1563g == null) {
                this.f1563g = view;
                View findViewById = this.f1563g.findViewById(R.id.error_retry_view);
                if (!(this.f1571o == null || findViewById == null)) {
                    findViewById.setOnClickListener(this.f1571o);
                }
                this.f1570n.add(Integer.valueOf(this.f1563g.getId()));
                addView(this.f1563g, 0, layoutParams);
            }
            m20134b(this.f1563g.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public final void m20129c(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            m20137a(view, "Loading view is null!");
            this.f1569m = 1;
            if (this.f1564h == null) {
                this.f1564h = view;
                this.f1570n.add(Integer.valueOf(this.f1564h.getId()));
                addView(this.f1564h, 0, layoutParams);
            }
            m20134b(this.f1564h.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public final void m20126d(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            m20137a(view, "No network view is null!");
            this.f1569m = 4;
            if (this.f1565i == null) {
                this.f1565i = view;
                View findViewById = this.f1565i.findViewById(R.id.no_network_retry_view);
                if (!(this.f1571o == null || findViewById == null)) {
                    findViewById.setOnClickListener(this.f1571o);
                }
                this.f1570n.add(Integer.valueOf(this.f1565i.getId()));
                addView(this.f1565i, 0, layoutParams);
            }
            m20134b(this.f1565i.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m20141a() {
        try {
            this.f1569m = 0;
            if (this.f1566j == null && this.f1567k != -1) {
                this.f1566j = this.f1568l.inflate(this.f1567k, (ViewGroup) null);
                addView(this.f1566j, 0, f1557q);
            }
            m20135b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m20135b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.setVisibility(this.f1570n.contains(Integer.valueOf(childAt.getId())) ? View.GONE : View.VISIBLE);
        }
    }

    /* renamed from: b */
    public final void m20134b(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            childAt.setVisibility(childAt.getId() == i ? View.VISIBLE : View.GONE);
        }
    }

    /* renamed from: a */
    public final View m20140a(int i) {
        LayoutInflater layoutInflater = this.f1568l;
        if (layoutInflater != null) {
            return layoutInflater.inflate(i, (ViewGroup) null);
        }
        return null;
    }

    /* renamed from: a */
    public final void m20137a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    /* renamed from: a */
    public final void m20136a(View... viewArr) {
        if (viewArr != null) {
            try {
                for (View view : viewArr) {
                    if (view != null) {
                        removeView(view);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}