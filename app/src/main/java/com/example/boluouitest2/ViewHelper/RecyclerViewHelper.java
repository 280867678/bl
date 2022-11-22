package com.example.boluouitest2.ViewHelper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.boluouitest2.R;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.comod.baselib.view.MultipleStatusLayout;
import com.example.boluouitest2.comod.baselib.view.magicindicator.util.SpacesItemDecoration;
import com.example.boluouitest2.httpUtil.C4220b;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.C4326m;
import com.example.boluouitest2.util.ToastUtil;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public abstract class RecyclerViewHelper<T extends BaseListViewAdapter.C0890c> implements OnRefreshListener, OnRefreshLoadMoreListener {


    /* renamed from: e */
    /**
     * ShimmerRecyclerView
     */
    public ShimmerRecyclerView f13063e;

    /* renamed from: f */
    /**
     * SmartRefreshLayout
     */
    public SmartRefreshLayout f13064f;

    /* renamed from: g */
    public MultipleStatusLayout f13065g;

    /* renamed from: h */
    public BaseListViewAdapter<T> f13066h;

    /* renamed from: i */
    public RecyclerView.LayoutManager f13067i;

    /* renamed from: j */
    public Context f13068j;

    /* renamed from: k */
    public Dialog f13069k;

    /* renamed from: b */
    public boolean f13060b = false;

    /* renamed from: c */
    public int f13061c = 1;

    /* renamed from: d */
    public boolean f13062d = true;

    /* renamed from: l */
    public final HttpCallback f13070l = new C4252c();

    /* compiled from: RecyclerViewHelper.java */
    /* renamed from: e.c.a.k.z$a */
    /* loaded from: classes.dex */
    public class C4250a extends RecyclerView.OnScrollListener {
        public C4250a() {
        }

        @Override // android.support.p004v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // android.support.p004v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            try {
                if (RecyclerViewHelper.this.mo9351v() && RecyclerViewHelper.this.m9349x()) {
                    int i3 = 0;
                    if ((RecyclerViewHelper.this.f13067i instanceof GridLayoutManager) || (RecyclerViewHelper.this.f13067i instanceof LinearLayoutManager)) {
                        if (RecyclerViewHelper.this.f13067i instanceof GridLayoutManager) {
                            i3 = ((GridLayoutManager) RecyclerViewHelper.this.m9364i()).findLastVisibleItemPosition();
                        } else {
                            i3 = ((LinearLayoutManager) RecyclerViewHelper.this.m9364i()).findLastVisibleItemPosition();
                        }
                    }
                    if (RecyclerViewHelper.this.f13066h.getItemCount() - i3 < RecyclerViewHelper.this.m9362k()) {
                        RecyclerViewHelper.this.m9393B();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: RecyclerViewHelper.java */
    /* renamed from: e.c.a.k.z$b */
    /* loaded from: classes.dex */
    public class C4251b extends BaseListViewAdapter<T> {
        public C4251b() {
        }

        @Override // com.comod.baselib.list.BaseListViewAdapter
        public VHDelegateImpl<T> createVHDelegate(int i) {
            return RecyclerViewHelper.this.mo9376b(i);
        }
    }

    /* compiled from: RecyclerViewHelper.java */
    /* renamed from: e.c.a.k.z$c */
    /* loaded from: classes.dex */
    public class C4252c extends HttpCallback {
        public C4252c() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
            try {
                RecyclerViewHelper.this.m9388G();
                RecyclerViewHelper.this.m9386I();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            try {
                if (RecyclerViewHelper.this.m9348y() && !TextUtils.isEmpty(str)) {
                    ToastUtil.m9104a(str);
                }
                RecyclerViewHelper.this.m9388G();
                RecyclerViewHelper.this.m9386I();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
            try {
                RecyclerViewHelper.this.m9388G();
                RecyclerViewHelper.this.m9385J();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            RecyclerViewHelper.this.m9388G();
            try {
                List<T> a = RecyclerViewHelper.this.mo9379a(str);
                if (RecyclerViewHelper.this.f13061c == 1) {
                    RecyclerViewHelper.this.f13066h.clear();
                }
                if (a != null && !a.isEmpty()) {
                    if (RecyclerViewHelper.this.m9352u()) {
                        RecyclerViewHelper.this.f13066h.addItemsNotifyAll(a);
                    } else {
                        RecyclerViewHelper.this.f13066h.addItems(a);
                    }
                    if (RecyclerViewHelper.this.mo9351v()) {
                        RecyclerViewHelper.m9368e(RecyclerViewHelper.this);
                    }
                } else if (RecyclerViewHelper.this.mo9351v()) {
                    RecyclerViewHelper.this.m9378a(false);
                }
                RecyclerViewHelper.this.m9387H();
            } catch (Exception e) {
                e.printStackTrace();
                RecyclerViewHelper.this.m9386I();
            }
        }
    }

    public RecyclerViewHelper(Context context, Activity activity) {
        try {
            this.f13068j = context;
            this.f13063e = (ShimmerRecyclerView) activity.findViewById(R.id.recyclerView);
            this.f13064f = (SmartRefreshLayout) activity.findViewById(R.id.smartRefreshLayout);
            this.f13065g = (MultipleStatusLayout) activity.findViewById(R.id.multipleStatusLayout);
            m9356q();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public static /* synthetic */ int m9368e(RecyclerViewHelper zVar) {
        int i = zVar.f13061c;
        zVar.f13061c = i + 1;
        return i;
    }

    /* renamed from: A */
    public void m9394A() {
        try {
            if (this.f13061c == 1 && this.f13066h.getItemCount() == 0) {
                if (m9347z()) {
                    C4326m.m9108a(this.f13068j, this.f13069k);
                } else if (this.f13063e.getLayoutReference() > 0) {
                    this.f13063e.showShimmerAdapter();
                } else if (this.f13065g != null) {
                    this.f13065g.m20125e();
                }
            }
            if (!m9353t()) {
                m9388G();
                try {
                    List<T> a = mo9379a("");
                    if (a != null && !a.isEmpty()) {
                        this.f13066h.refreshAddItems(a);
                    }
                    m9387H();
                } catch (Exception e) {
                    e.printStackTrace();
                    m9386I();
                }
            } else if (m9350w()) {
                ((PostRequest) C4220b.m9794b().m9793b(mo9377b(), mo9357p()).params(m9383a(this.f13061c))).execute(this.f13070l);
            } else {
                ((GetRequest) C4220b.m9794b().m9796a(mo9377b(), mo9357p()).params(m9383a(this.f13061c))).execute(this.f13070l);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: B */
    public final void m9393B() {
        try {
            if (!this.f13060b && this.f13062d) {
                this.f13060b = true;
                m9394A();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: C */
    public void m9392C() {
        HttpUtil.m9735b(mo9357p());
    }

    /* renamed from: D */
    public void mo9391D() {
    }

    /* renamed from: E */
    public void m9390E() {
        try {
            m9389F();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: F */
    public void m9389F() {
        try {
            if (!this.f13060b) {
                this.f13060b = true;
                this.f13061c = 1;
                mo9391D();
                if (mo9351v()) {
                    m9378a(true);
                }
                m9394A();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: G */
    public void m9388G() {
        try {
            this.f13060b = false;
            this.f13065g.m20141a();
            this.f13064f.finishRefresh();
            if (mo9351v()) {
                this.f13064f.finishLoadMore();
            }
            if (this.f13061c != 1 || this.f13066h.getItemCount() != 0) {
                return;
            }
            if (m9347z()) {
                C4326m.m9110a(this.f13069k);
            } else if (this.f13063e.getLayoutReference() > 0) {
                this.f13063e.hideShimmerAdapter();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: H */
    public void m9387H() {
        try {
            if (this.f13066h != null && this.f13066h.getItemCount() == 0) {
                this.f13065g.m20131c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: I */
    public void m9386I() {
        try {
            if (this.f13066h != null && this.f13066h.getItemCount() == 0) {
                this.f13065g.m20128d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: J */
    public void m9385J() {
        try {
            if (this.f13066h != null && this.f13066h.getItemCount() == 0) {
                this.f13065g.m20124f();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public abstract List<T> mo9379a(String str);

    /* renamed from: a */
    public void mo9381a(HttpParams httpParams) {
    }

    /* renamed from: b */
    public abstract VHDelegateImpl<T> mo9376b(int i);

    /* renamed from: b */
    public abstract String mo9377b();

    /* renamed from: c */
    public int mo9374c() {
        return 0;
    }

    /* renamed from: d */
    public int m9371d() {
        return 20;
    }

    /* renamed from: f */
    public RecyclerView.LayoutManager m9367f() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f13068j);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        return linearLayoutManager;
    }

    /* renamed from: g */
    public String m9366g() {
        return "";
    }

    /* renamed from: h */
    public BaseListViewAdapter<T> m9365h() {
        return this.f13066h;
    }

    /* renamed from: i */
    public RecyclerView.LayoutManager m9364i() {
        return this.f13067i;
    }

    /* renamed from: j */
    public int m9363j() {
        return this.f13061c;
    }

    /* renamed from: k */
    public int m9362k() {
        return 6;
    }

    /* renamed from: l */
    public BaseListViewAdapter<T> m9361l() {
        return new C4251b();
    }

    /* renamed from: m */
    public RecyclerView m9360m() {
        return this.f13063e;
    }

    /* renamed from: n */
    public RefreshFooter m9359n() {
//        return null;
        return C4323g0.m9141a(this.f13068j);
    }

    /* renamed from: o */
    public RefreshHeader mo9358o() {
//        return null;
        return C4323g0.m9139b(this.f13068j);

    }

    /* renamed from: p */
    public abstract String mo9357p();

    /* renamed from: q */
    public final void m9356q() {
        try {
            if (m9347z()) {
                this.f13069k = C4326m.m9107a(this.f13068j, m9366g());
            }
            this.f13064f.setRefreshHeader(mo9358o());
            this.f13064f.setOnRefreshListener((OnRefreshListener) this);
            if (mo9351v()) {
                this.f13064f.setRefreshFooter(m9359n());
                this.f13064f.setOnLoadMoreListener((OnLoadMoreListener) this);
            }
            this.f13063e.setDemoLayoutReference(mo9374c());
            this.f13063e.setDemoChildCount(m9371d());
            this.f13067i = m9367f();
            this.f13063e.setLayoutManager(this.f13067i);
            this.f13063e.addItemDecoration(mo9369e());
            this.f13066h = m9361l();
            this.f13063e.setAdapter(this.f13066h);
            this.f13063e.addOnScrollListener(new C4250a());
            this.f13065g.setOnRetryClickListener(new View.OnClickListener() { // from class: e.c.a.k.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecyclerViewHelper.this.m9382a(view);
                }
            });
            if (mo9354s()) {
                return;
            }
            if (m9355r()) {
                m9384a();
            } else {
                m9390E();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: r */
    public boolean m9355r() {
        return false;
    }

    /* renamed from: s */
    public boolean mo9354s() {
        return false;
    }

    /* renamed from: t */
    public boolean m9353t() {
        return true;
    }

    /* renamed from: u */
    public boolean m9352u() {
        return false;
    }

    /* renamed from: v */
    public boolean mo9351v() {
        return true;
    }

    /* renamed from: w */
    public boolean m9350w() {
        return true;
    }

    /* renamed from: x */
    public boolean m9349x() {
        return true;
    }

    /* renamed from: y */
    public boolean m9348y() {
        return false;
    }

    /* renamed from: z */
    public boolean m9347z() {
        return false;
    }

    /* renamed from: a */
    public /* synthetic */ void m9382a(View view) {
        m9384a();
    }


    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        m9389F();
    }

//    @Override // p067e.p282r.p283a.p284a.p289e.OnRefreshListener
//    /* renamed from: b */
//    public void mo4721b(@NonNull RefreshLayout jVar) {
//        m9389F();
//    }

    /* renamed from: c */
    public void m9373c(int i) {
        this.f13061c = i;
    }

    /* renamed from: e */
    public RecyclerView.ItemDecoration mo9369e() {
        return new SpacesItemDecoration(0, 0);
    }

    /* renamed from: a */
    public void m9384a() {
        try {
            if (this.f13064f != null) {
                this.f13064f.autoRefreshAnimationOnly();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        m9393B();
    }

//    @Override // p067e.p282r.p283a.p284a.p289e.OnLoadMoreListener
//    /* renamed from: a */
//    public void mo4730a(@NonNull RefreshLayout jVar) {
//        m9393B();
//    }

    /* renamed from: a */
    public void m9378a(boolean z) {
        try {
            this.f13064f.setEnableLoadMore(z);
            this.f13064f.resetNoMoreData();
            this.f13062d = z;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public HttpParams m9383a(int i) {
        HttpParams a = HttpUtil.m9789a();
        if (mo9351v()) {
            a.put("page", i, new boolean[0]);
        }
        mo9381a(a);
        HttpUtil.m9767a(a);
        return a;
    }

    public RecyclerViewHelper(Context context, View view) {
        try {
            this.f13068j = context;
            this.f13063e = (ShimmerRecyclerView) view.findViewById(R.id.recyclerView);
            this.f13064f = (SmartRefreshLayout) view.findViewById(R.id.smartRefreshLayout);
            this.f13065g = (MultipleStatusLayout) view.findViewById(R.id.multipleStatusLayout);
            m9356q();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
