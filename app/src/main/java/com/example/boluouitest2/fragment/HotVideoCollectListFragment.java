package com.example.boluouitest2.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.example.boluouitest2.R;
import com.example.boluouitest2.VHDelegate.HotVideoCollectListVHDelegate;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.ViewHelper.RecyclerViewHelper;
import com.example.boluouitest2.bean.VideoCollectInfoBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.SmartRefreshLayoutUtil;
import com.scwang.smartrefresh.layout.api.RefreshHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * 热门合集
 */
public class HotVideoCollectListFragment extends AbsLazyFragment {

    /* renamed from: e */
    public RecyclerViewHelper f1198e;

    public static HotVideoCollectListFragment newInstance() {
        return new HotVideoCollectListFragment();
    }



    @Override
    public int mo20158r() {
        return R.layout.layout_abs_recyclerview_list;
    }

    @Override
    public void initView(View view) {
        this.f1198e = new C0758a(getContext(), view);
    }

    /* renamed from: com.blmvl.blvl.fragment.HotVideoCollectListFragment$a */
    /* loaded from: classes.dex */
    public class C0758a extends RecyclerViewHelper {
        public C0758a(Context context, View view) {
            super(context, view);
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public List mo9379a(String str) {
            ArrayList arrayList = new ArrayList();
            try {
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                String string = JSON.parseObject(str).getString("list");
                return !TextUtils.isEmpty(string) ? JSON.parseArray(string, VideoCollectInfoBean.class) : arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                return arrayList;
            }
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public VHDelegateImpl<VideoCollectInfoBean> mo9376b(int i) {
            return new HotVideoCollectListVHDelegate();
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public String mo9377b() {
            return "/api/usertopic/popular";
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: c */
        public int mo9374c() {
            return R.layout.item_video_mid_video_default;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: o */
        public RefreshHeader mo9358o() {
            return SmartRefreshLayoutUtil.m9580a(HotVideoCollectListFragment.this.getContext(), R.mipmap.icon_down_arrow_white, R.color.white, R.color.transparent);
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: p */
        public String mo9357p() {
            return "get_hot_video_collect_list";
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: v */
        public boolean mo9351v() {
            return false;
        }
    }





    @Override
    public void onLazyLoad() {
        if (ObjUtil.m9224a(this.f1198e)) {
            this.f1198e.m9390E();
        }
    }
}