package com.example.boluouitest2.VHDelegate;



import android.view.View;
import android.widget.TextView;

import com.example.boluouitest2.R;
import com.example.boluouitest2.bean.VideoCollectInfoBean;
import com.example.boluouitest2.comod.baselib.view.CustomTextView;
import com.example.boluouitest2.imgloader.ImgLoader;
import com.example.boluouitest2.util.CustomWordUtil;
import com.example.boluouitest2.util.NumberUtil;
import com.makeramen.roundedimageview.RoundedImageView;

/* renamed from: e.c.a.e.j1 */
/* loaded from: classes.dex */
public class PersonalVideoCollectListVHDelegate extends VHDelegateImpl<VideoCollectInfoBean> {

    /* renamed from: g */
    public RoundedImageView f12476g;

    /* renamed from: h */
    public TextView f12477h;

    /* renamed from: i */
    public CustomTextView f12478i;

    /* renamed from: j */
    public CustomTextView f12479j;

    /* renamed from: k */
    public TextView f12480k;

    /* renamed from: l */
    public int f12481l;

    public PersonalVideoCollectListVHDelegate(int i) {
        this.f12481l = i;
    }

    /* renamed from: b */
    public final void m10090b(View view) {
        this.f12476g = (RoundedImageView) view.findViewById(R.id.img_cover);
        this.f12477h = (TextView) view.findViewById(R.id.tv_title);
        this.f12478i = (CustomTextView) view.findViewById(R.id.tv_like_num);
        this.f12479j = (CustomTextView) view.findViewById(R.id.tv_video_num);
        this.f12480k = (TextView) view.findViewById(R.id.tv_status);
        this.f12480k.setText(m9232b().getString(R.string.str_top));
        this.f12480k.setBackgroundResource(R.drawable.bg_img_top);
        this.f12480k.setVisibility(View.GONE);
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegateImpl
    /* renamed from: e */
    public int mo9228e() {
        return R.layout.item_personal_video_collect;
    }

    @Override // p067e.p130f.p131a.p133b.VHDelegate
    /* renamed from: a */
    public void mo9237a(View view) {
        m10090b(view);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo9233a(VideoCollectInfoBean videoCollectInfoBean, int i) {
        super.mo9233a( videoCollectInfoBean, i);
        if (videoCollectInfoBean != null) {
            try {
                this.f12477h.setText(CustomWordUtil.m9462a(videoCollectInfoBean.getTitle()));
                ImgLoader.m9425b(m9232b(), CustomWordUtil.m9462a(videoCollectInfoBean.getImage_url()), this.f12476g, R.drawable.bg_cover_default_horizontal);
                this.f12478i.setText(String.format("%s人喜欢", NumberUtil.m9067a(videoCollectInfoBean.getLike_count(), 1)));
                this.f12479j.setText(String.format("共%s集", String.valueOf(videoCollectInfoBean.getVideo_count())));
                if (this.f12481l == 1 && videoCollectInfoBean.getIs_top() == 1) {
                    this.f12480k.setVisibility(View.VISIBLE);
                } else {
                    this.f12480k.setVisibility(View.GONE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

