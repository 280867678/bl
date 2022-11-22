package com.example.boluouitest2.VHDelegate;



import android.view.View;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.AdBannerBean;
import com.example.boluouitest2.bean.BannerDataBean;
import com.example.boluouitest2.comod.baselib.view.banner.XBanner;
import com.example.boluouitest2.util.CustomAdBannerUtil;

import java.util.List;


/* renamed from: e.c.a.e.w0 */
/* loaded from: classes.dex */
public class MainVideoBannerVHDelegate extends VHDelegateImpl<BannerDataBean> {

    /* renamed from: g */
    public XBanner f12664g;

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_main_video_banner;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        this.f12664g = (XBanner) view.findViewById(R.id.banner);
        CustomAdBannerUtil.m9491a(m9232b(), this.f12664g);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(BannerDataBean bannerDataBean, int i) {
        super.mo9233a( bannerDataBean, i);
        try {
            List<AdBannerBean> adBannerBeans = bannerDataBean.getAdBannerBeans();
            if (adBannerBeans != null && !adBannerBeans.isEmpty()) {
                CustomAdBannerUtil.m9489a(m9232b(), this.f12664g, R.layout.xbanner_item_image, adBannerBeans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

