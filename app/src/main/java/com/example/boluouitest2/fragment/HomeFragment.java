package com.example.boluouitest2.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.EventBus.GetGameInfoEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.activity.SearchActivity;
import com.example.boluouitest2.bean.HomeTabItem;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.comod.baselib.view.ComViewPagerHelper;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerIndicator;
import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.IPagerTitleView;
import com.example.boluouitest2.httpUtil.HttpCallback;
import com.example.boluouitest2.httpUtil.HttpUtil;
import com.example.boluouitest2.util.CustomMagicIndicatorUtil;
import com.example.boluouitest2.util.ListUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.ToastUtil;
import com.example.boluouitest2.util.WordUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeFragment extends AbsLazyFragment {
    /* renamed from: e */
    public ComViewPagerHelper f1188e;

    /* renamed from: f */
    public ImageView f1189f;

    /* renamed from: g */
    public LinearLayout f1190g;

    /* renamed from: h */
    public LinearLayout f1191h;

    /* renamed from: i */
    public View f1192i;

    /* renamed from: j */
    public ImageView f1193j;

    /* renamed from: k */
    public int f1194k = 0;



    @Override
    public int mo20158r() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        m20449b(view);
    }

    @Override
    public void onLazyLoad() {
        HttpUtil.m9664l(new C0756a());
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }



    /* renamed from: b */
    public final void m20449b(View view) {
        this.f1192i = view;
        this.f1189f = (ImageView) view.findViewById(R.id.img_daily_featured);
        this.f1190g = (LinearLayout) view.findViewById(R.id.layout_search);
        this.f1191h = (LinearLayout) view.findViewById(R.id.layout_post);
        this.f1189f.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Toast.makeText(getContext(),"img_daily_featured", Toast.LENGTH_LONG).show();
//                HomeFragment.this.m20447c(view2);
            }
        });
        this.f1191h.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Toast.makeText(getContext(),"layout_post", Toast.LENGTH_LONG).show();
//                HomeFragment.this.m20446d(view2);
            }
        });
        this.f1190g.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Toast.makeText(getContext(),"layout_search", Toast.LENGTH_LONG).show();
                HomeFragment.this.m20445e(view2);
            }
        });
        this.f1193j = (ImageView) view.findViewById(R.id.img_sort_tag);
        this.f1193j.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Toast.makeText(getContext(),"img_sort_tag", Toast.LENGTH_LONG).show();
//                HomeFragment.this.m20444f(view2);
            }
        });
    }




    /* renamed from: com.blmvl.blvl.fragment.HomeFragment$a */
    /* loaded from: classes.dex */
    public class C0756a extends HttpCallback {
        public C0756a() {
        }

        @Override // p067e.p103c.p104a.p111i.HttpCallback
        public void onSuccess(String str, String str2, boolean z, boolean z2) {
            super.onSuccess(str, str2, z, z2);
            try {
                if (!TextUtils.isEmpty(str)) {
                    HomeFragment.this.m20448b(JSON.parseArray(str, HomeTabItem.class));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    /* renamed from: b */
    public final void m20448b(List<HomeTabItem> list) {
        if (ListUtil.m9075b(list)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (ObjUtil.m9224a(list.get(i2))) {
                    HomeTabItem homeTabItem = list.get(i2);
                    arrayList.add(WordUtil.m9084a(homeTabItem.getName()));
                    if (!TextUtils.isEmpty(homeTabItem.getType())) {
                        if (homeTabItem.getType().equals("game")) {
                            this.f1194k = i2;
                            arrayList2.add(GameFragment.m20456b(homeTabItem.getApi(), 1));
                        } else {
                            arrayList2.add(VideoSortFragment.m20206a(homeTabItem));
                        }
                    }
                    if (homeTabItem.isCurrent()) {
                        i = i2;
                    }
                }
            }
            m20450a(arrayList, arrayList2, i);
        }
    }

    /* renamed from: a */
    public final void m20450a(List<String> list, List<Fragment> list2, int i) {
        this.f1188e = new C0757b(getContext(), this.f1192i, list, list2, null, getChildFragmentManager(), list2);
        this.f1188e.m9145c(i);
    }


    /* renamed from: com.blmvl.blvl.fragment.HomeFragment$b */
    /* loaded from: classes.dex */
    public class C0757b extends ComViewPagerHelper {

        /* renamed from: c */
        public final /* synthetic */ List f1196c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0757b(Context context, View view, List list, List list2, List list3, FragmentManager fragmentManager, List list4) {
            super(context, view, list, list2, list3, fragmentManager);
            this.f1196c = list4;
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: a */
        public IPagerTitleView mo9153a(Context context, int i, ViewPager viewPager, List<String> list, List<Integer> list2) {
            return CustomMagicIndicatorUtil.m9466a(context, i, list, viewPager, 18, ((Context) HomeFragment.this.requireContext()).getResources().getColor(R.color.color_333), HomeFragment.this.getContext().getResources().getColor(R.color.color_1a));
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: a */
        public boolean mo9157a() {
            return false;
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: b */
        public void mo9148b(int i) {
            super.mo9148b(i);
            if (i == HomeFragment.this.f1194k) {
//                EventBus.m309d().m320a(new GetGameInfoEvent());
//                发送消息
                EventBus.getDefault().post(new GetGameInfoEvent());
            }
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: c */
        public IPagerIndicator mo9144c(Context context) {
            return CustomMagicIndicatorUtil.m9470a(context);
        }

        @Override // p067e.p130f.p131a.p135d.ComViewPagerHelper
        /* renamed from: d */
        public int mo9143d() {
            List list = this.f1196c;
            if (list == null || list.isEmpty() || this.f1196c.size() <= 4) {
                return 2;
            }
            return this.f1196c.size() - 2;
        }
    }




    /* renamed from: e */

    /**
     * 搜索
     * @param view
     */
    public /* synthetic */ void m20445e(View view) {
        SearchActivity.m20900a(getContext());
    }



}