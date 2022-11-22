package com.example.boluouitest2.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.comod.baselib.view.MultipleStatusLayout;
import com.example.boluouitest2.comod.baselib.view.magicindicator.util.SpacesItemDecoration;
import com.example.boluouitest2.httpUtil.C4220b;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.SmartRefreshLayoutUtil;
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

import java.util.List;

/* loaded from: classes.dex */
public abstract class AbsLazyListFragment<T extends BaseListViewAdapter.C0890c> extends AbsLazyFragment implements OnRefreshListener, OnLoadMoreListener {

    /* renamed from: h */
    public RecyclerView f1118h;

    /* renamed from: i */
    public SmartRefreshLayout f1119i;

    /* renamed from: j */
    public MultipleStatusLayout f1120j;

    /* renamed from: k */
    public BaseListViewAdapter<T> f1121k;

    /* renamed from: l */
    public int f1122l;

    /* renamed from: m */
    public RecyclerView.LayoutManager f1123m;

    /* renamed from: e */
    public boolean f1115e = false;

    /* renamed from: f */
    public int f1116f = 1;

    /* renamed from: g */
    public boolean f1117g = true;

    /* renamed from: n */
    public final HttpCallback f1124n = new C0743c();

    /* renamed from: com.blmvl.blvl.fragment.AbsLazyListFragment$a */
    /* loaded from: classes.dex */
    public class C0741a extends RecyclerView.OnScrollListener {
        public C0741a() {
        }

        @Override // android.support.p004v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            AbsLazyListFragment.this.m20517a(recyclerView, i);
        }

        @Override // android.support.p004v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            try {
                if (AbsLazyListFragment.this.m20527J() && AbsLazyListFragment.this.m20525O()) {
                    int i3 = 0;
                    if ((AbsLazyListFragment.this.f1123m instanceof GridLayoutManager) || (AbsLazyListFragment.this.f1123m instanceof LinearLayoutManager)) {
                        if (AbsLazyListFragment.this.f1123m instanceof GridLayoutManager) {
                            i3 = ((GridLayoutManager) AbsLazyListFragment.this.m20530D()).findLastVisibleItemPosition();
                        } else {
                            i3 = ((LinearLayoutManager) AbsLazyListFragment.this.m20530D()).findLastVisibleItemPosition();
                        }
                    }
                    if (AbsLazyListFragment.this.f1121k.getItemCount() - i3 < 6) {
                        AbsLazyListFragment.this.m20523T();
                    }
                }
                AbsLazyListFragment.this.m20516a(recyclerView, i, i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.blmvl.blvl.fragment.AbsLazyListFragment$b */
    /* loaded from: classes.dex */
    public class C0742b extends BaseListViewAdapter<T> {
        public C0742b() {
        }

        @Override // com.comod.baselib.list.BaseListViewAdapter
        public VHDelegateImpl<T> createVHDelegate(int i) {
            return AbsLazyListFragment.this.mo20294b(i);
        }
    }

    /* renamed from: com.blmvl.blvl.fragment.AbsLazyListFragment$c */
    /* loaded from: classes.dex */
    public class C0743c extends HttpCallback {
        public C0743c() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
            Log.e("AbsLazyListFragment::::","onError");
            AbsLazyListFragment.this.m20521X();
            AbsLazyListFragment.this.m20519Z();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
            Log.e("AbsLazyListFragment::::","onException");
            AbsLazyListFragment.this.m20521X();
            AbsLazyListFragment.this.m20519Z();
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.m9102c(AbsLazyListFragment.this.getContext(), str);
            }
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
            Log.e("AbsLazyListFragment::::","onNetworkError");
            AbsLazyListFragment.this.m20521X();
            AbsLazyListFragment.this.m20514a0();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            Log.e("AbsLazyListFragment::::","onSuccess");
            AbsLazyListFragment.this.m20521X();
            try {
                List<T> a = AbsLazyListFragment.this.mo20295a(str);
                if (AbsLazyListFragment.this.f1116f == 1) {
                    AbsLazyListFragment.this.f1121k.clear();
                }
                if (a != null && !a.isEmpty()) {
                    AbsLazyListFragment.this.f1121k.addItems(a);
                    if (AbsLazyListFragment.this.f1116f > 1) {
                        AbsLazyListFragment.this.mo20420b(a);
                    }
                    if (AbsLazyListFragment.this.m20527J()) {
                        AbsLazyListFragment.this.f1116f++;
                    }
                } else if (AbsLazyListFragment.this.m20527J()) {
                    AbsLazyListFragment.this.f1119i.setEnableLoadMore(false);   //m18522d
                    AbsLazyListFragment.this.f1119i.resetNoMoreData();         //m18515g
                    AbsLazyListFragment.this.f1117g = false;
                }
                AbsLazyListFragment.this.m20520Y();
            } catch (Exception e) {
                e.printStackTrace();
                AbsLazyListFragment.this.m20519Z();
            }
        }
    }

    /* renamed from: A */
    public RecyclerView.LayoutManager mo20312A() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        return linearLayoutManager;
    }

    /* renamed from: D */
    public RecyclerView.LayoutManager m20530D() {
        return this.f1123m;
    }

    /* renamed from: E */
    public BaseListViewAdapter<T> mo20311E() {
        return new C0742b();
    }

    /* renamed from: F */
    public RefreshFooter m20529F() {
        return SmartRefreshLayoutUtil.m9581a(getContext());
    }

    /* renamed from: H */
    public RefreshHeader m20528H() {
        return SmartRefreshLayoutUtil.m9579b(getContext());
    }

    /* renamed from: I */
    public abstract String mo20298I();

    /* renamed from: J */
    public boolean m20527J() {
        return true;
    }

    /* renamed from: L */
    public boolean m20526L() {
        return true;
    }

    /* renamed from: O */
    public boolean m20525O() {
        return true;
    }

    /* renamed from: P */
    public void m20524P() {
        this.f1120j.m20141a();
        if (m20526L()) {
            ((PostRequest) C4220b.m9794b().m9793b(mo20289w(), mo20298I()).params(m20518a(this.f1116f))).execute(this.f1124n);
        } else {
            ((GetRequest) C4220b.m9794b().m9796a(mo20289w(), mo20298I()).params(m20518a(this.f1116f))).execute(this.f1124n);
        }
    }

    /* renamed from: T */
    public void m20523T() {
        if (!this.f1115e && this.f1117g) {
            this.f1115e = true;
            m20524P();
        }
    }

    /* renamed from: W */
    public void m20522W() {
        Log.e("AbsLazyListFragment::::","m20522W::" + !this.f1115e);
        if (!this.f1115e) {
            this.f1115e = true;
            this.f1116f = 1;
            if (m20527J()) {
                this.f1119i.setEnableLoadMore(true);        //m18522d
                this.f1119i.resetNoMoreData();                  //m18515g
                this.f1117g = true;
            }
            m20524P();
        }
    }

    /* renamed from: X */
    public void m20521X() {
        try {
            this.f1115e = false;
            this.f1119i.finishRefresh();                //m18524d
            if (m20527J()) {
                this.f1119i.finishLoadMore();              //m18534b
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: Y */
    public void m20520Y() {
        try {
            if (this.f1121k != null && this.f1121k.getItemCount() == 0) {
                this.f1120j.m20131c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: Z */
    public void m20519Z() {
        try {
            if (this.f1121k != null && this.f1121k.getItemCount() == 0) {
                this.f1120j.m20128d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public abstract List<T> mo20295a(String str);

    /* renamed from: a */
    public void mo20310a(Bundle bundle) {
    }

    /* renamed from: a */
    public void m20517a(RecyclerView recyclerView, int i) {
    }

    /* renamed from: a */
    public void m20516a(RecyclerView recyclerView, int i, int i2) {
    }

    /* renamed from: a */
    public void mo20309a(HttpParams httpParams) {
    }

    /* renamed from: a0 */
    public void m20514a0() {
        try {
            if (this.f1121k != null && this.f1121k.getItemCount() == 0) {
                this.f1120j.m20124f();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public VHDelegateImpl<T> mo20294b(int i) {
        return null;
    }

    /* renamed from: b */
    public /* synthetic */ void m20513b(View view) {
        m20512v();
    }

    /* renamed from: b */
    public void mo20420b(List<T> list) {
    }

    /* renamed from: c */
    public void mo20292c(View view) {
    }

    @Override // com.comod.baselib.fragment.AbsLazyFragment
    public void initView(View view) {
        try {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f1122l = arguments.getInt("key_load_method", 1);
                mo20310a(arguments);
                this.f1118h = (RecyclerView) view.findViewById(R.id.recyclerView);
                this.f1119i = (SmartRefreshLayout) view.findViewById(R.id.smartRefreshLayout);
                this.f1119i.setRefreshHeader(m20528H());   //m18540a
                this.f1119i.setOnRefreshListener((OnRefreshListener) this);   //m18537a
                if (m20527J()) {
                    this.f1119i.setRefreshFooter(m20529F());          //m18542a
                    this.f1119i.setOnLoadMoreListener((OnLoadMoreListener) this);   //m18538a
                }
                this.f1123m = mo20312A();
                this.f1118h.setLayoutManager(this.f1123m);
                this.f1118h.addItemDecoration(mo20418x());
                this.f1121k = mo20311E();
                this.f1118h.setAdapter(this.f1121k);
                this.f1118h.addOnScrollListener(new C0741a());
                this.f1120j = (MultipleStatusLayout) view.findViewById(R.id.multipleStatusLayout);
                this.f1120j.setOnRetryClickListener(new View.OnClickListener() { // from class: e.c.a.g.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AbsLazyListFragment.this.m20513b(view2);
                    }
                });
                mo20292c(view);
                if (this.f1122l == 2) {
                    m20512v();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HttpUtil.m9735b(mo20298I());
    }

    @Override // com.comod.baselib.fragment.AbsLazyFragment
    public void onLazyLoad() {
        Log.e("AbsLazyListFragment::::","onLazyLoad::"+this.f1122l);
        if (this.f1122l == 1) {
            m20512v();
        }
    }

    @Override // com.comod.baselib.fragment.AbsFragment
    /* renamed from: r */
    public int mo20158r() {
        return R.layout.fragment_abs_recyclerview;
    }

    /* renamed from: v */
    public final void m20512v() {
        try {
            if (this.f1119i != null) {
                this.f1119i.autoRefreshAnimationOnly();                     //m18551a
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: w */
    public abstract String mo20289w();

    /* renamed from: x */
    public RecyclerView.ItemDecoration mo20418x() {
        return new SpacesItemDecoration(0, 0);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        m20523T();
    }

//    @Override // p067e.p282r.p283a.p284a.p289e.OnLoadMoreListener
//    /* renamed from: a */
//    public void mo4730a(@NonNull RefreshLayout jVar) {
//        m20523T();
//    }





    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        m20522W();
    }

//    @Override // p067e.p282r.p283a.p284a.p289e.OnRefreshListener
//    /* renamed from: b */
//    public void mo4721b(@NonNull RefreshLayout jVar) {
//        m20522W();
//    }

    /* renamed from: a */
    public HttpParams m20518a(int i) {
        HttpParams a = HttpUtil.m9789a();
        if (m20527J()) {
            a.put("page", i, new boolean[0]);
        }
        mo20309a(a);
        HttpUtil.m9767a(a);
        return a;
    }
}
