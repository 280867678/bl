package com.example.boluouitest2.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.boluouitest2.R;
import com.example.boluouitest2.VHDelegate.HotCollectVHDelegate;
import com.example.boluouitest2.VHDelegate.MainFeaturedVideoBodyVHDelegate;
import com.example.boluouitest2.VHDelegate.MainVideoBannerVHDelegate;
import com.example.boluouitest2.VHDelegate.MainVideoBodyTitleVHDelegate;
import com.example.boluouitest2.VHDelegate.VHDelegateImpl;
import com.example.boluouitest2.VHDelegate.VideoTopRankVHDelegate;
import com.example.boluouitest2.ViewHelper.RecyclerViewHelper;
import com.example.boluouitest2.activity.PostVideoActivity;
import com.example.boluouitest2.activity.SearchActivity;
import com.example.boluouitest2.bean.AdBannerBean;
import com.example.boluouitest2.bean.BannerDataBean;
import com.example.boluouitest2.bean.FeaturedVideoBean;
import com.example.boluouitest2.bean.MainHotVideoCollectBean;
import com.example.boluouitest2.bean.MainVideoFeaturedBodyBean;
import com.example.boluouitest2.bean.VideoBean;
import com.example.boluouitest2.bean.VideoRankBean;
import com.example.boluouitest2.bean.VideoRankItemBean;
import com.example.boluouitest2.comod.baselib.fragment.AbsLazyFragment;
import com.example.boluouitest2.util.ObjUtil;

import java.util.ArrayList;
import java.util.List;


public class MainVideoFeaturedFragment extends AbsLazyFragment {
    /* renamed from: e */
    public LinearLayout f1226e;

    /* renamed from: f */
    public LinearLayout f1227f;

    /* renamed from: g */
    public RecyclerViewHelper f1228g;


    public static MainVideoFeaturedFragment newInstance() {
        return new MainVideoFeaturedFragment();
    }


    @Override
    public int mo20158r() {
        return R.layout.fragment_main_video;
    }

    @Override
    public void initView(View view) {
        this.f1226e = (LinearLayout) view.findViewById(R.id.layout_search);
        this.f1227f = (LinearLayout) view.findViewById(R.id.layout_post);
        this.f1227f.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainVideoFeaturedFragment.this.m20401c(view2);
            }
        });
        this.f1226e.setOnClickListener(new View.OnClickListener() { // from class: e.c.a.g.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainVideoFeaturedFragment.this.m20400d(view2);
            }
        });
        m20403b(view);
    }

    /* renamed from: c */
    public /* synthetic */ void m20401c(View view) {
        PostVideoActivity.m20990a(getContext());
    }

    /* renamed from: d */
    public /* synthetic */ void m20400d(View view) {
        SearchActivity.m20900a(getContext());
    }

    /* renamed from: b */
    public final void m20403b(View view) {
        this.f1228g = new C0762a(getContext(), view);
    }

    /* renamed from: com.blmvl.blvl.fragment.MainVideoFeaturedFragment$a */
    /* loaded from: classes.dex */
    public class C0762a extends RecyclerViewHelper {
        public C0762a(Context context, View view) {
            super(context, view);
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: a */
        public List mo9379a(String str) {
            ArrayList arrayList = new ArrayList();
            try {
                MainVideoFeaturedFragment.this.m20402b(str, arrayList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public VHDelegateImpl mo9376b(int i) {
            if (i == 1) {
                return new MainVideoBannerVHDelegate();
            }
            if (i == 2) {
                return new VideoTopRankVHDelegate();
            }
            if (i == 3) {
                return new MainVideoBodyTitleVHDelegate();
            }
            if (i == 4 || i == 5 || i == 6) {
                return new MainFeaturedVideoBodyVHDelegate();
            }
            if (i == 7) {
                return new HotCollectVHDelegate();
            }
            return new MainFeaturedVideoBodyVHDelegate();
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: b */
        public String mo9377b() {
            return "/api/mvnew/home";
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: c */
        public int mo9374c() {
            return 0;
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: p */
        public String mo9357p() {
            return "getFeaturedVideo";
        }

        @Override // p067e.p103c.p104a.p113k.RecyclerViewHelper
        /* renamed from: v */
        public boolean mo9351v() {
            return false;
        }
    }


    @Override
    public void onLazyLoad() {
        if (ObjUtil.m9224a(this.f1228g)) {
            this.f1228g.m9390E();
        }
    }


    public final void m20402b(String p0, List p1) {

        MainVideoFeaturedBodyBean mainVideoFea = null;
        MainVideoFeaturedBodyBean mObject;
        String sType;
        int vi1;
        int iCode;
        FeaturedVideoBean featuredVide;
        String str = "body";
        String str1 = "hot_topic";
        String str2 = "ranking";
        String str3 = "banner";
        try {
            JSONObject jObject = JSON.parseObject(p0);
            if (jObject.containsKey(str3)) {
                str3 = jObject.getString(str3);
                if (!TextUtils.isEmpty(str3)) {
                    BannerDataBean bannerDataBe = new BannerDataBean();
                    bannerDataBe.setViewRenderType(1);
                    bannerDataBe.setAdBannerBeans(JSON.parseArray(str3, AdBannerBean.class));
                    p1.add(bannerDataBe);
                }
            }
            if (jObject.containsKey(str2)) {
                str2 = jObject.getString(str2);
                if (!TextUtils.isEmpty(str2)) {
                    VideoRankBean videoRankBea = new VideoRankBean();
                    videoRankBea.setViewRenderType(2);
                    videoRankBea.setItemBeans(JSON.parseArray(str2, VideoRankItemBean.class));
                    p1.add(videoRankBea);
                }
            }
            MainHotVideoCollectBean object = null;
            if (jObject.containsKey(str1)) {
                str1 = jObject.getString(str1);
                if (!TextUtils.isEmpty(str1)) {
                    object = JSON.parseObject(str1, MainHotVideoCollectBean.class);
                    object.setViewRenderType(7);
                    mainVideoFea = new MainVideoFeaturedBodyBean();
                    mainVideoFea.setSubName(object.getSubName());
                    mainVideoFea.setName(object.getName());
                    mainVideoFea.setIcon(object.getIcon());
                    mainVideoFea.setType(object.getType());
                    mainVideoFea.setDesc(object.getDesc());
                    mainVideoFea.setViewRenderType(3);
                    label_00a2:
                    if (jObject.containsKey(str)) {
                        JSONArray jArray = JSON.parseArray(jObject.getString(str));
                        int vi = 0;
                        while (vi < jArray.size()) {
                            mObject = jArray.getJSONObject(vi).toJavaObject(MainVideoFeaturedBodyBean.class);
                            mObject.setViewRenderType(3);
                            p1.add(mObject);
                            if (mObject.getItem() != null && !mObject.getItem().isEmpty()) {
                                sType = mObject.getType();
                                vi1 = -1;
                                iCode = sType.hashCode();
                                if (iCode != -1077891227) {
                                    if (iCode != -376920941) {
                                        if (iCode == 1844880608 && sType.equals("dou_mai")) {
                                            vi1 = 1;
                                        }
                                    } else if (sType.equals("dou_xi_huan")) {
                                        vi1 = 2;
                                    }
                                } else if (sType.equals("mei_ri")) {
                                    vi1 = 0;
                                }
                                if (vi1 != 0) {
                                    if (vi1 != 1) {
                                        if (vi1 != 2) {
                                            label_016c:
                                            vi = vi + 1;
                                        } else {
                                            featuredVide = new FeaturedVideoBean();
                                            featuredVide.setViewRenderType(5);
                                            featuredVide.setItemList(mObject.getItem().toJavaList(VideoBean.class));
                                            p1.add(featuredVide);
                                            vi = vi+1;
                                        }
                                    } else {
                                        featuredVide = new FeaturedVideoBean();
                                        featuredVide.setViewRenderType(6);
                                        featuredVide.setItemList(mObject.getItem().toJavaList(VideoBean.class));
                                        p1.add(featuredVide);
                                        vi = vi+1;
                                    }
                                } else {
                                    featuredVide = new FeaturedVideoBean();
                                    featuredVide.setViewRenderType(4);
                                    featuredVide.setItemList(mObject.getItem().toJavaList(VideoBean.class));
                                    p1.add(featuredVide);
                                    if (mainVideoFea != null) {
                                        p1.add(mainVideoFea);
                                        p1.add(object);
                                        vi = vi+1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
//            mainVideoFea = object;




            if (jObject.containsKey(str)) {
                JSONArray jArray = JSON.parseArray(jObject.getString(str));
                int vi = 0;
                while (vi < jArray.size()) {
                    mObject = jArray.getJSONObject(vi).toJavaObject(MainVideoFeaturedBodyBean.class);
                    mObject.setViewRenderType(3);
                    p1.add(mObject);
                    if (mObject.getItem() != null && !mObject.getItem().isEmpty()) {
                        sType = mObject.getType();
                        vi1 = -1;
                        iCode = sType.hashCode();
                        if (iCode != -1077891227) {
                            if (iCode != -376920941) {
                                if (iCode == 1844880608 && sType.equals("dou_mai")) {
                                    vi1 = 1;
                                }
                            }else if(sType.equals("dou_xi_huan")){
                                vi1 = 2;
                            }
                        }else if(sType.equals("mei_ri")){
                            vi1 = 0;
                        }
                        if (vi1 !=0 ) {
                            if (vi1 != 1) {
                                if (vi1 != 2) {
                                    label_016c :
                                    vi = vi+1;
                                }else {
                                    featuredVide = new FeaturedVideoBean();
                                    featuredVide.setViewRenderType(5);
                                    featuredVide.setItemList(mObject.getItem().toJavaList(VideoBean.class));
                                    p1.add(featuredVide);
                                    vi = vi+1;
                                }
                            }else {
                                featuredVide = new FeaturedVideoBean();
                                featuredVide.setViewRenderType(6);
                                featuredVide.setItemList(mObject.getItem().toJavaList(VideoBean.class));
                                p1.add(featuredVide);
                                vi = vi+1;
                            }
                        }else {
                            featuredVide = new FeaturedVideoBean();
                            featuredVide.setViewRenderType(4);
                            featuredVide.setItemList(mObject.getItem().toJavaList(VideoBean.class));
                            p1.add(featuredVide);
                            if (mainVideoFea != null) {
                                p1.add(mainVideoFea);
                                p1.add(object);
                                vi = vi+1;
                            }
                        }
                    }
                }
            }




        } catch (java.lang.Exception e13) {
            e13.printStackTrace();
        }
        return;




        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
//        throw new UnsupportedOperationException("Method not decompiled: com.blmvl.blvl.fragment.MainVideoFeaturedFragment.m20402b(java.lang.String, java.util.List):void");
    }


}