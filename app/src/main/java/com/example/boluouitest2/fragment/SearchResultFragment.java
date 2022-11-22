package com.example.boluouitest2.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.boluouitest2.R;
import com.example.boluouitest2.comod.baselib.fragment.AbsFragment;
import com.example.boluouitest2.comod.baselib.view.ViewPagerHelper;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.CommonNavigatorAdapter;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.CommonPagerAdapter;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerTitleView;
import com.example.boluouitest2.comod.baselib.view.magicindicator.CommonNavigator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.MagicIndicator;
import com.example.boluouitest2.util.CustomMagicIndicatorUtil;

import java.util.ArrayList;
import java.util.List;


public class SearchResultFragment extends AbsFragment {
    /* renamed from: b */
    public MagicIndicator f1345b;

    /* renamed from: c */
    public ViewPager f1346c;

    /* renamed from: d */
    public List<String> f1347d = null;

    /* renamed from: e */
    public String f1348e;

    @Override
    public void mo20157a(View view) {
        if (getArguments() != null) {
            this.f1348e = getArguments().getString("keyword");
            initView(view);
            m20314v();
            m20315t();
            m20313w();
        }
    }

    public final void initView(View view) {
        this.f1345b = (MagicIndicator) view.findViewById(R.id.indicator);
        this.f1346c = (ViewPager) view.findViewById(R.id.viewPager);
    }
    /* renamed from: v */
    public final void m20314v() {
        this.f1347d = new ArrayList();
        this.f1347d.add(getResources().getString(R.string.str_video));
        this.f1347d.add(getResources().getString(R.string.str_user));
    }

    /* renamed from: t */
    public final void m20315t() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(SearchResultVideoFragment.m20306a(this.f1348e));
            arrayList.add(SearchResultUserFragment.m20308b(this.f1348e));
            this.f1346c.setAdapter(new CommonPagerAdapter(getChildFragmentManager(), arrayList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* renamed from: w */
    public final void m20313w() {
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new C0776a());
        this.f1345b.setNavigator(commonNavigator);
        ViewPagerHelper.m8992a(this.f1345b, this.f1346c);
    }

    /* renamed from: com.blmvl.blvl.fragment.SearchResultFragment$a */
    /* loaded from: classes.dex */
    public class C0776a extends CommonNavigatorAdapter {
        public C0776a() {
        }

        @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.CommonNavigatorAdapter
        /* renamed from: a */
        public int mo8987a() {
            if (SearchResultFragment.this.f1347d == null) {
                return 0;
            }
            return SearchResultFragment.this.f1347d.size();
        }

        @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.CommonNavigatorAdapter
        /* renamed from: a */
        public IPagerTitleView mo8985a(Context context, int i) {
            return CustomMagicIndicatorUtil.m9466a(context, i, SearchResultFragment.this.f1347d, SearchResultFragment.this.f1346c, 16, SearchResultFragment.this.getResources().getColor(R.color.color_999), SearchResultFragment.this.getResources().getColor(R.color.color_1a));
        }

        @Override // p067e.p130f.p148b.p149a.p151e.p152c.p153a.CommonNavigatorAdapter
        /* renamed from: a */
        public IPagerIndicator mo8986a(Context context) {
            return CustomMagicIndicatorUtil.m9469a(context, SearchResultFragment.this.getResources().getColor(R.color.color_fcd935));
        }
    }




    @Override
    public int mo20158r() {
        return R.layout.fragment_search_result_out;
    }





    /* renamed from: a */
    public static SearchResultFragment m20317a(String str) {
        SearchResultFragment searchResultFragment = new SearchResultFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        searchResultFragment.setArguments(bundle);
        return searchResultFragment;
    }




}