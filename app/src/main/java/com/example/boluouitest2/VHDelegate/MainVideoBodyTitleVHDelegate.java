package com.example.boluouitest2.VHDelegate;



import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.activity.VideoDailyMoreActivity;
import com.example.boluouitest2.activity.VideoHotRankActivity;
import com.example.boluouitest2.bean.MainVideoFeaturedBodyBean;
import com.example.boluouitest2.imgloader.ImgLoader;


/* renamed from: e.c.a.e.a1 */
/* loaded from: classes.dex */
public class MainVideoBodyTitleVHDelegate extends VHDelegateImpl<MainVideoFeaturedBodyBean> {

    /* renamed from: g */
    public TextView f12308g;

    /* renamed from: h */
    public TextView f12309h;

    /* renamed from: i */
    public ImageView f12310i;

    /* renamed from: j */
    public TextView f12311j;

    /* renamed from: k */
    public ImageView f12312k;

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_main_video_body_title;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        this.f12308g = (TextView) view.findViewById(R.id.tv_title);
        this.f12309h = (TextView) view.findViewById(R.id.tv_sub_title);
        this.f12310i = (ImageView) view.findViewById(R.id.img_type);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_title);
        this.f12311j = (TextView) view.findViewById(R.id.tv_more);
        this.f12312k = (ImageView) view.findViewById(R.id.img_more);
        this.f12311j.setVisibility(View.GONE);
        this.f12312k.setVisibility(View.GONE);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(MainVideoFeaturedBodyBean mainVideoFeaturedBodyBean, int i) {
        super.mo9233a( mainVideoFeaturedBodyBean, i);
        if (mainVideoFeaturedBodyBean != null) {
            if (!TextUtils.isEmpty(mainVideoFeaturedBodyBean.getName())) {
                this.f12308g.setText(mainVideoFeaturedBodyBean.getName());
            } else {
                this.f12308g.setText("");
            }
            if (!TextUtils.isEmpty(mainVideoFeaturedBodyBean.getSubName())) {
                this.f12309h.setText(mainVideoFeaturedBodyBean.getSubName());
            } else {
                this.f12309h.setText("");
            }
            if (!TextUtils.isEmpty(mainVideoFeaturedBodyBean.getIcon())) {
                ImgLoader.m9430a(m9232b(), mainVideoFeaturedBodyBean.getIcon(), this.f12310i, R.drawable.bg_rectangle_color_f5_radius_5);
            }
            if (!TextUtils.isEmpty(mainVideoFeaturedBodyBean.getType())) {
                String type = mainVideoFeaturedBodyBean.getType();
                char c = 65535;
                switch (type.hashCode()) {
                    case -1077891227:
                        if (type.equals("mei_ri")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -411724099:
                        if (type.equals("hot_topic")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -376920941:
                        if (type.equals("dou_xi_huan")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1844880608:
                        if (type.equals("dou_mai")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                if (c == 0 || c == 1 || c == 2 || c == 3) {
                    this.f12311j.setVisibility(View.VISIBLE);
                    this.f12312k.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9235a(View view, MainVideoFeaturedBodyBean mainVideoFeaturedBodyBean, int i) {
        super.mo9235a(view,  mainVideoFeaturedBodyBean, i);
        if (!TextUtils.isEmpty(mainVideoFeaturedBodyBean.getType())) {
            String type = mainVideoFeaturedBodyBean.getType();
            char c = 65535;
            switch (type.hashCode()) {
                case -1077891227:
                    if (type.equals("mei_ri")) {
                        c = 0;
                        break;
                    }
                    break;
                case -411724099:
                    if (type.equals("hot_topic")) {
                        c = 3;
                        break;
                    }
                    break;
                case -376920941:
                    if (type.equals("dou_xi_huan")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1844880608:
                    if (type.equals("dou_mai")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                VideoDailyMoreActivity.m20703a(m9232b());
            } else if (c == 1) {
                VideoHotRankActivity.m20671a(m9232b(), 1);
            } else if (c == 2) {
                VideoHotRankActivity.m20671a(m9232b(), 0);
            } else if (c == 3) {
                VideoHotRankActivity.m20671a(m9232b(), 2);
            }
        }
    }
}

