package com.example.boluouitest2.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.EventBus.ChangeVideoEvent;
import com.example.boluouitest2.EventBus.FollowEvent;
import com.example.boluouitest2.EventBus.PositionChangeEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.VHDelegate.SearchVideoListVHDelegate;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.ViewHelper.RecyclerViewHelper;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.util.ApiUrlUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.lzy.okgo.model.HttpParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


public class SearchResultVideoFragment extends AbsLazyFragment {
    /* renamed from: e */
    public String f1351e;

    /* renamed from: f */
    public RecyclerViewHelper f1352f;

    @Override
    public int mo20158r() {
        return R.layout.layout_abs_recyclerview_list;
    }

    @Override
    public void initView(View view) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f1351e = arguments.getString("keyword");
            this.f1352f = new C0777a(getContext(), view);
//            EventBus.m309d().m310c(this);
            //注册
            EventBus.getDefault().register(this);
//            LogUtil.m9410a("BL_SEARCH_RESULT_VIDEO_PAGE");
        }
    }

    @Override
    public void onLazyLoad() {
        if (ObjUtil.m9224a(this.f1352f)) {
            this.f1352f.m9390E();
        }
    }




    /* renamed from: a */
    public static SearchResultVideoFragment m20306a(String str) {
        SearchResultVideoFragment searchResultVideoFragment = new SearchResultVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        searchResultVideoFragment.setArguments(bundle);
        return searchResultVideoFragment;
    }







    /* renamed from: com.blmvl.blvl.fragment.SearchResultVideoFragment$a */
    /* loaded from: classes.dex */
    public class C0777a extends RecyclerViewHelper {
        public C0777a(Context context, View view) {
            super(context, view);
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public List mo9379a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return JSON.parseArray(JSON.parseObject(str).getString("list"), VideoBean.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ArrayList();
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public VHDelegateImpl mo9376b(int i) {
            return new SearchVideoListVHDelegate(SearchResultVideoFragment.this.f1351e);
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: c */
        public int mo9374c() {
            return R.layout.item_video_mid_video_default;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: p */
        public String mo9357p() {
            return "getSearchVideoList";
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public String mo9377b() {
            return ApiUrlUtil.m9219a("/api/search/mv");
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public void mo9381a(HttpParams httpParams) {
            super.mo9381a(httpParams);
            httpParams.put("kwy", SearchResultVideoFragment.this.f1351e, new boolean[0]);
        }
    }




    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChangeVideoEvent(ChangeVideoEvent changeVideoEvent) {
        try {
            BaseListViewAdapter h = this.f1352f.m9365h();
            ArrayList arrayList = (ArrayList) h.getItems();
            if (!(arrayList == null || arrayList.isEmpty())) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) != null && ((VideoBean) arrayList.get(i)).getId() == changeVideoEvent.getVid()) {
                        h.setItem(i, changeVideoEvent.getItem());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (ObjUtil.m9224a(this.f1352f)) {
            this.f1352f.m9392C();
        }
//        EventBus.m309d().m308d(this);
        //取消注册
        EventBus.getDefault().unregister(this);
    }

    @SuppressLint("LongLogTag")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(FollowEvent followEvent) {
        Log.e("SearchResultVideoFragment:","onFollowEvent");
        try {
            BaseListViewAdapter h = this.f1352f.m9365h();
            if (!(h == null || h.getItems().isEmpty())) {
                for (int i = 0; i < h.getItems().size(); i++) {
                    VideoBean videoBean = (VideoBean) h.getItems().get(i);
                    if (videoBean != null && videoBean.getUser().getUid() == followEvent.getToUid()) {
                        videoBean.getUser().setIs_attention(followEvent.getIsAttention());
                        h.notifyItemChanged(i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPositionChangeEvent(PositionChangeEvent positionChangeEvent) {
        try {
            if (positionChangeEvent.getFrom() == 1) {
                int position = positionChangeEvent.getPosition();
                if (ObjUtil.m9224a(this.f1352f)) {
                    this.f1352f.m9360m().smoothScrollToPosition(position);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}