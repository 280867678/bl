package com.example.boluouitest2.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.AdBannerBean;
import com.example.boluouitest2.comod.baselib.view.banner.BannerSimpleModel;
import com.example.boluouitest2.comod.baselib.view.banner.DefaultPageTransformer;
import com.example.boluouitest2.comod.baselib.view.banner.XBanner;
import com.example.boluouitest2.imgloader.ImgLoader;

import java.util.ArrayList;
import java.util.List;

public class CustomAdBannerUtil {



    /* renamed from: a */
    public static void m9489a(Context context, XBanner xBanner, int i, List<AdBannerBean> list) {
        m9490a(context, xBanner, i, new DefaultPageTransformer(), list);
    }


    /* renamed from: a */
    public static void m9490a(final Context context, XBanner xBanner, int i, ViewPager.PageTransformer pageTransformer, final List<AdBannerBean> list) {
        if (!(list == null || list.isEmpty())) {
            xBanner.setVisibility(View.VISIBLE);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(new BannerSimpleModel());
            }
            xBanner.setBannerData(i, arrayList);
            xBanner.setCustomPageTransformer(pageTransformer);
            xBanner.m20104a(new XBanner.AbstractC0900d() { // from class: e.c.a.k.a
                @Override // com.comod.baselib.view.banner.XBanner.AbstractC0900d
                /* renamed from: a */
                public final void mo9582a(XBanner xBanner2, Object obj, View view, int i3) {
                    CustomAdBannerUtil.m9488a(list, context, xBanner2, obj, view, i3);
                }
            });
            xBanner.setOnItemClickListener(new XBanner.AbstractC0899c() { // from class: e.c.a.k.b
                @Override // com.comod.baselib.view.banner.XBanner.AbstractC0899c
                /* renamed from: a */
                public final void mo9577a(XBanner xBanner2, Object obj, View view, int i3) {
                    CustomAdBannerUtil.m9486b(list, context, xBanner2, obj, view, i3);
                }
            });
        }
    }







    /* renamed from: b */
    public static /* synthetic */ void m9486b(List list, Context context, XBanner xBanner, Object obj, View view, int i) {
        try {
            AdBannerBean adBannerBean = (AdBannerBean) list.get(i);
            if (adBannerBean != null) {
                JumpUtil.m9417a().m9413a(context, adBannerBean.getType(), adBannerBean.getUrl());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* renamed from: a */
    public static /* synthetic */ void m9488a(List list, Context context, XBanner xBanner, Object obj, View view, int i) {
        AdBannerBean adBannerBean = (AdBannerBean) list.get(i);
        if (adBannerBean != null) {
            ImgLoader.m9425b(context, adBannerBean.getImgUrl(), (ImageView) view, R.drawable.bg_cover_default_horizontal);
        }
    }







    /* renamed from: d */
    public static void m9484d(Context context, XBanner xBanner) {
        LayoutParamsUtil.m9077a(xBanner, ScreenUtil.m9202b(context), 75, 20);
    }


    /* renamed from: c */
    public static void m9485c(Context context, XBanner xBanner) {
        ViewGroup.LayoutParams layoutParams = xBanner.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = ((ScreenUtil.m9202b(context) - (DpUtil.m9101a(context, 12) * 2)) * 8) / 35;
    }


    /* renamed from: a */
    public static void m9491a(Context context, XBanner xBanner) {
        ViewGroup.LayoutParams layoutParams = xBanner.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = ((ScreenUtil.m9202b(context) - (DpUtil.m9101a(context, 12) * 2)) * 13) / 35;
    }




}
