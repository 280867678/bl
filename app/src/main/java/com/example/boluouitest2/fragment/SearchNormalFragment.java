package com.example.boluouitest2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.Adapter.SearchNormalTagAdapter;
import com.example.boluouitest2.EventBus.CurSelectVideoIdEvent;
import com.example.boluouitest2.EventBus.SearchKeyWordEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.AdBannerBean;
import com.example.boluouitest2.bean.SearchNormalInfoBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsFragment;
import com.example.boluouitest2.comod.baselib.view.banner.XBanner;
import com.example.boluouitest2.comod.baselib.view.flow.AutoFlowLayout;
import com.example.boluouitest2.comod.baselib.view.flow.FlowAdapter;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.CustomAdBannerUtil;
import com.example.boluouitest2.util.SpUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * 搜索标签
 */
public class SearchNormalFragment extends AbsFragment {
    /* renamed from: b */
    public XBanner f1336b;

    /* renamed from: c */
    public ImageView f1337c;

    /* renamed from: d */
    public RecyclerView f1338d;

    /* renamed from: e */
    public LinearLayout f1339e;

    /* renamed from: f */
    public AutoFlowLayout f1340f;

    /* renamed from: g */
    public SearchNormalTagAdapter f1341g;





    public static SearchNormalFragment newInstance() {
        return new SearchNormalFragment();
    }



    @Override
    public void mo20157a(View view) {
        m20324b(view);
        m20319v();
        m20320t();
//        LogUtil.m9410a("BL_SEARCH_NORMAL_PAGE");
    }

    /* renamed from: t */

    /**
     * 获取标签搜索数据
     */
    public final void m20320t() {
        HttpUtil.m9649q(new C0774a());
    }

    /* renamed from: b */
    public final void m20324b(View view) {
        this.f1336b = (XBanner) view.findViewById(R.id.banner);
        this.f1336b.setVisibility(View.GONE);
        CustomAdBannerUtil.m9485c(getContext(), this.f1336b);
        this.f1337c = (ImageView) view.findViewById(R.id.img_del);
        this.f1337c.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SearchNormalFragment.this.m20321c(view2);
            }
        });
        this.f1339e = (LinearLayout) view.findViewById(R.id.layout_history_tags_title);
        this.f1340f = (AutoFlowLayout) view.findViewById(R.id.layout_history_tags);
        this.f1339e.setVisibility(View.GONE);
        this.f1340f.setVisibility(View.GONE);
        this.f1338d = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        this.f1338d.setLayoutManager(linearLayoutManager);
        this.f1341g = new SearchNormalTagAdapter();
        this.f1338d.setAdapter(this.f1341g);
    }

    /* renamed from: c */
    public /* synthetic */ void m20321c(View view) {
        SpUtil.m9573D().m9563b();
        m20319v();
    }

    /* renamed from: v */
    public final void m20319v() {
        List<String> p = SpUtil.m9573D().m9524p();
        if (p == null || p.isEmpty()) {
            this.f1339e.setVisibility(View.GONE);
            this.f1340f.setVisibility(View.GONE);
            return;
        }
        this.f1339e.setVisibility(View.VISIBLE);
        this.f1340f.setVisibility(View.VISIBLE);
        m20322b(p);
    }

    /* renamed from: b */
    public final void m20322b(final List<String> list) {
        try {
            this.f1340f.mo15218a();
            this.f1340f.setAdapter(new C0775b(list, list));
            this.f1340f.setOnItemClickListener(new AutoFlowLayout.AbstractC0912c() { // from class: e.c.a.g.w
                @Override // com.comod.baselib.view.flow.AutoFlowLayout.AbstractC0912c
                /* renamed from: a */
                public final void mo15256a(int i, View view) {
                    SearchNormalFragment.m20325a(list, i, view);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* renamed from: a */
    public static /* synthetic */ void m20325a(List list, int i, View view) {
        try {
            if (i < list.size()) {
//                EventBus.m309d().m320a(new SearchKeyWordEvent((String) list.get(i)));
                EventBus.getDefault().post(new SearchKeyWordEvent((String) list.get(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* renamed from: com.blmvl.blvl.fragment.SearchNormalFragment$b */
    /* loaded from: classes.dex */
    public class C0775b extends FlowAdapter<String> {

        /* renamed from: b */
        public final /* synthetic */ List f1343b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0775b(List list, List list2) {
            super(list);
            this.f1343b = list2;
        }

        @Override // p067e.p130f.p131a.p136e.p142d.FlowAdapter
        /* renamed from: a */
        public View mo11688a(int i) {
            try {
                if (!TextUtils.isEmpty(((String) this.f1343b.get(i)).trim())) {
                    View inflate = LayoutInflater.from(SearchNormalFragment.this.getContext()).inflate(R.layout.item_bg_search_tag, (ViewGroup) null, false);
                    ((TextView) inflate.findViewById(R.id.text_tag)).setText(String.format("%s", ((String) this.f1343b.get(i)).trim()));
                    return inflate;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }



    /* renamed from: com.blmvl.blvl.fragment.SearchNormalFragment$a */
    /* loaded from: classes.dex */

    /**
     * 标签搜索数据
     */
    public class C0774a extends HttpCallback {
        public C0774a() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onError() {
            super.onError();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onException(int i, String str) {
            super.onException(i, str);
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onNetworkError() {
            super.onNetworkError();
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            SearchNormalInfoBean searchNormalInfoBean;
            super.onSuccess(str, str2, z, z2);
            try {
                if (!TextUtils.isEmpty(str) && (searchNormalInfoBean = (SearchNormalInfoBean) JSON.parseObject(str, SearchNormalInfoBean.class)) != null) {
                    List<AdBannerBean> ads = searchNormalInfoBean.getAds();
                    if (ads == null || ads.isEmpty()) {
                        SearchNormalFragment.this.f1336b.setVisibility(View.GONE);
                    } else {
                        SearchNormalFragment.this.f1336b.setVisibility(View.VISIBLE);
                        CustomAdBannerUtil.m9489a(SearchNormalFragment.this.getContext(), SearchNormalFragment.this.f1336b, R.layout.xbanner_item_image, ads);
                    }
                    SearchNormalFragment.this.f1341g.refreshAddItems(searchNormalInfoBean.getList());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }







    @Override
    public int mo20158r() {
        return R.layout.fragment_search_normal;
    }
}