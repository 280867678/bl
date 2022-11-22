package com.example.boluouitest2.fragment;

import android.content.Context;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.boluouitest2.EventBus.FollowEvent;
import com.example.boluouitest2.R;
import com.example.boluouitest2.ViewHelper.BaseListViewAdapter;
import com.example.boluouitest2.ViewHelper.RecyclerViewHelper;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.VHDelegate.VideoBigCoverVHDelegate;
import com.example.boluouitest2.bean.AdBannerBean;
import com.example.boluouitest2.bean.BannerDataBean;
import com.example.boluouitest2.bean.HomeTabItem;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.util.ApiUrlUtil;

import com.example.boluouitest2.util.ListUtil;
import com.example.boluouitest2.util.ObjUtil;
import com.example.boluouitest2.util.WordUtil;
import com.lzy.okgo.model.HttpParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


public class VideoSortFragment extends AbsLazyFragment {
    /* renamed from: e */
    public RecyclerViewHelper f1446e;

    /* renamed from: f */
    public HomeTabItem f1447f;


    /* renamed from: a */
    public static VideoSortFragment m20206a(HomeTabItem homeTabItem) {
        VideoSortFragment videoSortFragment = new VideoSortFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data_bean", homeTabItem);
        videoSortFragment.setArguments(bundle);
        return videoSortFragment;
    }


    @Override
    public int mo20158r() {
        return R.layout.layout_abs_recyclerview_list;
    }

    @Override
    public void initView(View view) {
        if (getArguments() != null) {
            this.f1447f = (HomeTabItem) getArguments().getParcelable("data_bean");
            if (this.f1447f != null) {
                m20203b(view);
                ///////////////////////////////////////////////////////////////////////////////////////////
//                EventBus.m309d().m310c(this);
                //注册
                EventBus.getDefault().register(this);
            }
        }
    }

    /* renamed from: b */
    public final void m20203b(View view) {
        this.f1446e = new C0796a(getContext(), view);
    }

    @Override
    public void onLazyLoad() {
        if (ObjUtil.m9224a(f1446e)) {
            this.f1446e.m9390E();
        }
    }





















    /* renamed from: com.blmvl.blvl.fragment.VideoSortFragment$a */
    /* loaded from: classes.dex */
    public class C0796a extends RecyclerViewHelper {
        public C0796a(Context context, View view) {
            super(context, view);
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public List mo9379a(String str) {
            ArrayList arrayList = new ArrayList();
            try {
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                VideoSortFragment.this.m20202b(str, arrayList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public VHDelegateImpl mo9376b(int i) {
            if (i == 1) {
                Log.e("VideoSor:::::","125");
//                return new VideoSortBannerVHDelegate();
            }
            //视图
            return new VideoBigCoverVHDelegate();
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: c */
        public int mo9374c() {
//            Log.e("p067e.p103c.p104a.p113k.RecyclerViewHelper:", String.valueOf(R.layout.layout_list_big_cover_view_default));

            return R.layout.layout_list_big_cover_view_default;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: p */
        public String mo9357p() {
            return String.format("%s", WordUtil.m9084a(VideoSortFragment.this.f1447f.getType()));
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: s */
        public boolean mo9354s() {
            return true;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public String mo9377b() {
            return ApiUrlUtil.m9219a(WordUtil.m9084a(VideoSortFragment.this.f1447f.getApi()));
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public void mo9381a(HttpParams httpParams) {
            super.mo9381a(httpParams);
            try {
                if (!(VideoSortFragment.this.f1447f == null || TextUtils.isEmpty(VideoSortFragment.this.f1447f.getParams()))) {

                    Log.e("VideoSortF.f1447f:","161");
//                    for (Map.Entry entry : ((HashMap) JSON.parseObject(VideoSortFragment.this.f1447f.getParams(), HashMap.class)).entrySet()) {
//                        httpParams.put((String) entry.getKey(), ((Integer) entry.getValue()).intValue(), new boolean[0]);
//                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }












    /* renamed from: b */
    public final void m20202b(String str, List list) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject parseObject = JSON.parseObject(str);
//                if (parseObject.containsKey("banner")) {
//                    String string = parseObject.getString("banner");
//                    if (!TextUtils.isEmpty(string)) {
//                        List<AdBannerBean> parseArray = JSON.parseArray(string, AdBannerBean.class);
//                        if (!ListUtil.m9076a(parseArray)) {
//                            BannerDataBean bannerDataBean = new BannerDataBean();
//                            bannerDataBean.setViewRenderType(1);
//                            bannerDataBean.setAdBannerBeans(parseArray);
//                            list.add(bannerDataBean);
//                        }
//                    }
//                }


                if (parseObject.containsKey("list")) {
                    String string2 = parseObject.getString("list");
                    if (!TextUtils.isEmpty(string2)) {
                        List<VideoBean> parseArray2 = JSON.parseArray(string2, VideoBean.class);
                        if (!ListUtil.m9076a(parseArray2)) {
                            for (VideoBean videoBean : parseArray2) {
                                videoBean.setViewRenderType(2);
                            }
                            list.addAll(parseArray2);
                        }
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
        if (ObjUtil.m9224a(this.f1446e)) {
            this.f1446e.m9392C();
        }
//        EventBus.m309d().m308d(this);
        //取消注册
        EventBus.getDefault().unregister(this);
    }



















    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(FollowEvent followEvent) {
        VideoBean videoBean;
        try {
            BaseListViewAdapter h = this.f1446e.m9365h();
            if (!(h == null || h.getItems().isEmpty())) {
                List items = h.getItems();
                for (int i = 0; i < items.size(); i++) {
                    if (((BaseListViewAdapter.C0890c) items.get(i)).getViewRenderType() == 2 && (videoBean = (VideoBean) h.getItems().get(i)) != null && videoBean.getUser().getUid() == followEvent.getToUid()) {
                        videoBean.getUser().setIs_attention(followEvent.getIsAttention());
                        h.notifyItemChanged(i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}